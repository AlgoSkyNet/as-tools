package com.tibco.as.rest.service;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.rest.exception.ConversionException;
import com.tibco.as.rest.service.dto.RemoteInvokeResult;
import com.tibco.as.rest.util.ConversionUtils;
import com.tibco.as.rest.util.MetaspaceUtil;
import com.tibco.as.rest.util.SpacePool;
import com.tibco.as.space.ASException;
import com.tibco.as.space.InvokeOptions;
import com.tibco.as.space.Member;
import com.tibco.as.space.Space;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.remote.InvokeResult;
import com.tibco.as.space.remote.InvokeResultList;

@Path("/metaspaces")
public class RemoteInvokeService {
	private static Logger logger = LoggerFactory
			.getLogger(RemoteInvokeService.class);

	@POST
	@Path("/{metaspaceName}/spaces/{spaceName}/remote/{type}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public RemoteInvokeResult invoke(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@PathParam("type") String type, Map<String, Object> contextMap) {
		Space space = SpacePool.getSpace(metaspaceName, spaceName);
		try {
			String className = (String) contextMap.get("className");
			if (type.equals("key")) {
				@SuppressWarnings("unchecked")
				Map<String, Object> key = (Map<String, Object>) contextMap
						.get("key");
				Tuple tuple = Tuple.create();
				Object value = ConversionUtils.decode(key.get("value"),
						(String) key.get("type"));
				if (value != null) {
					tuple.put((String) key.get("key"), value);
				}
				InvokeResult result = space.invoke(tuple, className,
						makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(result);
			} else if (type.equals("self")) {
				InvokeResult result = space.invokeMember(
						MetaspaceUtil.get(metaspaceName).getSelfMember(),
						className, makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(result);
			} else if (type.equals("seeders")) {
				Collection<Member> seeders = space.getSeeders();
				InvokeResultList results = space.invokeMembers(seeders,
						className, makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(results);
			} else if (type.equals("members")) {
				Collection<Member> members = space.getMembers();
				InvokeResultList results = space.invokeMembers(members,
						className, makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(results);
			} else if (type.equals("leeches")) {
				Collection<Member> leeches = space.getLeeches();
				InvokeResultList results = space.invokeMembers(leeches,
						className, makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(results);
			} else if (type.equals("remote")) {
				Collection<Member> remoteMembers = space.getRemoteMembers();
				InvokeResultList results = space.invokeMembers(remoteMembers,
						className, makeInvokeOptions(contextMap));
				return makeRemoteInvokeResult(results);
			} else {
				logger.error("Unrecognized option");
				return null;
			}
		} catch (ConversionException ce) {
			logger.error("error occur when decode:", ce);
			return null;
		} catch (ASException ae) {
			logger.error("error occur when invoke:", ae);
			return null;
		}
	}

	private InvokeOptions makeInvokeOptions(Map<String, Object> contextMap)
			throws ConversionException {
		InvokeOptions invokeOptions = InvokeOptions.create();

		Object contextObj = contextMap.get("context");
		if (contextObj != null) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> context = (List<Map<String, Object>>) contextObj;
			Tuple contextTuple = Tuple.create();
			for (Map<String, Object> field : context) {
				Object value = ConversionUtils.decode(field.get("value"),
						(String) field.get("type"));
				if (value != null) {
					contextTuple.put((String) field.get("key"), value);
				}
			}
			invokeOptions.setContext(contextTuple);
		}

		Object timeout = contextMap.get("timeout");

		if (timeout != null) {
			if (timeout instanceof Integer) {
				invokeOptions.setTimeout((Integer) timeout);
			} else if (timeout instanceof Long) {
				invokeOptions.setTimeout((Long) timeout);
			}
		}
		return invokeOptions;
	}

	private RemoteInvokeResult.Result makeResult(InvokeResult invokeResult) {
		RemoteInvokeResult.Result result = new RemoteInvokeResult.Result();
		result.setHasError(invokeResult.hasError());
		if (invokeResult.hasError()) {
			result.setErrorMessage(invokeResult.getError().getMessage());
			logger.error("remote invoke result error:", invokeResult.getError()
					.getCause());
		}

		result.getMember().setId(invokeResult.getMember().getId());
		result.getMember().setName(invokeResult.getMember().getName());
		result.getMember()
				.setAddress(invokeResult.getMember().getHostAddress());
		result.getMember().setManagementRole(
				invokeResult.getMember().getManagementRole().name());
		result.getMember().setPort(invokeResult.getMember().getPort());
		result.getMember().setJoinTime(
				invokeResult.getMember().getJoinTime().getTime());

		Tuple returnTuple = invokeResult.getReturn();

		if (returnTuple != null) {
			Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
			for (String key : returnTuple.keySet()) {
				resultMap.put(key, returnTuple.get(key));
			}
			result.setResult(resultMap);
		}
		return result;
	}

	private RemoteInvokeResult makeRemoteInvokeResult(InvokeResult invokeResult) {
		RemoteInvokeResult remoteInvokeResult = new RemoteInvokeResult();
		remoteInvokeResult.setResultSize(1);
		remoteInvokeResult.setHasError(invokeResult.hasError());
		remoteInvokeResult.getResults().add(makeResult(invokeResult));
		return remoteInvokeResult;
	}

	private RemoteInvokeResult makeRemoteInvokeResult(
			InvokeResultList invokeResultList) {
		RemoteInvokeResult remoteInvokeResult = new RemoteInvokeResult();
		remoteInvokeResult.setResultSize(invokeResultList.size());
		remoteInvokeResult.setHasError(invokeResultList.hasError());

		for (InvokeResult result : invokeResultList) {
			remoteInvokeResult.getResults().add(makeResult(result));
		}
		return remoteInvokeResult;
	}
}
