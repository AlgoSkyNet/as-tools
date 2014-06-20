package org.atmosphere.samples.chat.jersey;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.atmosphere.client.TrackMessageSizeInterceptor;
import org.atmosphere.config.service.AtmosphereService;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor;

@Path("/chat")
@AtmosphereService(dispatch = false, interceptors = {
		AtmosphereResourceLifecycleInterceptor.class,
		TrackMessageSizeInterceptor.class }, path = "/chat", servlet = "org.glassfish.jersey.servlet.ServletContainer")
public class Jersey2Resource {

	/**
	 * Echo the chat message. Jackson can clearly be used here, but for
	 * simplicity we just echo what we receive.
	 * 
	 * @param message
	 */
	@POST
	public void broadcast(String message) {
		BroadcasterFactory.getDefault().lookup("/chat").broadcast(message);
	}

}
