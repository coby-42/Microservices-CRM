package com.ironhack.EdgeBasicAuthHystrix.security;

import com.ironhack.EdgeBasicAuthHystrix.service.imp.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeRequests()
                .mvcMatchers("/leads").authenticated()
                .mvcMatchers("/lead").authenticated()
                .mvcMatchers("/lead/{id}").authenticated()
                .mvcMatchers("/lead/{id}").authenticated()
                .mvcMatchers("/sales-rep/{id}").authenticated()

                .mvcMatchers("/sales-rep").hasRole("ADMIN")
                .mvcMatchers("/sales-reps/{id}").hasRole("ADMIN")

                .mvcMatchers("/opportunity/{id}").authenticated()
                .mvcMatchers("/opportunity/{lead-id}").authenticated()
                .mvcMatchers("/opportunity/close-lost/{id}").authenticated()
                .mvcMatchers("/opportunity/close-won/{id}").authenticated()
                .mvcMatchers("/accounts").authenticated()
                .mvcMatchers("/account/{id}").authenticated()
                .mvcMatchers("/account").authenticated()

                .anyRequest().permitAll();
    }
}

