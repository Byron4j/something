package org.byron4j.bootaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@MapperScan("org.byron4j.bootaction.mapper")
@EnableCaching
@EnableRedisHttpSession
public class BootActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootActionApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "Hello," + LocalDateTime.now();
	}

	@GetMapping("/session")
	public Map<String, Object> sessionTest(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		map.put("sessionId", request.getSession().getId());
		return map;
	}
}
