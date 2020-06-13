package com.siva.moviesinfoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MoviesInfoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesInfoServerApplication.class, args);
	}

}
