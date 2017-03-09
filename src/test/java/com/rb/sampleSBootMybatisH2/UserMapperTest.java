package com.rb.sampleSBootMybatisH2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rb.sampleSBootMybatisH2.entity.User;
import com.rb.sampleSBootMybatisH2.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	UserMapper userMapper;


	@Test
	  public void mapperIsNotNullTest() {
	    assertThat(userMapper).isNotNull();
	  }

	  @Test
	  public void findByStateTest() {
	    User user = userMapper.findByState("Delhi");
	    assertThat(user.getName()).isEqualTo("Web");
	    assertThat(user.getState()).isEqualTo("Delhi");
	    assertThat(user.getCountry()).isEqualTo("India");
	  }
	  
	  @Test
	  public void addUserTest() {

	    User user = new User();
	    user.setName("Webx");
	    user.setState("London");
	    user.setCountry("UK");
	    
	    userMapper.insertUser(user);
	    
	    User userx = userMapper.findByState("London");
	    assertThat(userx.getName()).isEqualTo("Webx");
	    assertThat(userx.getState()).isEqualTo("London");
	    assertThat(userx.getCountry()).isEqualTo("UK");
	  }
}
