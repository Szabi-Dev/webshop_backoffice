package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.UserRepository;
import com.szabidev.webshop_backend.model.UserModel;
import com.szabidev.webshop_backend.service.impl.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    private UserModel userModel;

    private final static String email = "email@email.com";
    private static final String pass = "pass";

    @BeforeEach
    public void setup(){
        userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(pass);
    }


    @Test
    public void testLoadByName(){
        //given
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(userModel));
        when(userService.fetchAuthoritiesForUser(email)).thenReturn(new ArrayList<>());

        //when
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
        //then
        assertEquals(userDetails.getUsername(), email);
        assertEquals(userDetails.getPassword(), pass);
        assertTrue(userDetails.getAuthorities().isEmpty());
    }

    @Test
    public void testLoadByNameNonExistingUser(){
        //given
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        //when
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            customUserDetailsService.loadUserByUsername(email);
        });

        //then
    }
}
