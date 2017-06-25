package com.golestan.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.DispatcherServlet;

import com.golestan.repositories.UserRepository;


@Configuration
@EnableAspectJAutoProxy
public class SecurityConfig {
	
	@Autowired
	DispatcherServlet dispatcherServlet;
	@Autowired
	ApplicationContext applicationContext;
	@Value("${token.secret}")
	String tokenSecret;
	@Value("${api.base.url}")
	String baseUrl;
	@Autowired
	@Bean
	public FilterRegistrationBean jwtFilter(UserRepository userRepository)
	{
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new JwtFilter(userRepository,tokenSecret,dispatcherServlet,applicationContext));
		filterRegistration.setOrder(1);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add(baseUrl+"/course/*");
		urlPatterns.add(baseUrl+"/account/change-password");
		urlPatterns.add(baseUrl+"/account/change-userInfo");
		filterRegistration.setUrlPatterns(
				urlPatterns);
		return filterRegistration;
	}
	
	@Bean
	public FilterRegistrationBean corsFilter()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new CorsFilter());
		filterRegistrationBean.setOrder(0);
		return filterRegistrationBean;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
