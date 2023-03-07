package org.byron4j.bootaction.service;

import org.byron4j.bootaction.model.User;

import java.util.List;

public interface UserService {

    User queryById( int id);

    boolean save( User user);

    boolean deleteById(int id);

    boolean deleteAll();

    List<User> findAll();
}
