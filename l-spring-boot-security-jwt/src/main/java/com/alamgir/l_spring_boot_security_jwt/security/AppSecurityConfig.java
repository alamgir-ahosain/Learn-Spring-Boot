package com.alamgir.l_spring_boot_security_jwt.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppSecurityConfig {

	Logger logger = LoggerFactory.getLogger(AppSecurityConfig.class);

	@Autowired
	JWTTokenFilter jwtTokenFilter;

	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration)	throws Exception {
		logger.info("AppSecurityConfig : Initilizing Bean AuthenticationManager");
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		logger.info("AppSecurityConfig : Initilizing Bean BCryptPasswordEncoder");
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception {

		logger.info("AppSecurityConfig : Configuring SecurityFilterChain Layer  of URl patterns");
		
		security.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/public/**")
								.permitAll()
								.anyRequest()
								.authenticated())
				.addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

		return security.build();
	}

}