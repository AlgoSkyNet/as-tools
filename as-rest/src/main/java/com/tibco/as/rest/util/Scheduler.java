package com.tibco.as.rest.util;

import java.util.HashMap;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author wangmingzhe
 * 
 */
@SuppressWarnings("rawtypes")
public class Scheduler {

	public static ScheduledThreadPoolExecutor clockDaemon = new ScheduledThreadPoolExecutor(
			10, new ThreadFactory() {
				public Thread newThread(Runnable runnable) {
					Thread thread = new Thread(runnable,
							"AS Rest Scheduler");
					thread.setDaemon(true);
					return thread;
				}
			});
	static {
		clockDaemon.setKeepAliveTime(10, TimeUnit.SECONDS);
	}
	
	static HashMap<Runnable,ScheduledFuture> clockTickets = new HashMap<Runnable,ScheduledFuture>();

	synchronized public static void executePeriodically(final Runnable task,long initialDelay,
			long period) {
		ScheduledFuture ticket = clockDaemon.scheduleAtFixedRate(task, initialDelay,
				period, TimeUnit.MILLISECONDS);
		clockTickets.put(task, ticket);
	}

	synchronized public static void cancel(Runnable task) {
		ScheduledFuture ticket = (ScheduledFuture) clockTickets.remove(task);
		if (ticket != null) {
			ticket.cancel(false);
			clockDaemon.remove(task);
		}
	}
        
    public static boolean contains( Runnable task ) {
        if ( clockDaemon.getQueue().contains( task ) ) {
            return true;
        }
        return false;
    }

	synchronized public static void executeAfterDelay(final Runnable task,
			long redeliveryDelay) {
		clockDaemon.schedule(task, redeliveryDelay, TimeUnit.MILLISECONDS);
	}
}
