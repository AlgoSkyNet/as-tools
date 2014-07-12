package com.tibco.as.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.IndexDef;
import com.tibco.as.space.KeyDef;
import com.tibco.as.space.Member;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.util.Utils;

public class MetaspaceManager {

	final private static ThreadLocal<DatatypeFactory> datatypeFactoryHolder = new ThreadLocal<DatatypeFactory>() {
		@Override
		protected DatatypeFactory initialValue() {
			try {
				return DatatypeFactory.newInstance();
			} catch (DatatypeConfigurationException e) {
				throw new IllegalStateException("failed to create "
						+ DatatypeFactory.class.getSimpleName(), e);
			}
		}
	};

	private static final String FILENAME = "metaspaces.xml";

	private static MetaspaceManager instance;

	private MetaspaceManager() {
	}

	public static MetaspaceManager getInstance() throws JAXBException,
			IOException, ASException {
		if (instance == null) {
			instance = new MetaspaceManager();
			File file = new File(FILENAME);
			if (file.exists()) {
				add(XMLFactory.unmarshall(file, Metaspaces.class));
			}
			InputStream in = ClassLoader.getSystemResourceAsStream(FILENAME);
			if (in != null) {
				add(XMLFactory.unmarshall(in, Metaspaces.class));
			}
		}
		return instance;
	}

	private static void add(Metaspaces metaspaces) throws ASException {
		for (com.tibco.as.xml.Metaspace metaspace : metaspaces.getMetaspace()) {
			instance.add(metaspace);
		}
	}

	private Metaspaces metaspaces = new Metaspaces();

	private List<Metaspace> connectedMetaspaces = new ArrayList<Metaspace>();

	public void add(com.tibco.as.xml.Metaspace metaspace) throws ASException {
		metaspaces.getMetaspace().add(metaspace);
	}

	public Metaspace connect(com.tibco.as.xml.Metaspace metaspace)
			throws ASException {
		Metaspace ms = Utils.getMetaspace(metaspace.getName());
		if (ms == null) {
			ms = Metaspace
					.connect(metaspace.getName(), getMemberDef(metaspace));
			connectedMetaspaces.add(ms);
		}
		return ms;
	}

	private MemberDef getMemberDef(com.tibco.as.xml.Metaspace metaspace) {
		MemberDef memberDef = MemberDef.create();
		memberDef.setMemberName(metaspace.getMember());
		if (metaspace.isRemote()) {
			memberDef.setRemoteDiscovery(metaspace.getDiscovery());
			memberDef.setRemoteListen(metaspace.getListen());
		} else {
			memberDef.setDiscovery(metaspace.getDiscovery());
			memberDef.setListen(metaspace.getListen());
		}
		if (metaspace.getConnectTimeout() != null) {
			memberDef.setConnectTimeout(metaspace.getConnectTimeout());
		}
		return memberDef;
	}

	public List<Metaspace> getConnectedMetaspaces() {
		return new ArrayList<Metaspace>(connectedMetaspaces);
	}

	public static com.tibco.as.xml.Metaspace getMetaspace(Metaspace metaspace) {
		com.tibco.as.xml.Metaspace xmlMetaspace = new com.tibco.as.xml.Metaspace();
		MemberDef memberDef = metaspace.getMemberDef();
		if (memberDef.getRemoteDiscovery() == null
				|| memberDef.getRemoteDiscovery().isEmpty()) {
			xmlMetaspace.setDiscovery(memberDef.getDiscovery());
		} else {
			xmlMetaspace.setDiscovery(memberDef.getRemoteDiscovery());
			xmlMetaspace.setRemote(true);
		}
		xmlMetaspace.setListen(memberDef.getListen());
		xmlMetaspace.setMember(memberDef.getMemberName());
		xmlMetaspace.setName(metaspace.getName());
		xmlMetaspace.setConnectTimeout(memberDef.getConnectTimeout());
		return xmlMetaspace;
	}

