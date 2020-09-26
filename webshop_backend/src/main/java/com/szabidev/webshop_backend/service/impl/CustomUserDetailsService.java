package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.UserRepository;
import com.szabidev.webshop_backend.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(userModel -> new User(userModel.getEmail(), userModel.getPassword(), userService.fetchAuthoritiesForUser(username)))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
