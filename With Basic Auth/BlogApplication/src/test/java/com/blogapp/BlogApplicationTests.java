package com.blogapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogapp.repositories.UserRepo;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	private UserRepo userRepo;

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void repoTest() {
		String className = this.userRepo.getClass().getName();
		System.out.println("*************************************************************************");
		System.out.println(className);

	}
}