	public static com.tibco.as.xml.Space getSpace(SpaceDef spaceDef) {
		com.tibco.as.xml.Space space = new com.tibco.as.xml.Space();
		space.setCachePolicy(spaceDef.getCachePolicy());
		space.setCapacity(spaceDef.getCapacity());
		space.setDistributionPolicy(spaceDef.getDistributionPolicy());
		space.setEvictionPolicy(spaceDef.getEvictionPolicy());
		if (Utils.hasSpaceDefMethod("getFileSyncInterval")) {
			space.setFileSyncInterval(spaceDef.getFileSyncInterval());
		}
		space.setForgetOldValue(spaceDef.isForgetOldValue());
		space.setHostAwareReplication(spaceDef.isHostAwareReplication());
		space.setKeyIndexType(spaceDef.getKeyDef().getIndexType());
		space.setLockScope(spaceDef.getLockScope());
		space.setLockTTL(spaceDef.getLockTTL());
		space.setLockWait(spaceDef.getLockWait());
		space.setMinSeederCount(spaceDef.getMinSeederCount());
		space.setName(spaceDef.getName());
		space.setPersistenceDistributionPolicy(spaceDef
				.getPersistenceDistributionPolicy());
		space.setPersistencePolicy(spaceDef.getPersistencePolicy());
		space.setPersistenceType(spaceDef.getPersistenceType());
		space.setPhaseCount(spaceDef.getPhaseCount());
		if (Utils.hasSpaceDefMethod("getPhaseRatio")) {
			space.setPhaseRatio(spaceDef.getPhaseRatio());
		}
		if (Utils.hasSpaceDefMethod("getQueryLimit")) {
			space.setQueryLimit(spaceDef.getQueryLimit());
		}
		if (Utils.hasSpaceDefMethod("getQueryTimeout")) {
			space.setQueryTimeout(spaceDef.getQueryTimeout());
		}
		space.setReadTimeout(spaceDef.getReadTimeout());
		space.setReplicationCount(spaceDef.getReplicationCount());
		space.setReplicationPolicy(spaceDef.getReplicationPolicy());
		if (Utils.hasSpaceDefMethod("isRouted")) {
			space.setRouted(spaceDef.isRouted());
		}
		space.setSpaceWait(spaceDef.getSpaceWait());
		space.setTtl(spaceDef.getTTL());
		space.setUpdateTransport(spaceDef.getUpdateTransport());
		space.setVirtualNodeCount(spaceDef.getVirtualNodeCount());
		space.setWriteTimeout(spaceDef.getWriteTimeout());
		Collection<String> distribution = new ArrayList<String>();
		if (Utils.hasSpaceDefMethod("getDistributionFields")) {
			if (spaceDef.getDistributionFields() != null) {
				distribution = spaceDef.getDistributionFields();
			}
		}
		Collection<String> keys = spaceDef.getKeyDef().getFieldNames();
		if (keys == null) {
			keys = new ArrayList<String>();
		}
		for (FieldDef fieldDef : spaceDef.getFieldDefs()) {
			Field field = new Field();
			String fieldName = fieldDef.getName();
			field.setName(fieldName);
			field.setType(fieldDef.getType());
			field.setNullable(fieldDef.isNullable());
			field.setKey(keys.contains(fieldName));
			field.setDistribution(distribution.contains(fieldName));
			if (Utils.hasFieldDefMethod("isEncrypted")) {
				field.setEncrypted(fieldDef.isEncrypted());
			}
			space.getField().add(field);
		}
		for (IndexDef indexDef : spaceDef.getIndexDefList()) {
			Index index = new Index();
			index.setName(indexDef.getName());
			index.setType(indexDef.getIndexType());
			space.getIndex().add(index);
		}
		return space;
	}

