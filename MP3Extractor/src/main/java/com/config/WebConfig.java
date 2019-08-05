package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan("com.web")
public class WebConfig implements WebMvcConfigurer {

	
	
	//setup view resolver in a web configurer
@Bean	
public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setViewClass(JstlView.class);
	
	return resolver;
}


@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	
	registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
}
}
