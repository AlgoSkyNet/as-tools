package com.tibco.as.rest.server;


public class ASRestServer {

//	public static void main(String[] args) throws Exception {
//		Map<String, String> parameter = new HashMap<String, String>();
//		if (args.length > 1) {
//			parameter.put("fileName", args[0]);
//		} else {
//			parameter.put("fileName", "server.xml");
//		}
//		start(parameter);
//	}

//	public static void start(Map<String, String> parameter) throws Exception {
//		ConfigInfo configInfo = ConfigUtil.getConfigInfo(parameter
//				.get("fileName"));
//		for (MetaspaceInfo metaspaceInfo : configInfo.getMetaspaceInfoList()) {
//			MetaspaceUtil.put(metaspaceInfo.getName(),
//					ASUtil.connectMetaspace(metaspaceInfo));
//		}
//		Server server = new Server();
//		ServerConnector connector = new ServerConnector(server);
//		connector.setPort(configInfo.getServerInfo().getPort());
//		server.setConnectors(new Connector[] { connector });
//		ServletHolder sh = new ServletHolder(ServletContainer.class);
//		sh.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
//				"com.tibco.as.rest.server.ASApplication");
//		sh.setInitParameter(ServerProperties.PROVIDER_PACKAGES,
//				"com.tibco.as.rest.service");
//		ServletContextHandler context = new ServletContextHandler(server, null);
//		context.addServlet(sh, "/rest/*");
//		server.start();
//		while (!server.isStarted()) {
//			Thread.sleep(100);
//		}
//		List<String> jars = FileUtil.getListFiles("remoteInvoke", "jar", false);
//		for (String jar : jars) {
//			ClassPathUtil.addFile(jar);
//		}
//		server.join();
//	}
}