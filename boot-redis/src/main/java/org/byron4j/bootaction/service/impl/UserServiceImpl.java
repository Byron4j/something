package org.byron4j.bootaction.service.impl;

import org.byron4j.bootaction.mapper.UserMapper;
import org.byron4j.bootaction.model.User;
import org.byron4j.bootaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@CacheConfig(cacheNames = "usr")
@Service
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "#id")
    @Override
    public User queryById(int id) {
        LOGGER.info("--->queryById");
        return userMapper.queryById(id);
    }

    @CachePut(key = "#user.id")
    @Override
    public boolean save(User user) {
        LOGGER.info("--->save");
        return userMapper.save(user) > 0;
    }

    @CacheEvict(key = "#id")
    @Override
    public boolean deleteById(int id) {
        LOGGER.info("--->deleteById");
        return userMapper.deleteById(id) > 0;
    }

    @CacheEvict(allEntries = true)
    @Override
    public boolean deleteAll() {
        LOGGER.info("--->deleteAll");
        return userMapper.deleteAll() > 0;
    }

    @Cacheable
    @Override
    public List<User> findAll() {
        LOGGER.info("--->findAll");
        return userMapper.findAll();
    }
}
