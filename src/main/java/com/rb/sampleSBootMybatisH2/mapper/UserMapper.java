package com.rb.sampleSBootMybatisH2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.rb.sampleSBootMybatisH2.entity.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM User WHERE state = #{state}")
	User findByState(@Param("state") String state);

	@Insert("INSERT INTO User(name,state,country) VALUES(#{name},#{state},#{country})")
	@SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = Integer.class)
	void insertUser(User user);
	
	@Select("SELECT * FROM User")
	List<User> getAllUsers();
}
