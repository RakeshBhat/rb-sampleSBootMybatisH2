package com.rb.sampleSBootMybatisH2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rb.sampleSBootMybatisH2.entity.User;
import com.rb.sampleSBootMybatisH2.mapper.UserMapper;

@RestController
@RequestMapping(value="/service/*")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	private Logger LOG = LoggerFactory.getLogger(getClass());
	
	@PostMapping(value="/adduser", consumes="application/json", produces="application/json")
	@ResponseBody public User addUser(@RequestBody User user){		
		userMapper.insertUser(user);
		User newUser = userMapper.findByState(user.getState());
		LOG.info("new User: " + newUser);
		return newUser;
	}
	
	@PostMapping(value="/alluser", consumes="application/json", produces="application/json")
	@ResponseBody public List<User> allUser(@RequestBody User user){		
		userMapper.insertUser(user);
		List<User> newUser = userMapper.getAllUsers();
		LOG.info("new User: " + newUser.get(0));
		return newUser;
	}
}
