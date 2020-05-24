package com.smartequate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = ComputeController.class)
public class SmartequateBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartequateBackendApplication.class, args);
	}

}
