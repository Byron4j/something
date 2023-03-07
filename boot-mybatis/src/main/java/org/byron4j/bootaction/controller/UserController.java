package org.byron4j.bootaction.controller;

import org.byron4j.bootaction.model.User;
import org.byron4j.bootaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/queryById/{id}")
    User queryById(@PathVariable int id){
        return userService.queryById(id);
    }

    @PostMapping("/save")
    boolean save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    boolean deleteById(@PathVariable int id){
        return userService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    boolean deleteAll(){
        return userService.deleteAll();
    }

    @GetMapping("/findAll")
    List<User> findAll(){
        return userService.findAll();
    }
}
