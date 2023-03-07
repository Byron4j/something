package org.byron4j.bootaction.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.byron4j.bootaction.model.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryById(int id);

    @Insert("INSERT INTO user (name, age) values(#{name}, #{age})")
    int save(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int deleteById(int id);

    @Delete("DELETE FROM user")
    int deleteAll();

    @Select("SELECT * FROM user")
    List<User> findAll();
}
