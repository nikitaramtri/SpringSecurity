package com.citi;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userService() {
		return new UserDetailsServiceImpl();
	}
	
	//Authorization method
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/hellouser").hasAnyRole("USER", "ADMIN")
		.antMatchers("/helloadmin").hasRole("ADMIN")
		.antMatchers("/helloall").permitAll()
		.and()
		.formLogin();
	}
	
	//Authentication method
	@Override
	public void configure(AuthenticationManagerBuilder aAuthenticationManagerBuilder) throws Exception {
		
		aAuthenticationManagerBuilder.userDetailsService(userService());
		/*
		aAuthenticationManagerBuilder.inMemoryAuthentication()
		.withUser("tom").password(encoder.encode("tom123")).roles("USER")
		.and()
		.withUser("jerry").password(encoder.encode("jerry123")).roles("ADMIN");
		*/
	}
}







