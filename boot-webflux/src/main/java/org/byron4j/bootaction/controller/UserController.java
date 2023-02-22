package org.byron4j.bootaction.controller;

import org.byron4j.bootaction.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init(){
        users.put(Long.valueOf(1), new User(1, "zs", 18));
        users.put(Long.valueOf(2), new User(2, "ls", 20));
    }

    @GetMapping("/list")
    public Flux<User> getAll(){
        return Flux.fromIterable(users.entrySet().stream()
                .map(ele->ele.getValue())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable("id") long id){
        return Mono.justOrEmpty(users.get(id));
    }

    @PostMapping
    public Mono<ResponseEntity<String>> addUser(@RequestBody User user){
        users.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<String>> putUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        users.put(id, user);
        return Mono.just(new ResponseEntity<>("修改成功", HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id){
        users.remove(id);
        return Mono.just(new ResponseEntity<>("删除成功", HttpStatus.OK));
    }
}
