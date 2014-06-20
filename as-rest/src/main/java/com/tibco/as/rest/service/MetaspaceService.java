package com.tibco.as.rest.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.rest.service.dto.MembersInfo;
import com.tibco.as.rest.service.dto.MetaspaceInfo;
import com.tibco.as.rest.service.dto.MetaspaceNames;
import com.tibco.as.rest.util.MetaspaceUtil;
import com.tibco.as.space.ASException;
import com.tibco.as.space.Member;
import com.tibco.as.space.MemberDef;

@Path("/metaspaces")
public class MetaspaceService {

	private static Logger logger = LoggerFactory
			.getLogger(MetaspaceService.class);

	@GET
	@Path(".")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MetaspaceNames getMetaspaces() {
		return new MetaspaceNames(MetaspaceUtil.getMetaspaceNames());
	}

	@GET
	@Path("/{metaspaceName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MetaspaceInfo getMemberDef(
			@PathParam("metaspaceName") String metaspaceName) {
		MemberDef memberDef = MetaspaceUtil.get(metaspaceName).getMemberDef();
		MetaspaceInfo metaspaceInfo = new MetaspaceInfo();

		metaspaceInfo.setDiscovery(memberDef.getDiscovery());
		metaspaceInfo.setListen(memberDef.getListen());
		metaspaceInfo.setMemberName(memberDef.getMemberName());
		metaspaceInfo.setName(metaspaceName);

		return metaspaceInfo;
	}

	@GET
	@Path("/{metaspaceName}/members")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public MembersInfo getMembers(
			@PathParam("metaspaceName") String metaspaceName) {
		Collection<Member> members = null;
		MembersInfo membersInfo = new MembersInfo();
		try {
			members = MetaspaceUtil.get(metaspaceName).getMetaspaceMembers();
			for (Member member : members) {
				MembersInfo.Member m = MembersInfo.createMember();
				m.setId(member.getId());
				m.setName(member.getName());
				m.setManagementRole(member.getManagementRole().name());
				m.setAddress(member.getHostAddress());
				m.setJoinTime(member.getJoinTime().getTime());
				m.setPort(member.getPort());
				membersInfo.getMembers().add(m);
			}
		} catch (ASException e) {
			logger.error("error occur when getMembers:", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}

		return membersInfo;
	}
}