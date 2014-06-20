package com.tibco.as.rest.service.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "space")
public class SpaceStatsInfo extends BaseDto {

	@XmlElementWrapper(name="spaceStatsList")
    @XmlElement(name="spaceStats")
	private List<SpaceStats> spaceStats;
	
	public List<SpaceStats> getSpaceStats() {
		return spaceStats;
	}

	public void setSpaceStats(List<SpaceStats> spaceStats) {
		this.spaceStats = spaceStats;
	}

	public static class SpaceStats {
		private String spaceName;
		private String memberId;

		private Long originalCount;
		private Long replicaCount;
		private Long putCount;
		private Long getCount;
		private Long takeCount;
		private Long expireCount;
		private Long evictCount;
		private Long lockCount;
		private Long unlockCount;
		private Long invokeCount;
		private Long queryCount;
		private Long missCount;
		public String getSpaceName() {
			return spaceName;
		}
		public void setSpaceName(String spaceName) {
			this.spaceName = spaceName;
		}
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public Long getOriginalCount() {
			return originalCount;
		}
		public void setOriginalCount(Long originalCount) {
			this.originalCount = originalCount;
		}
		public Long getReplicaCount() {
			return replicaCount;
		}
		public void setReplicaCount(Long replicaCount) {
			this.replicaCount = replicaCount;
		}
		public Long getPutCount() {
			return putCount;
		}
		public void setPutCount(Long putCount) {
			this.putCount = putCount;
		}
		public Long getGetCount() {
			return getCount;
		}
		public void setGetCount(Long getCount) {
			this.getCount = getCount;
		}
		public Long getTakeCount() {
			return takeCount;
		}
		public void setTakeCount(Long takeCount) {
			this.takeCount = takeCount;
		}
		public Long getExpireCount() {
			return expireCount;
		}
		public void setExpireCount(Long expireCount) {
			this.expireCount = expireCount;
		}
		public Long getEvictCount() {
			return evictCount;
		}
		public void setEvictCount(Long evictCount) {
			this.evictCount = evictCount;
		}
		public Long getLockCount() {
			return lockCount;
		}
		public void setLockCount(Long lockCount) {
			this.lockCount = lockCount;
		}
		public Long getUnlockCount() {
			return unlockCount;
		}
		public void setUnlockCount(Long unlockCount) {
			this.unlockCount = unlockCount;
		}
		public Long getInvokeCount() {
			return invokeCount;
		}
		public void setInvokeCount(Long invokeCount) {
			this.invokeCount = invokeCount;
		}
		public Long getQueryCount() {
			return queryCount;
		}
		public void setQueryCount(Long queryCount) {
			this.queryCount = queryCount;
		}
		public Long getMissCount() {
			return missCount;
		}
		public void setMissCount(Long missCount) {
			this.missCount = missCount;
		}
	}
}
