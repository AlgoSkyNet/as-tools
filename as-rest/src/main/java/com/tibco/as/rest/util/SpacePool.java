package com.tibco.as.rest.util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.space.ASException;
import com.tibco.as.space.Space;

public class SpacePool {
	private static Logger logger = LoggerFactory.getLogger(SpacePool.class);
	
	private static Map<String, SpaceCache> spaceCacheMap = new ConcurrentHashMap<String, SpaceCache>();
	
	private static long timeout = 30 * 60 * 1000;
	
	private static long initialDelay = 100;
	
	private static long period = 50 * 60 * 1000;
	
	private static ReentrantLock lock = new ReentrantLock();
	
	static {
		Scheduler.executePeriodically(new Runnable(){
			@Override
			public void run() {
				lock.lock();
				try{
					long currentTime = new Date().getTime();
					for(String key : spaceCacheMap.keySet()){
						logger.debug("key=" + key);
						SpaceCache sc = spaceCacheMap.get(key);
						if((currentTime - sc.getTime()) > timeout ){
							logger.debug("space cache timeout:"+key);
							spaceCacheMap.remove(key);
							try {
								sc.getSpace().close();
							} catch (ASException e) {
								logger.warn("error occur when close space:", e);
							}
						}
					}
				}finally{
					lock.unlock();
				}
			}
		}, initialDelay, period);
	}
	
	public static Space getSpace(String metaspaceName, String spaceName){
		lock.lock();
		try{
			SpaceCache spaceCache = spaceCacheMap.get(metaspaceName + spaceName);
			if(spaceCache == null){
				logger.debug("get new space*****************************"+metaspaceName + "_" + spaceName);
				Space space = MetaspaceUtil.getSpace(metaspaceName, spaceName);
				spaceCacheMap.put(metaspaceName+spaceName, new SpaceCache(space, new Date().getTime()));
				return space;
			}else{
				spaceCache.setTime(new Date().getTime());
				return spaceCache.getSpace();
			}
		}finally{
			lock.unlock();
		}
	}
	
	private static class SpaceCache{
		private Space space;
		private long time;
		
		public SpaceCache(Space space, long time){
			this.space = space;
			this.time = time;
		}
		
		public Space getSpace() {
			return space;
		}

		public long getTime() {
			return time;
		}
		public void setTime(long time) {
			this.time = time;
		}		
	}
}
