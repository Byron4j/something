package org.byron4j.bootaction.dao;

import org.byron4j.bootaction.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
