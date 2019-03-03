package com.bk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.bk.repo")
@ComponentScan({"com.bk.domain","com.bk.service"}) 
//@EntityScan("org.soluvas.buzz.core.jpa")
public class MyApplication {
	
 public static void main(String[] args) {
	SpringApplication.run(MyApplication.class, args);
	
	}

}
