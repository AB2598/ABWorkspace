package com.abs;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.abs")
@EnableAutoConfiguration
//@EnableJpaRepositories("com.abs")
@EntityScan("com.abs")
public class AbsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AbsApplication.class, args);
		openHomePage();
	}

	
	
	private static void openHomePage() throws IOException 
	{
		 Runtime rt = Runtime.getRuntime();
	     rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/ABS/");
	}
}
