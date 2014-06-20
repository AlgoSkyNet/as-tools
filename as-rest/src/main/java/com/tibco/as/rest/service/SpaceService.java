package com.tibco.as.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.tibco.as.rest.service.dto.MembersInfo;
import com.tibco.as.rest.service.dto.SpaceInfo;
import com.tibco.as.rest.service.dto.SpaceNames;
import com.tibco.as.rest.service.dto.SpaceInfo.Field;
import com.tibco.as.rest.service.dto.SpaceInfo.Index;
import com.tibco.as.rest.service.dto.SpaceStatsInfo.SpaceStats;
import com.tibco.as.rest.service.dto.SpaceStatsInfo;
import com.tibco.as.rest.util.MetaspaceUtil;
import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.IndexDef;
import com.tibco.as.space.KeyDef;
import com.tibco.as.space.Member;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.browser.Browser;
import com.tibco.as.space.browser.BrowserDef;

import com.tibco.as.space.SpaceDef.CachePolicy;
import com.tibco.as.space.SpaceDef.DistributionPolicy;
import com.tibco.as.space.SpaceDef.EvictionPolicy;
import com.tibco.as.space.SpaceDef.LockScope;
import com.tibco.as.space.SpaceDef.PersistencePolicy;
import com.tibco.as.space.SpaceDef.PersistenceType;
import com.tibco.as.space.SpaceDef.ReplicationPolicy;
import com.tibco.as.space.SpaceDef.UpdateTransport;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.IndexDef.IndexType;

@Path("/metaspaces")
public class SpaceService {

	private static Logger logger = LoggerFactory.getLogger(SpaceService.class);
			
