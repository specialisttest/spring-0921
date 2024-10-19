package ru.specialist.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;

import jakarta.servlet.FilterRegistration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// create root Spring web application context
		AnnotationConfigWebApplicationContext rootContext = 
				new AnnotationConfigWebApplicationContext();
		
		rootContext.register(ApplicationConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		// create dispatcher servlet's Spring web application context
		AnnotationConfigWebApplicationContext servletAppContext = 
				new AnnotationConfigWebApplicationContext();
		
		servletAppContext.register(MVCConfig.class);
		
		DispatcherServlet dispatcherServlet = 
				new DispatcherServlet(servletAppContext);
		
		ServletRegistration.Dynamic dispatcher =
				servletContext.addServlet("dispatcher", dispatcherServlet);
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		FilterRegistration.Dynamic encodingFilter = 
				servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
			
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
		

		
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {ApplicationConfig.class, MVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
