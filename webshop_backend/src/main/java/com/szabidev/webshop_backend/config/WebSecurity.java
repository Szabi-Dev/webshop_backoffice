package com.szabidev.webshop_backend.config;

import com.szabidev.webshop_backend.service.PasswordEncoder;
import com.szabidev.webshop_backend.service.impl.CustomUserDetailsService;
import com.szabidev.webshop_backend.service.impl.JWTAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsService")
    private CustomUserDetailsService userDetailsService;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.getEncoder());
    }
}
