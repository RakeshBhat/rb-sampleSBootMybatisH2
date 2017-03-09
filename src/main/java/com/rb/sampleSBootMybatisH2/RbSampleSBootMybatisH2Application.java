package com.rb.sampleSBootMybatisH2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rb.sampleSBootMybatisH2.mapper")
public class RbSampleSBootMybatisH2Application {

	public static void main(String[] args) {
		SpringApplication.run(RbSampleSBootMybatisH2Application.class, args);
	}
}
