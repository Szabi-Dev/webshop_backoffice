package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.RoleRepository;
import com.szabidev.webshop_backend.service.impl.DefaultRoleService;
import com.szabidev.webshop_backend.service.populator.impl.RolePopulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultRoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private RolePopulator rolePopulator;

    @InjectMocks
    private DefaultRoleService roleService;

    @BeforeEach
    public void setup(){

    }
}
