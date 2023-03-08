package org.byron4j.bootaction;

import org.byron4j.bootaction.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BootActionApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedisTemplate(){
		User value = new User();
		value.setId(1000);
		value.setName("zs");
		value.setAge(19);
		redisTemplate.opsForValue().set("usr:zs", value);
	}

}
