package org.byron4j.bootaction;

import org.byron4j.bootaction.model.User;
import org.byron4j.bootaction.rabbit.demo01.MQSenderA;
import org.byron4j.bootaction.rabbit.demo02.MQSender4Obj;
import org.byron4j.bootaction.rabbit.demo03.TopicSender;
import org.byron4j.bootaction.rabbit.demo04.FanoutSender;
import org.byron4j.bootaction.rabbit.demo05.DelaySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BootActionApplicationTests {

	@Autowired
	private MQSenderA mqSenderA;

	@Autowired
	private MQSender4Obj mqSender4Obj;

	@Autowired
	private TopicSender topicSender;

	@Autowired
	private FanoutSender fanoutSender;

	@Autowired
	private DelaySender delaySender;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 10; i++) {
			mqSenderA.send("send:" + i + "; " + LocalDateTime.now());
		}
	}

	@Test
	public void testSendObject() {
		mqSender4Obj.send(User.builder().id(1).name("zsf").age(20).build());
	}

	// 测试topic
	@Test
	public void testSend() {
		topicSender.send();
	}
	@Test
	public void testSendA() {
		topicSender.sendA();
	}
	@Test
	public void testSendB() {
		topicSender.sendB();
	}

	// 测试广播
	@Test
	public void testFanout() {
		fanoutSender.send();
	}

	// 测试延迟消息
	@Test
	public void testDelay() {
		delaySender.send(User.builder().id(100).name("ZhangSan").age(50).build());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
