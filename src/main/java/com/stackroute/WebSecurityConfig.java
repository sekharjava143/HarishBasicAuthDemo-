package com.stackroute;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.*;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;  
  
@EnableWebSecurity  
@ComponentScan("com.stackroute")  
public class WebSecurityConfig implements WebMvcConfigurer {  
      
    @Bean  
    public UserDetailsService userDetailsService() throws Exception {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").  
        password("admin").roles("USER").build());  
        return manager;  
    }  
      
    protected void configure(HttpSecurity http) throws Exception {
        http
        .antMatcher("/dmo/")
        .authorizeRequests().anyRequest().denyAll();
//        .hasRole("ADMIN").
//        .and()
//        .httpBasic();
    }  
}  
