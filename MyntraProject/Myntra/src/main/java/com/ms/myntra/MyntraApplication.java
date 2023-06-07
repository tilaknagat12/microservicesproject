package com.ms.myntra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ms.myntra")
public class MyntraApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntraApplication.class, args);
	}
 
}
