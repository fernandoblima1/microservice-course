package br.com.github.msavaliador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsavaliadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsavaliadorApplication.class, args);
	}

}
