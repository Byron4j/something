package org.byron4j.bootaction;

import org.byron4j.bootaction.config.CusStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class WebfluxApplication {
	@Autowired
	private CusStarter cusStarter;

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

	@GetMapping("/")
	public Mono<String> hello(){
		return Mono.just("This is a webflux api. " + cusStarter.cusStarter());
	}
}
