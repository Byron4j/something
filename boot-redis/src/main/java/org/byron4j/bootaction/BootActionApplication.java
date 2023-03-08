package org.byron4j.bootaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
@MapperScan("org.byron4j.bootaction.mapper")
@EnableCaching
public class BootActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootActionApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello," + LocalDateTime.now();
	}
}
