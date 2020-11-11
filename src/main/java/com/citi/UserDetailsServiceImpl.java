package com.citi;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Inside loadUserByUsername: " + username);
		
		//Database communication code [select * from usertable where username='username']
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserBuilder userBuilder = null;
		if(username.equals("citiuser")) {
			userBuilder = User.withUsername("citiuser");
			userBuilder.password(encoder.encode("citi123"))
			.roles("USER");
		}
		else if(username.equals("citiadmin")) {
			userBuilder = User.withUsername("citiadmin");
			userBuilder.password(encoder.encode("admin123"))
			.roles("ADMIN");
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		return userBuilder.build();
	}

}
