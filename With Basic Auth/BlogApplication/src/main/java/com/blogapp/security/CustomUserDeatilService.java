package com.blogapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogapp.entities.User;
import com.blogapp.exceptions.ResourseNotFoundException;
import com.blogapp.repositories.UserRepo;

@Service
public class CustomUserDeatilService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Loading user form db by username
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourseNotFoundException("User", "email :" + username, 0));

		return user;
	}

}