	public static SpaceDef getSpaceDef(com.tibco.as.xml.Space space) {
		SpaceDef spaceDef = SpaceDef.create();
		if (space.getCachePolicy() != null) {
			spaceDef.setCachePolicy(space.getCachePolicy());
		}
		if (space.getCapacity() != null) {
			spaceDef.setCapacity(space.getCapacity());
		}
		if (space.getDistributionPolicy() != null) {
			spaceDef.setDistributionPolicy(space.getDistributionPolicy());
		}
		if (space.getEvictionPolicy() != null) {
			spaceDef.setEvictionPolicy(space.getEvictionPolicy());
		}
		if (space.getFileSyncInterval() != null) {
			if (Utils.hasSpaceDefMethod("setFileSyncInterval")) {
				spaceDef.setFileSyncInterval(space.getFileSyncInterval());
			}
		}
		if (space.isForgetOldValue() != null) {
			spaceDef.setForgetOldValue(space.isForgetOldValue());
		}
		if (space.isHostAwareReplication() != null) {
			spaceDef.setHostAwareReplication(space.isHostAwareReplication());
		}
		if (space.getLockScope() != null) {
			spaceDef.setLockScope(space.getLockScope());
		}
		if (space.getLockTTL() != null) {
			spaceDef.setLockTTL(space.getLockTTL());
		}
		if (space.getLockWait() != null) {
			spaceDef.setLockWait(space.getLockWait());
		}
		if (space.getMinSeederCount() != null) {
			spaceDef.setMinSeederCount(space.getMinSeederCount());
		}
		if (space.getName() != null) {
			spaceDef.setName(space.getName());
		}
		if (space.getPersistenceDistributionPolicy() != null) {
			spaceDef.setPersistenceDistributionPolicy(space
					.getPersistenceDistributionPolicy());
		}
		if (space.getPersistencePolicy() != null) {
			spaceDef.setPersistencePolicy(space.getPersistencePolicy());
		}
		if (space.getPersistenceType() != null) {
			spaceDef.setPersistenceType(space.getPersistenceType());
		}
		if (space.getPhaseCount() != null) {
			spaceDef.setPhaseCount(space.getPhaseCount());
		}
		if (space.getPhaseRatio() != null) {
			if (Utils.hasSpaceDefMethod("setPhaseRatio")) {
				spaceDef.setPhaseRatio(space.getPhaseRatio());
			}
		}
		if (space.getQueryLimit() != null) {
			if (Utils.hasSpaceDefMethod("setQueryLimit")) {
				spaceDef.setQueryLimit(space.getQueryLimit());
			}
		}
		if (space.getQueryTimeout() != null) {
			if (Utils.hasSpaceDefMethod("setQueryTimeout")) {
				spaceDef.setQueryTimeout(space.getQueryTimeout());
			}
		}
		if (space.getReadTimeout() != null) {
			spaceDef.setReadTimeout(space.getReadTimeout());
		}
		if (space.getReplicationCount() == null) {
			spaceDef.setReplicationCount(space.getReplicationCount());
		}
		if (space.getReplicationPolicy() != null) {
			spaceDef.setReplicationPolicy(space.getReplicationPolicy());
		}
		if (space.isRouted() != null) {
			if (Utils.hasSpaceDefMethod("setRouted")) {
				spaceDef.setRouted(space.isRouted());
			}
		}
		if (space.getSpaceWait() != null) {
			spaceDef.setSpaceWait(space.getSpaceWait());
		}
		if (space.getTtl() != null) {
			spaceDef.setTTL(space.getTtl());
		}
		if (space.getUpdateTransport() != null) {
			spaceDef.setUpdateTransport(space.getUpdateTransport());
		}
		if (space.getVirtualNodeCount() != null) {
			spaceDef.setVirtualNodeCount(space.getVirtualNodeCount());
		}
		if (space.getWriteTimeout() != null) {
			spaceDef.setWriteTimeout(space.getWriteTimeout());
		}
		Collection<String> keys = new ArrayList<String>();
		Collection<String> distribution = new ArrayList<String>();
		for (Field field : space.getField()) {
			FieldDef fieldDef = FieldDef.create(field.getName(),
					field.getType());
			if (field.isEncrypted() != null) {
				if (Utils.hasFieldDefMethod("setEncrypted")) {
					fieldDef.setEncrypted(field.isEncrypted());
				}
			}
			if (field.isNullable() != null) {
				fieldDef.setNullable(field.isNullable());
			}
			spaceDef.putFieldDef(fieldDef);
			if (Boolean.TRUE.equals(field.isKey())) {
				keys.add(field.getName());
			}
			if (Boolean.TRUE.equals(field.isDistribution())) {
				distribution.add(field.getName());
			}
		}
		KeyDef keyDef = spaceDef.getKeyDef();
		if (space.getKeyIndexType() != null) {
			keyDef.setIndexType(space.getKeyIndexType());
		}
		if (!keys.isEmpty()) {
			keyDef.setFieldNames(keys.toArray(new String[keys.size()]));
		}
		if (!distribution.isEmpty()) {
			if (Utils.hasSpaceDefMethod("setDistributionFields")) {
				spaceDef.setDistributionFields(distribution
						.toArray(new String[distribution.size()]));
			}
		}
		for (Index index : space.getIndex()) {
			IndexDef indexDef = IndexDef.create(index.getName());
			indexDef.setIndexType(index.getType());
			indexDef.setFieldNames(index.getField().toArray(
					new String[index.getField().size()]));
			spaceDef.addIndexDef(indexDef);
		}
		return spaceDef;
	}

	public Metaspace getMetaspace(String name) throws ASException,
			JAXBException, IOException {
		Metaspace ms = Utils.getMetaspace(name);
		if (ms == null) {
			com.tibco.as.xml.Metaspace metaspace = getXMLMetaspace(name);
			if (metaspace == null) {
				return null;
			}
			ms = connect(metaspace);
		}
		return ms;
	}

	private com.tibco.as.xml.Metaspace getXMLMetaspace(String name) {
		for (com.tibco.as.xml.Metaspace metaspace : metaspaces.getMetaspace()) {
			if (Utils.getMetaspaceName(name).equals(
					Utils.getMetaspaceName(metaspace.getName()))) {
				return metaspace;
			}
		}
		return null;
	}

	public static com.tibco.as.xml.Member getMember(Member member)
			throws DatatypeConfigurationException {
		com.tibco.as.xml.Member m = new com.tibco.as.xml.Member();
		m.setId(member.getId());
		m.setName(member.getName());
		m.setManagementRole(member.getManagementRole());
		m.setHostAddress(member.getHostAddress());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(member.getJoinTime().getTime().getTime());
		m.setJoinTime(datatypeFactoryHolder.get().newXMLGregorianCalendar(
				calendar));
		m.setPort(member.getPort());
		return m;
	}

	public void closeMetaspace(String name) throws ASException {
		for (Metaspace metaspace : new ArrayList<Metaspace>(connectedMetaspaces)) {
			if (metaspace.getName().equals(Utils.getMetaspaceName(name))) {
				metaspace.closeAll();
				connectedMetaspaces.remove(metaspace);
			}
		}
		Metaspace ms = Utils.getMetaspace(name);
		if (ms == null) {
			return;
		}
		ms.closeAll();
	}

	public void closeAll() throws ASException {
		for (Metaspace metaspace : connectedMetaspaces) {
			metaspace.closeAll();
		}
		connectedMetaspaces.clear();
	}
}
