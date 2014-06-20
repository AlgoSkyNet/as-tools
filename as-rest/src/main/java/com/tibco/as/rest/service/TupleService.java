package com.tibco.as.rest.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.rest.exception.ConversionException;
import com.tibco.as.rest.exception.KeyFieldsCountException;
import com.tibco.as.rest.service.dto.KeyList;
import com.tibco.as.rest.service.dto.ResultList;
import com.tibco.as.rest.service.dto.TupleInfo;
import com.tibco.as.rest.util.ConversionUtils;
import com.tibco.as.rest.util.MetaspaceUtil;
import com.tibco.as.rest.util.SpacePool;
import com.tibco.as.rest.util.StringUtil;
import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.PutOptions;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.SpaceResult;
import com.tibco.as.space.SpaceResultList;
import com.tibco.as.space.TakeOptions;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.browser.Browser;
import com.tibco.as.space.browser.BrowserDef;

@Path("/metaspaces")
public class TupleService {

	private static Logger logger = LoggerFactory.getLogger(TupleService.class);

	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples/{key:.+}")
	@Produces({ MediaType.APPLICATION_XML })
	public TupleInfo getTupleXML(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@PathParam("key") @Encoded KeyList key) {
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);
		try {
			Tuple t = space.get(decodeKeys(spaceDef, key.getKeys()));
			if (t == null)
				return null;
			return makeTupleInfo(spaceName, spaceDef, t);
		} catch (Exception e) {
			logger.error("error occur when getTuple", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples/{key:.+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Map<String, Object> getTupleJSON(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@PathParam("key") @Encoded KeyList key) {
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);
		try {
			Tuple t = space.get(decodeKeys(spaceDef, key.getKeys()));
			if (t == null)
				return null;
			return makeMap(spaceDef, t);
		} catch (Exception e) {
			logger.error("error occur when getTuple", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public TupleInfo putTuple(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@DefaultValue("false") @HeaderParam("compareAndPut") boolean compareAndPut,
			Map<String, Object> tuple) {
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);

		try {
			Tuple newTuple = Tuple.create();
			Tuple oldTuple = Tuple.create();
			for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
				String fieldName = fieldDef.getName();
				Object value = ConversionUtils.decode(
						tuple.get(fieldDef.getName()), fieldDef.getType());

				if (value != null) {
					newTuple.put(fieldName, value);
				}

				if (compareAndPut) {
					Object oldTupleObject = tuple.get("oldTuple");
					if (oldTupleObject != null) {
						@SuppressWarnings("unchecked")
						Map<String, Object> oldMap = (Map<String, Object>) tuple
								.get("oldTuple");
						Object oldValue = ConversionUtils.decode(
								oldMap.get(fieldDef.getName()),
								fieldDef.getType());
						if (oldValue != null) {
							oldTuple.put(fieldName, oldValue);
						}
					} else {
						oldTuple = null;
					}
				}
			}

			PutOptions putOptions = makePutOptions(tuple);
			Tuple t;
			if (compareAndPut) {
				t = space.compareAndPut(oldTuple, newTuple, putOptions);
			} else {
				t = space.put(newTuple, putOptions);
			}
			return makeTupleInfo(spaceName, spaceDef, t);
		} catch (WebApplicationException we) {
			throw we;
		} catch (Exception e) {
			logger.error("error occur when putTuple", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples/all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResultList putTuples(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@DefaultValue("false") @HeaderParam("compareAndPutAll") boolean compareAndPutAll,
			List<Map<String, Object>> tuples) {
		logger.debug(tuples.toString() + "***tuples***");
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);

		List<Tuple> newTuples = new ArrayList<Tuple>();
		List<Tuple> oldTuples = new ArrayList<Tuple>();
		List<PutOptions> putOptionsList = new ArrayList<PutOptions>();

		try {
			for (Map<String, Object> tuple : tuples) {
				Tuple newTuple = Tuple.create();
				Tuple oldTuple = Tuple.create();
				for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
					String fieldName = fieldDef.getName();
					Object value = ConversionUtils.decode(
							tuple.get(fieldDef.getName()), fieldDef.getType());

					if (value != null) {
						newTuple.put(fieldName, value);
					}

					if (compareAndPutAll) {
						Object oldTupleObject = tuple.get("oldTuple");
						if (oldTupleObject != null) {
							@SuppressWarnings("unchecked")
							Map<String, Object> oldMap = (Map<String, Object>) tuple
									.get("oldTuple");
							Object oldValue = ConversionUtils.decode(
									oldMap.get(fieldDef.getName()),
									fieldDef.getType());
							if (oldValue != null) {
								oldTuple.put(fieldName, oldValue);
							}
						} else {
							oldTuple = null;
						}
					}
				}

				newTuples.add(newTuple);
				oldTuples.add(oldTuple);
				putOptionsList.add(makePutOptions(tuple));
			}

			SpaceResultList spaceResultList = null;
			if (compareAndPutAll) {
				spaceResultList = space.compareAndPutAll(oldTuples, newTuples,
						putOptionsList);
			} else {
				spaceResultList = space.putAll(newTuples, putOptionsList);
			}

			ResultList resultList = new ResultList();
			resultList.setHasError(spaceResultList.hasError());

			for (SpaceResult spaceResult : spaceResultList) {
				ResultList.Result result = new ResultList.Result();
				if (spaceResult.hasError()) {
					result.setHasError(spaceResult.hasError());
					result.setErrorMessage(spaceResult.getError().getMessage());
				} else {
					Tuple tuple = spaceResult.getTuple();
					if (tuple != null) {
						Map<String, Object> data = new LinkedHashMap<String, Object>();
						for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
							data.put(fieldDef.getName(), ConversionUtils
									.encode(tuple.get(fieldDef.getName()),
											fieldDef.getType()));
						}
						result.setData(data);
					}
				}
				resultList.getResultList().add(result);
			}
			return resultList;
		} catch (WebApplicationException we) {
			throw we;
		} catch (Exception e) {
			logger.error("error occur when putTuples", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public TupleInfo takeTuple(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@DefaultValue("false") @HeaderParam("compareAndTake") boolean compareAndTake,
			Map<String, Object> tuple) {
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);

		try {
			TakeOptions takeOptions = makeTakeOptions(tuple);

			Tuple t;
			Tuple takeTuple = Tuple.create();
			for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
				String fieldName = fieldDef.getName();
				Object oldValue = ConversionUtils.decode(
						tuple.get(fieldDef.getName()), fieldDef.getType());
				if (oldValue != null) {
					takeTuple.put(fieldName, oldValue);
				}
			}
			if (compareAndTake) {
				t = space.compareAndTake(takeTuple, takeOptions);
			} else {
				t = space.take(takeTuple, takeOptions);
			}
			return makeTupleInfo(spaceName, spaceDef, t);
		} catch (WebApplicationException we) {
			throw we;
		} catch (Exception e) {
			logger.error("error occur when takeTuple", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples/all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ResultList takeTuples(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@DefaultValue("false") @HeaderParam("compareAndTakeAll") boolean compareAndTakeAll,
			Map<String, Object> data) {
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		Space space = SpacePool.getSpace(metaspaceName, spaceName);

		List<Tuple> takeTuples = new ArrayList<Tuple>();
		TakeOptions takeOptions = makeTakeOptions(data.get("takeOptions"));

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> tuples = (List<Map<String, Object>>) data
				.get("tuples");

		try {
			for (Map<String, Object> tuple : tuples) {
				Tuple takeTuple = Tuple.create();
				for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
					String fieldName = fieldDef.getName();
					Object oldValue = ConversionUtils.decode(
							tuple.get(fieldDef.getName()), fieldDef.getType());
					if (oldValue != null) {
						takeTuple.put(fieldName, oldValue);
					}
				}
				takeTuples.add(takeTuple);
			}

			SpaceResultList spaceResultList = null;
			if (compareAndTakeAll) {
				spaceResultList = space.compareAndTakeAll(takeTuples,
						takeOptions);
			} else {
				spaceResultList = space.takeAll(takeTuples, takeOptions);
			}

			ResultList resultList = new ResultList();
			resultList.setHasError(spaceResultList.hasError());

			for (SpaceResult spaceResult : spaceResultList) {
				ResultList.Result result = new ResultList.Result();
				if (spaceResult.hasError()) {
					result.setHasError(spaceResult.hasError());
					result.setErrorMessage(spaceResult.getError().getMessage());
				} else {
					Tuple tuple = spaceResult.getTuple();
					System.out.println(tuple + "******resultTuple");
					if (tuple != null) {
						Map<String, Object> tupleData = new LinkedHashMap<String, Object>();
						for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
							tupleData.put(fieldDef.getName(), ConversionUtils
									.encode(tuple.get(fieldDef.getName()),
											fieldDef.getType()));
						}
						result.setData(tupleData);
					}
				}
				resultList.getResultList().add(result);
			}
			return resultList;
		} catch (WebApplicationException we) {
			throw we;
		} catch (Exception e) {
			logger.error("error occur when takeTuple", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/tuples")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<TupleInfo> getTuples(
			@PathParam("metaspaceName") String metaspaceName,
			@PathParam("spaceName") String spaceName,
			@MatrixParam("query") String query,
			@DefaultValue("100") @MatrixParam("limit") long limit) {
		Browser browser = null;
		List<TupleInfo> tupleInfos = null;
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);
		try {
			BrowserDef browserDef = BrowserDef.create(-1,
					BrowserDef.TimeScope.CURRENT,
					BrowserDef.DistributionScope.ALL);
			browserDef.setPrefetch(limit);

			if (StringUtil.isEmpty(query)) {
				browser = MetaspaceUtil.get(metaspaceName).browse(spaceName,
						BrowserDef.BrowserType.GET, browserDef);
			} else {
				browser = MetaspaceUtil.get(metaspaceName).browse(spaceName,
						BrowserDef.BrowserType.GET, browserDef, query);
			}

			tupleInfos = new ArrayList<TupleInfo>();
			long j = 0;
			for (;;) {
				Tuple tuple = browser.next();

				if (tuple == null)
					break;

				TupleInfo tupleInfo = new TupleInfo();
				tupleInfo.setSpaceName(spaceName);
				Map<String, Object> data = new LinkedHashMap<String, Object>();
				for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
					data.put(
							fieldDef.getName(),
							ConversionUtils.encode(
									tuple.get(fieldDef.getName()),
									fieldDef.getType()));
				}
				tupleInfo.setData(data);

				tupleInfos.add(tupleInfo);

				j++;
				if (j == limit)
					break;
			}

		} catch (Exception e) {
			logger.error("error occur when getTuples", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				browser.stop();
			} catch (ASException e) {
				logger.warn(e.getMessage());
			}
		}
		return tupleInfos;
	}

	private Tuple decodeKeys(SpaceDef spaceDef, List<String> keys)
			throws KeyFieldsCountException, ConversionException {
		Tuple k = Tuple.create();
		int i = 0;
		for (String fieldName : spaceDef.getKeyDef().getFieldNames()) {
			FieldDef fieldDef = spaceDef.getFieldDef(fieldName);
			if (i >= keys.size()) {
				throw new KeyFieldsCountException();
			}
			k.put(fieldName,
					ConversionUtils.decode(keys.get(i++), fieldDef.getType()));
		}
		if (i < keys.size()) {
			throw new KeyFieldsCountException();
		}
		return k;
	}

	private TupleInfo makeTupleInfo(String spaceName, SpaceDef spaceDef,
			Tuple tuple) throws ConversionException {
		if (tuple == null) {
			return null;
		}
		TupleInfo tupleInfo = new TupleInfo();
		tupleInfo.setSpaceName(spaceName);
		Map<String, Object> data = new LinkedHashMap<String, Object>();
		for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
			data.put(fieldDef.getName(), ConversionUtils.encode(
					tuple.get(fieldDef.getName()), fieldDef.getType()));
		}
		tupleInfo.setData(data);
		return tupleInfo;
	}

	public static Map<String, Object> makeMap(SpaceDef spaceDef, Tuple tuple) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
			map.put(fieldDef.getName(), ConversionUtils.encode(
					tuple.get(fieldDef.getName()), fieldDef.getType()));
		}
		return map;
	}

	@SuppressWarnings({ "unchecked" })
	private PutOptions makePutOptions(Map<String, Object> tuple) {
		Object putOptionsObject = tuple.get("putOptions");
		if (putOptionsObject != null) {
			Map<String, Object> putOptionsMap = (Map<String, Object>) putOptionsObject;
			PutOptions putOptions = PutOptions.create();
			if (putOptionsMap.get("forget") != null) {
				putOptions.setForget((Boolean) putOptionsMap.get("forget"));
			}
			if (putOptionsMap.get("lock") != null) {
				putOptions.setLock((Boolean) putOptionsMap.get("lock"));
			}
			if (putOptionsMap.get("lockWait") != null) {
				Long lockWait = null;
				if (putOptionsMap.get("lockWait") instanceof Integer) {
					lockWait = (long) (Integer) putOptionsMap.get("lockWait");
				} else if (putOptionsMap.get("lockWait") instanceof Long) {
					lockWait = (Long) putOptionsMap.get("lockWait");
				}

				putOptions.setLockWait(lockWait);
			}
			if (putOptionsMap.get("ttl") != null) {
				Long ttl = null;
				if (putOptionsMap.get("ttl") instanceof Integer) {
					ttl = (long) (Integer) putOptionsMap.get("ttl");
				} else if (putOptionsMap.get("ttl") instanceof Long) {
					ttl = (Long) putOptionsMap.get("ttl");
				}
				putOptions.setTTL(ttl);
			}
			if (putOptionsMap.get("route") != null) {
				putOptions.setRoute((Boolean) putOptionsMap.get("route"));
			}
			if (putOptionsMap.get("unlock") != null) {
				putOptions.setUnlock((Boolean) putOptionsMap.get("unlock"));
			}
			return putOptions;
		} else {
			return PutOptions.create();
		}
	}

	private TakeOptions makeTakeOptions(Map<String, Object> tuple) {
		if (tuple == null) {
			return TakeOptions.create();
		}

		Object takeOptionsObject = tuple.get("takeOptions");
		return makeTakeOptions(takeOptionsObject);
	}

	@SuppressWarnings({ "unchecked" })
	private TakeOptions makeTakeOptions(Object takeOptionsObject) {
		if (takeOptionsObject != null) {
			Map<String, Object> takeOptionsMap = (Map<String, Object>) takeOptionsObject;
			TakeOptions takeOptions = TakeOptions.create();
			if (takeOptionsMap.get("forget") != null) {
				takeOptions.setForget((Boolean) takeOptionsMap.get("forget"));
			}
			if (takeOptionsMap.get("lock") != null) {
				takeOptions.setLock((Boolean) takeOptionsMap.get("lock"));
			}
			if (takeOptionsMap.get("lockWait") != null) {
				Long lockWait = null;
				if (takeOptionsMap.get("lockWait") instanceof Integer) {
					lockWait = (long) (Integer) takeOptionsMap.get("lockWait");
				} else if (takeOptionsMap.get("lockWait") instanceof Long) {
					lockWait = (Long) takeOptionsMap.get("lockWait");
				}

				takeOptions.setLockWait(lockWait);
			}
			if (takeOptionsMap.get("route") != null) {
				takeOptions.setRoute((Boolean) takeOptionsMap.get("route"));
			}
			if (takeOptionsMap.get("unlock") != null) {
				takeOptions.setUnlock((Boolean) takeOptionsMap.get("unlock"));
			}
			return takeOptions;
		} else {
			return TakeOptions.create();
		}
	}

}