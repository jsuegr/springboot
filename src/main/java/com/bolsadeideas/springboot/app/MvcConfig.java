package com.bolsadeideas.springboot.app;

import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		registry.addResourceHandler("/uploads/**")
			.addResourceLocations(resourcePath);
		
	}

	
}
