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
		if (Boolean.TRUE.equals(metaspace.isAutoconnect())) {
			connect(metaspace);
		}
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
		if (Boolean.TRUE.equals(metaspace.isRemote())) {
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

	public com.tibco.as.xml.Metaspace getMetaspaceByDisplayName(
			String displayName) throws ASException {
		for (com.tibco.as.xml.Metaspace metaspace : metaspaces.getMetaspace()) {
			if (displayName.equals(metaspace.getDisplayName())) {
				return metaspace;
			}
		}
		return null;
	}

	public com.tibco.as.xml.Metaspace getMetaspaceByName(String name)
			throws ASException {
		for (com.tibco.as.xml.Metaspace metaspace : metaspaces.getMetaspace()) {
			if (Utils.getMetaspaceName(name).equals(
					Utils.getMetaspaceName(metaspace.getName()))) {
				return metaspace;
			}
		}
		return null;
	}

	public List<Metaspace> getConnectedMetaspaces() {
		return new ArrayList<Metaspace>(connectedMetaspaces);
	}

	public static com.tibco.as.xml.Metaspace getXMLMetaspace(Metaspace metaspace) {
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

	public static com.tibco.as.xml.Space getXMLSpace(SpaceDef spaceDef) {
		com.tibco.as.xml.Space space = new com.tibco.as.xml.Space();
		space.setCachePolicy(spaceDef.getCachePolicy());
		space.setCapacity(spaceDef.getCapacity());
		space.setDistributionPolicy(spaceDef.getDistributionPolicy());
		space.setEvictionPolicy(spaceDef.getEvictionPolicy());
		Collection<String> distribution = spaceDef.getDistributionFields();
		if (distribution == null) {
			distribution = new ArrayList<String>();
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
			field.setEncrypted(fieldDef.isEncrypted());
			space.getField().add(field);
		}
		for (IndexDef indexDef : spaceDef.getIndexDefList()) {
			Index index = new Index();
			index.setName(indexDef.getName());
			index.setType(indexDef.getIndexType());
			space.getIndex().add(index);
		}
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
		space.setPhaseRatio(spaceDef.getPhaseRatio());
		space.setReadTimeout(spaceDef.getReadTimeout());
		space.setReplicationCount(spaceDef.getReplicationCount());
		space.setReplicationPolicy(spaceDef.getReplicationPolicy());
		space.setSpaceWait(spaceDef.getSpaceWait());
		space.setTtl(spaceDef.getTTL());
		space.setUpdateTransport(spaceDef.getUpdateTransport());
		space.setVirtualNodeCount(spaceDef.getVirtualNodeCount());
		space.setWriteTimeout(spaceDef.getWriteTimeout());
		space.setForgetOldValue(spaceDef.isForgetOldValue());
		space.setHostAwareReplication(spaceDef.isHostAwareReplication());
		return space;
	}

	public static SpaceDef getSpaceDef(com.tibco.as.xml.Space space) {
		SpaceDef spaceDef = SpaceDef.create();
		spaceDef.setName(space.getName());
		spaceDef.setCachePolicy(space.getCachePolicy());
		spaceDef.setEvictionPolicy(space.getEvictionPolicy());
		spaceDef.setReplicationPolicy(space.getReplicationPolicy());
		spaceDef.setPersistenceType(space.getPersistenceType());
		spaceDef.setPersistencePolicy(space.getPersistencePolicy());
		spaceDef.setPersistenceDistributionPolicy(space
				.getPersistenceDistributionPolicy());
		spaceDef.setDistributionPolicy(space.getDistributionPolicy());
		spaceDef.setUpdateTransport(space.getUpdateTransport());
		spaceDef.setLockScope(space.getLockScope());
		if (space.getCapacity() != null) {
			spaceDef.setCapacity(space.getCapacity());
		}
		if (space.getTtl() != null) {
			spaceDef.setTTL(space.getTtl());
		}
		if (space.getReplicationCount() == null) {
			spaceDef.setReplicationCount(space.getReplicationCount());
		}
		if (space.getMinSeederCount() != null) {
			spaceDef.setMinSeederCount(space.getMinSeederCount());
		}
		if (space.getLockTTL() != null) {
			spaceDef.setLockTTL(space.getLockTTL());
		}
		if (space.getLockWait() != null) {
			spaceDef.setLockWait(space.getLockWait());
		}
		if (space.getPhaseCount() != null) {
			spaceDef.setPhaseCount(space.getPhaseCount());
		}
		if (space.getPhaseRatio() != null) {
			spaceDef.setPhaseRatio(space.getPhaseRatio());
		}
		if (space.getVirtualNodeCount() != null) {
			spaceDef.setVirtualNodeCount(space.getVirtualNodeCount());
		}
		if (space.getSpaceWait() != null) {
			spaceDef.setSpaceWait(space.getSpaceWait());
		}
		if (space.getReadTimeout() != null) {
			spaceDef.setReadTimeout(space.getReadTimeout());
		}
		if (space.getWriteTimeout() != null) {
			spaceDef.setWriteTimeout(space.getWriteTimeout());
		}
		if (space.isForgetOldValue() != null) {
			spaceDef.setForgetOldValue(space.isForgetOldValue());
		}
		if (space.isHostAwareReplication() != null) {
			spaceDef.setForgetOldValue(space.isHostAwareReplication());
		}
		Collection<String> keys = new ArrayList<String>();
		Collection<String> distribution = new ArrayList<String>();
		for (Field field : space.getField()) {
			FieldDef fieldDef = FieldDef.create(field.getName(),
					field.getType());
			fieldDef.setNullable(Boolean.TRUE.equals(field.isNullable()));
			fieldDef.setEncrypted(Boolean.TRUE.equals(field.isEncrypted()));
			spaceDef.putFieldDef(fieldDef);
			if (Boolean.TRUE.equals(field.isKey())) {
				keys.add(field.getName());
			}
			if (Boolean.TRUE.equals(field.isDistribution())) {
				distribution.add(field.getName());
			}
		}
		spaceDef.getKeyDef().setIndexType(space.getKeyIndexType());
		spaceDef.setKey(keys.toArray(new String[keys.size()]));
		spaceDef.setDistributionFields(distribution
				.toArray(new String[distribution.size()]));
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
			com.tibco.as.xml.Metaspace metaspace = getMetaspaceByName(name);
			if (metaspace == null) {
				return null;
			}
			ms = connect(metaspace);
		}
		return ms;
	}

	public static com.tibco.as.xml.Member getXMLMember(Member member)
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
}
