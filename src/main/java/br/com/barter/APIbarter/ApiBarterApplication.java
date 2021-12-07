package br.com.barter.APIbarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
public class ApiBarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBarterApplication.class, args);
	}

}
