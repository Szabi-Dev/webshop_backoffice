package com.szabidev.webshop_backend.service.impl;

import com.szabidev.webshop_backend.dao.UserRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO: pass user authorities instead of empty list
        return userRepository.findByEmail(username)
                .map(userModel -> new User(userModel.getEmail(), userModel.getPassword(), new ArrayList<>()))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
