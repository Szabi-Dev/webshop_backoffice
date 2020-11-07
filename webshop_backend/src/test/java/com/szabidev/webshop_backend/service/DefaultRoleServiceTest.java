package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.RoleRepository;
import com.szabidev.webshop_backend.model.RoleModel;
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
import java.util.Arrays;
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

    private RoleModel roleModel;
    private Long ID = 1L;
    private String name = "name";


    @BeforeEach
    public void setup(){
        roleModel = new RoleModel();
        roleModel.setId(ID);
        roleModel.setName(name);
    }

    @Test
    public void getRoleById(){
        //given
        when(roleRepository.findById(ID)).thenReturn(Optional.of(roleModel));
        //when
        roleService.getRoleById(ID);
        //then
        verify(roleRepository, times(1)).findById(ID);
    }

    @Test
    public void findAllRoles(){
        //given
        when(roleRepository.findAll()).thenReturn(Arrays.asList(roleModel));
        //when
        roleService.findAllRoles();
        //then
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    public void create(){
        //given
        when(roleRepository.findByName(name)).thenReturn(Optional.empty());
        when(roleRepository.save(roleModel)).thenReturn(roleModel);
        //when
        roleService.createRole(roleModel);
        //then
        verify(roleRepository, times(1)).save(roleModel);
    }

    @Test
    public void createExisting(){
        //given
        when(roleRepository.findByName(name)).thenReturn(Optional.of(roleModel));
        //when
        roleService.createRole(roleModel);
        //then
        verify(roleRepository, times(0)).save(roleModel);
    }

    @Test
    public void patch(){
        //given
        when(roleRepository.existsById(ID)).thenReturn(true);
        when(roleRepository.findById(ID)).thenReturn(Optional.of(roleModel));
        when(roleRepository.save(roleModel)).thenReturn(roleModel);
        //when
        roleService.patchRole(roleModel, ID);
        //then
        verify(rolePopulator, times(1)).populatePatch(roleModel, roleModel);
        verify(roleRepository, times(1)).save(roleModel);
    }

    @Test
    public void patchExisting(){
        //given
        when(roleRepository.existsById(ID)).thenReturn(false);
       //when
        roleService.patchRole(roleModel, ID);
        //then
        verify(rolePopulator, times(0)).populatePatch(roleModel, roleModel);
        verify(roleRepository, times(0)).save(roleModel);
    }

    @Test
    public void delete(){
        //given
        when(roleRepository.findById(ID)).thenReturn(Optional.of(roleModel));

        //when
        roleService.deleteRoleById(ID);
        //then
        verify(roleRepository, times(1)).deleteById(ID);
    }

    @Test
    public void deleteNonExisting(){
        //given
        when(roleRepository.findById(ID)).thenReturn(Optional.empty());

        //when
        roleService.deleteRoleById(ID);
        //then
        verify(roleRepository, times(0)).deleteById(ID);
    }



}
