package org.byron4j.bootaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class BootActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootActionApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello," + LocalDateTime.now();
	}
}