	@GET
	@Path("/{metaspaceName}/spaces")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SpaceNames getSpaces(@PathParam("metaspaceName") String metaspaceName) {		
		try {
			Collection<String> spaceNames = MetaspaceUtil.get(metaspaceName).getUserSpaceNames();
			return new SpaceNames(new ArrayList<String>(spaceNames));
		} catch (ASException e) {
			logger.error("error occur when getSpaces", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/def")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SpaceInfo getSpaceDef(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName) {		
		SpaceDef spaceDef = MetaspaceUtil.getSpaceDef(metaspaceName, spaceName);

		SpaceInfo spaceInfo = new SpaceInfo();
		spaceInfo.setCachePolicy(spaceDef.getCachePolicy().name());
		spaceInfo.setCapacity(spaceDef.getCapacity());
		spaceInfo.setDistributionFields(spaceDef.getDistributionFields());
		spaceInfo.setDistributionPolicy(spaceDef.getDistributionPolicy().name());
		spaceInfo.setEvictionPolicy(spaceDef.getEvictionPolicy().name());
		
		Collection<Field> fields = new ArrayList<Field>();
		Collection<FieldDef> fieldDefs = spaceDef.getFieldDefs();
		for(FieldDef fieldDef : fieldDefs){
			Field field = new Field();
			field.setName(fieldDef.getName());
			field.setType(fieldDef.getType().name());
			field.setNullable(fieldDef.isNullable());
			fields.add(field);
		}
		spaceInfo.setFields(fields);
		
		Collection<Index> indexes = new ArrayList<Index>();
		Collection<IndexDef> indexDefs = spaceDef.getIndexDefList();
		for(IndexDef indexDef : indexDefs){
			Index index = new Index();
			index.setName(indexDef.getName());
			index.setIndexType(indexDef.getIndexType().name());
			index.setFieldNames(indexDef.getFieldNames());
			indexes.add(index);
		}
		spaceInfo.setIndexes(indexes);

		spaceInfo.setKeyFieldNames(spaceDef.getKeyDef().getFieldNames());
		spaceInfo.setKeyIndexType(spaceDef.getKeyDef().getIndexType().name());
		
		spaceInfo.setLockScope(spaceDef.getLockScope().name());
		spaceInfo.setLockTTL(spaceDef.getLockTTL());
		spaceInfo.setLockWait(spaceDef.getLockWait());
		spaceInfo.setMinSeederCount(spaceDef.getMinSeederCount());
		spaceInfo.setName(spaceDef.getName());
		spaceInfo.setPersistenceDistributionPolicy(spaceDef.getPersistenceDistributionPolicy().name());
		spaceInfo.setPersistencePolicy(spaceDef.getPersistencePolicy().name());
		spaceInfo.setPersistenceType(spaceDef.getPersistenceType().name());
		spaceInfo.setPhaseCount(spaceDef.getPhaseCount());
		spaceInfo.setPhaseInterval(spaceDef.getPhaseInterval());
		spaceInfo.setReadTimeout(spaceDef.getReadTimeout());
		spaceInfo.setReplicationCount(spaceDef.getReplicationCount());
		spaceInfo.setReplicationPolicy(spaceDef.getReplicationPolicy().name());
		spaceInfo.setSpaceWait(spaceDef.getSpaceWait());
		spaceInfo.setTTL(spaceDef.getTTL());
		spaceInfo.setUpdateTransport(spaceDef.getUpdateTransport().name());
		spaceInfo.setVirtualNodeCount(spaceDef.getVirtualNodeCount());
		spaceInfo.setWriteTimeout(spaceDef.getWriteTimeout());
		spaceInfo.setForgetOldValue(spaceDef.isForgetOldValue());
		spaceInfo.setHostAwareReplication(spaceDef.isHostAwareReplication());

		return spaceInfo;
	}	
	
	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/stats")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SpaceStatsInfo getSpaceStats(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName) {		

		Browser browser = null;
		try {
			browser = MetaspaceUtil.get(metaspaceName).browse(
					"$space_stats", 
					BrowserDef.BrowserType.GET, 
					BrowserDef.create(),
					String.format("space_name=\"%s\"", spaceName));
			
			SpaceStatsInfo spaceStatsInfo = new SpaceStatsInfo();
			List<SpaceStats> spaceStatsList = new ArrayList<SpaceStats>();
			
			for (;;) {
				Tuple spaceStatsTuple = browser.next();
				if (spaceStatsTuple==null) break;
	
				SpaceStats spaceStats = new SpaceStats();
				
				spaceStats.setSpaceName(spaceStatsTuple.getString("space_name"));
				spaceStats.setMemberId(spaceStatsTuple.getString("member_id"));
				spaceStats.setOriginalCount(spaceStatsTuple.getLong("original_count"));
				spaceStats.setReplicaCount(spaceStatsTuple.getLong("replica_count"));
				spaceStats.setPutCount(spaceStatsTuple.getLong("put_count"));
				spaceStats.setGetCount(spaceStatsTuple.getLong("get_count"));
				spaceStats.setTakeCount(spaceStatsTuple.getLong("take_count"));
				spaceStats.setExpireCount(spaceStatsTuple.getLong("expire_count"));
				spaceStats.setEvictCount(spaceStatsTuple.getLong("evict_count"));
				spaceStats.setLockCount(spaceStatsTuple.getLong("lock_count"));
				spaceStats.setUnlockCount(spaceStatsTuple.getLong("unlock_count"));
				spaceStats.setInvokeCount(spaceStatsTuple.getLong("invoke_count"));
				spaceStats.setQueryCount(spaceStatsTuple.getLong("query_count"));
				spaceStats.setMissCount(spaceStatsTuple.getLong("miss_count"));
				
				spaceStatsList.add(spaceStats);
			}
			spaceStatsInfo.setSpaceStats(spaceStatsList);
			return spaceStatsInfo;
		} catch (ASException e) {
			logger.error("error occur when getSpaceStats", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				browser.stop();
			} catch (ASException e) {
				logger.warn(e.getMessage());
			}
		}		
	}
	
	@GET
	@Path("/{metaspaceName}/spaces/{spaceName}/members")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MembersInfo getSpaceMembers(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName) {		
		Collection<Member> members = null;
		MembersInfo membersInfo = new MembersInfo();
		try {
			members = MetaspaceUtil.get(metaspaceName).getSpaceMembers(spaceName);
			for(Member member : members){
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
	
	@DELETE
	@Path("/{metaspaceName}/spaces/{spaceName}")
	public void dropSpace(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName){
		try {
			MetaspaceUtil.get(metaspaceName).dropSpace(spaceName);
		} catch (ASException e) {
			logger.error("error occur when dropSpace:", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);		}
	}

	@PUT
	@Path("/{metaspaceName}/spaces/{spaceName}")
	public void alterSpace(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName, SpaceInfo spaceInfo){
		logger.debug(spaceInfo.toString());
		SpaceDef spaceDef = null;
		try {
			spaceDef = MetaspaceUtil.get(metaspaceName).getSpaceDef(spaceName);
		} catch (ASException e) {
			logger.error("error occur when alterSpace:", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		
		if (spaceDef!=null) {
			if(spaceInfo.getFields() != null){
				for (SpaceInfo.Field field : spaceInfo.getFields()) {
					FieldDef fieldDef = spaceDef.getFieldDef(field.getName());
					if (fieldDef==null) {
						fieldDef = FieldDef.create(field.getName(), FieldType.getFieldType(field.getType().toUpperCase()));
						fieldDef.setNullable(true);
						spaceDef.putFieldDef(fieldDef);
					}
				}
			}
	
			if (spaceInfo.getIndexes()!=null) {
				for (SpaceInfo.Index index : spaceInfo.getIndexes()) {
					IndexDef indexDef = spaceDef.getIndexDef(index.getName());
					if (indexDef==null) {
						indexDef = IndexDef.create(index.getName());
						indexDef.setName(index.getName());
						if (index.getIndexType()!=null){
							indexDef.setIndexType(IndexType.getIndexType(index.getIndexType()));
						}
						indexDef.setFieldNames(index.getFieldNames().toArray(new String[index.getFieldNames().size()]));
						spaceDef.addIndexDef(indexDef);
					}
				}
	
				for (IndexDef indexDef : new ArrayList<IndexDef>(spaceDef.getIndexDefList())) {
					boolean found = false;
					for (SpaceInfo.Index index : spaceInfo.getIndexes()) {
						found = index.getName().equals(indexDef.getName());
						if (found) break;
					}
					if (!found) {
						spaceDef.removeIndexDef(indexDef.getName());
					}
				}
			}
	
			try {
				MetaspaceUtil.get(metaspaceName).alterSpace(spaceDef);
			} catch (ASException e) {
				logger.error("error occur when alterSpace:", e);
				throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
			}		
		}else{
			logger.error("can not found " + spaceName);
			throw new WebApplicationException(Status.NOT_FOUND);			
		}
	}
	
	@POST
	@Path("/{metaspaceName}/spaces/{spaceName}")
	public void createSpace(@PathParam("metaspaceName") String metaspaceName, @PathParam("spaceName") String spaceName, SpaceInfo spaceInfo){
		logger.debug(spaceInfo.toString());
		SpaceDef spaceDef;
		try {
			spaceDef = MetaspaceUtil.get(metaspaceName).getSpaceDef(spaceName);
		} catch (ASException e) {
			logger.error("error occur when createSpace:", e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
		}
		
		if (spaceDef==null) {
			spaceDef = SpaceDef.create();
			spaceDef.setName(spaceName);
			for (SpaceInfo.Field field : spaceInfo.getFields()) {
				FieldDef fieldDef = FieldDef.create(field.getName(), FieldType.getFieldType(field.getType().toUpperCase()));
				if (field.getNullable()!=null){
					fieldDef.setNullable(field.getNullable());
				}
				spaceDef.putFieldDef(fieldDef);
			}

			KeyDef keyDef = KeyDef.create();
			keyDef.setFieldNames(spaceInfo.getKeyFieldNames().toArray(new String[spaceInfo.getKeyFieldNames().size()]));
			if(spaceInfo.getKeyIndexType()!=null){
				keyDef.setIndexType(IndexType.getIndexType(spaceInfo.getKeyIndexType()));
			}
			spaceDef.setKeyDef(keyDef);

			if (spaceInfo.getIndexes()!=null){
				for (SpaceInfo.Index index : spaceInfo.getIndexes()) {
					IndexDef indexDef = IndexDef.create(index.getName());
					indexDef.setName(index.getName());
					if (index.getIndexType()!=null){
						indexDef.setIndexType(IndexType.getIndexType(index.getIndexType()));
					}
					indexDef.setFieldNames(index.getFieldNames().toArray(new String[index.getFieldNames().size()]));
					spaceDef.addIndexDef(indexDef);
				}
			}

			if (spaceInfo.getCapacity()!=null){
				spaceDef.setCapacity(spaceInfo.getCapacity());
			}

			if (spaceInfo.getTTL()!=null){
				spaceDef.setTTL(spaceInfo.getTTL());
			}

			if (spaceInfo.getCachePolicy()!=null){
				spaceDef.setCachePolicy(CachePolicy.valueOf(spaceInfo.getCachePolicy().toUpperCase()));
			}

			if (spaceInfo.getEvictionPolicy()!=null){
				spaceDef.setEvictionPolicy(EvictionPolicy.valueOf(spaceInfo.getEvictionPolicy().toUpperCase()));
			}

			if (spaceInfo.getReplicationCount()!=null){
				spaceDef.setReplicationCount(spaceInfo.getReplicationCount());
			}

			if (spaceInfo.getReplicationPolicy()!=null){
				spaceDef.setReplicationPolicy(ReplicationPolicy.valueOf(spaceInfo.getReplicationPolicy().toUpperCase()));
			}

			if (spaceInfo.getPersistenceType()!=null){
				spaceDef.setPersistenceType(PersistenceType.valueOf(spaceInfo.getPersistenceType().toUpperCase()));
			}
			
			if (spaceInfo.getPersistencePolicy()!=null){
				spaceDef.setPersistencePolicy(PersistencePolicy.valueOf(spaceInfo.getPersistencePolicy().toUpperCase()));
			}

			if (spaceInfo.getPersistenceDistributionPolicy()!=null){
				spaceDef.setPersistenceDistributionPolicy(DistributionPolicy.valueOf(spaceInfo.getPersistenceDistributionPolicy().toUpperCase()));
			}

			if (spaceInfo.getMinSeederCount()!=null){
				spaceDef.setMinSeederCount(spaceInfo.getMinSeederCount());
			}
			
			if (spaceInfo.getDistributionPolicy()!=null){
				spaceDef.setDistributionPolicy(DistributionPolicy.valueOf(spaceInfo.getDistributionPolicy().toUpperCase()));
			}
			
			if (spaceInfo.getDistributionFields()!=null){
				spaceDef.setDistributionFields(spaceInfo.getDistributionFields().toArray(new String[spaceInfo.getDistributionFields().size()]));
			}
			
			if (spaceInfo.getUpdateTransport()!=null){
				spaceDef.setUpdateTransport(UpdateTransport.valueOf(spaceInfo.getUpdateTransport().toUpperCase()));
			}

			if (spaceInfo.getLockScope()!=null){
				spaceDef.setLockScope(LockScope.valueOf(spaceInfo.getLockScope().toUpperCase()));
			}
			
			if (spaceInfo.getLockTTL()!=null){
				spaceDef.setLockTTL(spaceInfo.getLockTTL());
			}

			if (spaceInfo.getLockWait()!=null){
				spaceDef.setLockWait(spaceInfo.getLockWait());
			}

			if (spaceInfo.getPhaseCount()!=null){
				spaceDef.setPhaseCount(spaceInfo.getPhaseCount());
			}

			if (spaceInfo.getPhaseInterval()!=null){
				spaceDef.setPhaseInterval(spaceInfo.getPhaseInterval());
			}

			if (spaceInfo.getVirtualNodeCount()!=null){
				spaceDef.setVirtualNodeCount(spaceInfo.getVirtualNodeCount());
			}

			if (spaceInfo.getSpaceWait()!=null){
				spaceDef.setSpaceWait(spaceInfo.getSpaceWait());
			}

			if (spaceInfo.getReadTimeout()!=null){
				spaceDef.setReadTimeout(spaceInfo.getReadTimeout());
			}

			if (spaceInfo.getWriteTimeout()!=null){
				spaceDef.setWriteTimeout(spaceInfo.getWriteTimeout());
			}

			if (spaceInfo.isForgetOldValue()!=null){
				spaceDef.setForgetOldValue(spaceInfo.isForgetOldValue());
			}

			if (spaceInfo.isHostAwareReplication()!=null){
				spaceDef.setForgetOldValue(spaceInfo.isHostAwareReplication());
			}		
		
			try {
				MetaspaceUtil.get(metaspaceName).defineSpace(spaceDef);
			} catch (ASException e) {
				logger.error("error occur when createSpace:", e);
				throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR);
			}

		}else{
			logger.error(spaceName + " has already exist.");
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}	
}