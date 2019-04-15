package com.revature.screenforce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity( debug = true )
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

//	@Autowired
//	CustomFilter filter;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(
          new CustomFilter(), BasicAuthenticationFilter.class);
    }

}
