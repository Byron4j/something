package org.byron4j.bootaction.controller;

import org.byron4j.bootaction.dao.UserRepository;
import org.byron4j.bootaction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@RestController
@RequestMapping("/userReactive")
public class UserMongoReactiveController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public Flux<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/findAllDelay", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAllDelay(){
        return userRepository.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    public Mono<User> find(@PathVariable String id){
        return userRepository.findById(id);
    }

    @PostMapping("")
    public Mono<User> saveUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable String id, @Valid @RequestBody User user){
        return userRepository.findById(id).flatMap(
                existsUser -> {
                    existsUser.setName(user.getName());
                    return userRepository.save(existsUser);
                }
        ).map(updatedUser -> ResponseEntity.ok(updatedUser))
                .defaultIfEmpty(ResponseEntity.accepted().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id){
        return userRepository.findById(id).flatMap(
                        existsUser -> userRepository.deleteById(id)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                ).defaultIfEmpty(ResponseEntity.accepted().build());
    }
}
