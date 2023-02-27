package org.byron4j.bootaction.controller;

import org.byron4j.bootaction.mapper.UserMapper;
import org.byron4j.bootaction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/queryById/{id}")
    User queryById(@PathVariable int id){
        return userMapper.queryById(id);
    }

    @PostMapping("/save")
    boolean queryById(@RequestBody User user){
        return userMapper.save(user) > 0;
    }
}
