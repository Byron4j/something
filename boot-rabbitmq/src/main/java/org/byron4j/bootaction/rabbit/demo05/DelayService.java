package org.byron4j.bootaction.rabbit.demo05;

import org.byron4j.bootaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delay")
public class DelayService {
    @Autowired
    private DelaySender delaySender;

    @GetMapping("")
    public void process(){
        delaySender.send(User.builder().id(100).name("ZhangSan").age(40).build());
    }
}
