package com.fernando.msavaliator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsavaliatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsavaliatorApplication.class, args);
	}

}
