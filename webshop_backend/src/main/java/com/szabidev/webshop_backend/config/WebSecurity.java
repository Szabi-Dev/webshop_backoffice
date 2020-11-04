package com.szabidev.webshop_backend.config;

import com.szabidev.webshop_backend.service.PasswordEncoder;
import com.szabidev.webshop_backend.service.impl.CustomUserDetailsService;
import com.szabidev.webshop_backend.service.impl.JWTAuthenticationFilter;
import com.szabidev.webshop_backend.service.impl.JWTAuthorizationFilter;
import com.szabidev.webshop_backend.service.impl.OauthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsService")
    private CustomUserDetailsService userDetailsService;

    @Resource(name = "passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Resource(name = "jwtAuthenticationFilter")
    private JWTAuthenticationFilter jwtAuthenticationFilter;

    @Resource(name = "jwtAuthorizationFilter")
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    @Resource(name = "authSuccessHandler")
    private OauthSuccessHandler authSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        /*
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/authenticate").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .oau
                .successHandler(authSuccessHandler);

         */
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder.getEncoder());
    }

    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
