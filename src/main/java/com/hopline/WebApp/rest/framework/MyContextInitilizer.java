package com.hopline.WebApp.rest.framework;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.util.logging.Logger;

public class MyContextInitilizer implements ServletContextListener {

	private static Logger LOG = null;
	private String token;
	private String platform;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			String path = sce.getServletContext().getInitParameter("spring-config-location");
			ClassPathXmlApplicationContext applicationContext = null;
			try {
				applicationContext = new ClassPathXmlApplicationContext(path);
//				LOG.info("Initialized Spring Application Context of id " + applicationContext.getDisplayName());
				ServiceLocator.getInstance().setSpringContext(applicationContext);
				
				/*SnsTokenTO snsTokenTO = new SnsTokenTO();
				snsTokenTO.setUserName("ayush");
				
				PushTokenService pushTokenService = ServiceLocator.getInstance().getService(PushTokenService.class);
				pushTokenListTO = pushTokenService.retrieveToken(snsTokenTO);
				
				List<SnsTokenTO> list = pushTokenListTO.getList();
				
				for (SnsTokenTO tokenTO : list) {
					token = StringUtils.trimToEmpty(tokenTO.getToken());
					platform = StringUtils.trimToEmpty(tokenTO.getPlatform());
					
					System.out.println(token+ " "+ platform);
				} */
				
//				Filter strutsFilter = sce.getServletContext().createFilter(
//						org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter.class);
//
//				FilterRegistration struts = sce.getServletContext().addFilter("struts2", strutsFilter);
//				struts.setInitParameter("config", sce.getServletContext().getInitParameter("struts-config-location"));
//				struts.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
//						DispatcherType.ASYNC, DispatcherType.ERROR), true, "/*");
			}

			catch (Exception ex) {
				System.out.println("!!!!!!!!!!!!!!   System Initialization Failed    !!!!!!!!!!!!!!!!!!");
				ex.printStackTrace(System.out);
				throw new RuntimeException(ex);

			}
		} finally {
			
		}

	}
}
