package org.byron4j.bootaction.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.byron4j.bootaction.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryById(int id);

    @Insert("INSERT INTO user (name, age) values(#{name}, #{age})")
    int save(User user);
}
