package com.courier.packaging.service.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.courier.packaging.*" })
public class ServiceDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDeliveryApplication.class, args);
	}

}
