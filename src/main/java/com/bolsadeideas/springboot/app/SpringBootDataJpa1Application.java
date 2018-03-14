package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootDataJpa1Application implements CommandLineRunner{

	@Autowired
	private IUploadFileService uploadFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpa1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
		
	}
}
