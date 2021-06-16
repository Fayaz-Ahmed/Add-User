package com.demo.projectauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/{id}").permitAll()
                .antMatchers("/admin/register").permitAll()
                .anyRequest()
                .authenticated();
    }
}