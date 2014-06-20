package com.tibco.as.rest.service.dto;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "space")
public class SpaceInfo extends BaseDto {
	
	public SpaceInfo(){
	}

	private String name;

	@XmlElementWrapper(name="fields")
    @XmlElement(name="field")
	private Collection<Field> fields;

	@XmlElementWrapper(name="keyFieldNames")
    @XmlElement(name="keyFieldName")
	private Collection<String> keyFieldNames;
	
	private String keyIndexType;

	@XmlElementWrapper(name="indexes")
    @XmlElement(name="index")
	private Collection<Index> indexes;

	private Long capacity;

	private Long ttl;

	private String cachePolicy;

	private String evictionPolicy;

	private Integer replicationCount;

	private String replicationPolicy;
	
	private String persistenceType;
	
	private String persistencePolicy;
	
	private String persistenceDistributionPolicy;
	
	private Integer minSeederCount;

	private String distributionPolicy;
	
	@XmlElementWrapper(name="distributionFields")
    @XmlElement(name="distributionField")
	private Collection<String> distributionFields;
	
	private String updateTransport;
	
	private String lockScope;
	
	private Long lockTTL;
	
	private Long lockWait;

	private Integer phaseCount;

	private Long phaseInterval;
	
	private Integer virtualNodeCount;

	private Long spaceWait;

	private Long readTimeout;
	
	private Long writeTimeout;
	
	private Boolean isForgetOldValue;
	
	private Boolean isHostAwareReplication;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Field> getFields() {
		return fields;
	}

	public void setFields(Collection<Field> fields) {
		this.fields = fields;
	}

	public Collection<String> getKeyFieldNames() {
		return keyFieldNames;
	}

	public void setKeyFieldNames(Collection<String> keyFieldNames) {
		this.keyFieldNames = keyFieldNames;
	}

	public String getKeyIndexType() {
		return keyIndexType;
	}

	public void setKeyIndexType(String keyIndexType) {
		this.keyIndexType = keyIndexType;
	}

	public Collection<Index> getIndexes() {
		return indexes;
	}

	public void setIndexes(Collection<Index> indexes) {
		this.indexes = indexes;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getTTL() {
		return ttl;
	}

	public void setTTL(Long ttl) {
		this.ttl = ttl;
	}

	public String getCachePolicy() {
		return cachePolicy;
	}

	public void setCachePolicy(String cachePolicy) {
		this.cachePolicy = cachePolicy;
	}

	public String getEvictionPolicy() {
		return evictionPolicy;
	}

	public void setEvictionPolicy(String evictionPolicy) {
		this.evictionPolicy = evictionPolicy;
	}

	public Integer getReplicationCount() {
		return replicationCount;
	}

	public void setReplicationCount(Integer replicationCount) {
		this.replicationCount = replicationCount;
	}

	public String getReplicationPolicy() {
		return replicationPolicy;
	}

	public void setReplicationPolicy(String replicationPolicy) {
		this.replicationPolicy = replicationPolicy;
	}

	public String getPersistenceType() {
		return persistenceType;
	}

	public void setPersistenceType(String persistenceType) {
		this.persistenceType = persistenceType;
	}

	public String getPersistencePolicy() {
		return persistencePolicy;
	}

	public void setPersistencePolicy(String persistencePolicy) {
		this.persistencePolicy = persistencePolicy;
	}

	public String getPersistenceDistributionPolicy() {
		return persistenceDistributionPolicy;
	}

	public void setPersistenceDistributionPolicy(
			String persistenceDistributionPolicy) {
		this.persistenceDistributionPolicy = persistenceDistributionPolicy;
	}

	public Integer getMinSeederCount() {
		return minSeederCount;
	}

	public void setMinSeederCount(Integer minSeederCount) {
		this.minSeederCount = minSeederCount;
	}

	public String getDistributionPolicy() {
		return distributionPolicy;
	}

	public void setDistributionPolicy(String distributionPolicy) {
		this.distributionPolicy = distributionPolicy;
	}

	public Collection<String> getDistributionFields() {
		return distributionFields;
	}

	public void setDistributionFields(Collection<String> distributionFields) {
		this.distributionFields = distributionFields;
	}

	public String getUpdateTransport() {
		return updateTransport;
	}

	public void setUpdateTransport(String updateTransport) {
		this.updateTransport = updateTransport;
	}

	public String getLockScope() {
		return lockScope;
	}

	public void setLockScope(String lockScope) {
		this.lockScope = lockScope;
	}

	public Long getLockTTL() {
		return lockTTL;
	}

	public void setLockTTL(Long lockTTL) {
		this.lockTTL = lockTTL;
	}

	public Long getLockWait() {
		return lockWait;
	}

	public void setLockWait(Long lockWait) {
		this.lockWait = lockWait;
	}

	public Integer getPhaseCount() {
		return phaseCount;
	}

	public void setPhaseCount(Integer phaseCount) {
		this.phaseCount = phaseCount;
	}

	public Long getPhaseInterval() {
		return phaseInterval;
	}

	public void setPhaseInterval(Long phaseInterval) {
		this.phaseInterval = phaseInterval;
	}

	public Integer getVirtualNodeCount() {
		return virtualNodeCount;
	}

	public void setVirtualNodeCount(Integer virtualNodeCount) {
		this.virtualNodeCount = virtualNodeCount;
	}

	public Long getSpaceWait() {
		return spaceWait;
	}

	public void setSpaceWait(Long spaceWait) {
		this.spaceWait = spaceWait;
	}

	public Long getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Long readTimeout) {
		this.readTimeout = readTimeout;
	}

	public Long getWriteTimeout() {
		return writeTimeout;
	}

	public void setWriteTimeout(Long writeTimeout) {
		this.writeTimeout = writeTimeout;
	}

	public Boolean isForgetOldValue() {
		return isForgetOldValue;
	}

	public void setForgetOldValue(Boolean isForgetOldValue) {
		this.isForgetOldValue = isForgetOldValue;
	}

	public Boolean isHostAwareReplication() {
		return isHostAwareReplication;
	}

	public void setHostAwareReplication(Boolean isHostAwareReplication) {
		this.isHostAwareReplication = isHostAwareReplication;
	}

	public static class Field {

		private String name;
		
		private String type;
		
		private Boolean nullable;
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public Boolean getNullable() {
			return nullable;
		}
		
		public void setNullable(Boolean nullable) {
			this.nullable = nullable;
		}
		
	}

	public static class Index {

		private String name;
		
		private String indexType;

		private Collection<String> fieldNames;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getIndexType() {
			return indexType;
		}

		public void setIndexType(String indexType) {
			this.indexType = indexType;
		}

		public Collection<String> getFieldNames() {
			return fieldNames;
		}

		public void setFieldNames(Collection<String> fieldNames) {
			this.fieldNames = fieldNames;
		}

	}
}
