package com.pulseplayer.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.pulseplayer.app.services.UserServicesImplementation;

import jakarta.servlet.http.HttpSession;

@EnableWebSecurity
@Configuration

public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getDetailsService() {
		return new UserServicesImplementation();
	}
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(getDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() 
		.authorizeHttpRequests().requestMatchers("/**").permitAll()
		.requestMatchers("/loginPage").authenticated().and()
		.formLogin().loginPage("/loginPage").loginProcessingUrl("/login").defaultSuccessUrl("/loginrole")
		.permitAll().permitAll();
		
		return http.build();
	}


}
