package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.PrivilegeRepository;
import com.szabidev.webshop_backend.model.PrivilegeModel;
import com.szabidev.webshop_backend.service.impl.DefaultPrivilegeService;
import com.szabidev.webshop_backend.service.populator.impl.PrivilegePopulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultPrivilegeServiceTest {

    @Mock
    private PrivilegeRepository privilegeRepository;

    @Mock
    private PrivilegePopulator privilegePopulator;

    @InjectMocks
    private DefaultPrivilegeService defaultPrivilegeService;

    private final Long ID = 1L;
    private final String name = "privName";

    private PrivilegeModel privilegeModel;

    @BeforeEach
    public void init(){
        privilegeModel = new PrivilegeModel();
        privilegeModel.setName(name);
    }


    @Test
    public void testFindPrivilegeById(){
        //given
        when(privilegeRepository.findById(ID)).thenReturn(Optional.of(privilegeModel));
        //when
        defaultPrivilegeService.getPrivilegeById(ID);
        //then
        verify(privilegeRepository, times(1)).findById(ID);
    }

    @Test
    public void testFindAllPrivileges(){
        //given
        when(privilegeRepository.findAll()).thenReturn(new ArrayList<>());
        //when
        defaultPrivilegeService.findAllPrivileges();
        //then
        verify(privilegeRepository, times(1)).findAll();
    }

    @Test
    public void testDeletePrivilegeById(){
        //given
        when(privilegeRepository.findById(ID)).thenReturn(Optional.of(privilegeModel));
        //when
        Optional<PrivilegeModel> result = defaultPrivilegeService.deletePrivilegeById(ID);
        //then
        verify(privilegeRepository, times(1)).deleteById(ID);
        assertEquals(Optional.of(privilegeModel), result);
    }

    @Test
    public void testDeletePrivilegeByIdNotExists(){
        //given
        when(privilegeRepository.findById(ID)).thenReturn(Optional.empty());
        //when
        Optional<PrivilegeModel> result = defaultPrivilegeService.deletePrivilegeById(ID);
        //then
        verify(privilegeRepository, times(0)).deleteById(ID);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testCreatePrivilege(){
        //given
        when(privilegeRepository.findByName(name)).thenReturn(Optional.empty());
        when(privilegeRepository.save(privilegeModel)).thenReturn(privilegeModel);
        //when
        Optional<PrivilegeModel> result = defaultPrivilegeService.createPrivilege(privilegeModel);
        //then
        verify(privilegeRepository, times(1)).save(privilegeModel);
        assertEquals(Optional.of(privilegeModel), result);
    }

    @Test
    public void testCreatePrivilegeAlreadyExists(){
        //given
        when(privilegeRepository.findByName(name)).thenReturn(Optional.of(privilegeModel));
        //when
        Optional<PrivilegeModel> result = defaultPrivilegeService.createPrivilege(privilegeModel);
        //then
        verify(privilegeRepository, times(0)).save(privilegeModel);
        assertEquals(Optional.empty(), result);
    }

    @Test
    public void testUpdatePrivilege(){
        //given
        when(privilegeRepository.existsById(ID)).thenReturn(true);
        when(privilegeRepository.getOne(ID)).thenReturn(privilegeModel);
        when(privilegeRepository.findByName(name)).thenReturn(Optional.empty());
        when(privilegeRepository.save(privilegeModel)).thenReturn(privilegeModel);

        //when
        defaultPrivilegeService.updatePrivilege(privilegeModel, ID);
        //then
        verify(privilegePopulator, times(1)).populatePut(any(), any());
        verify(privilegeRepository, times(1)).save(privilegeModel);
    }

    @Test
    public void testUpdatePrivilegeNotExists(){
        //given
        when(privilegeRepository.existsById(ID)).thenReturn(false);
        when(privilegeRepository.findByName(name)).thenReturn(Optional.empty());
        when(privilegeRepository.save(privilegeModel)).thenReturn(privilegeModel);

        //when
        defaultPrivilegeService.updatePrivilege(privilegeModel, ID);
        //then
        verify(privilegePopulator, times(0)).populatePut(any(), any());
        verify(privilegeRepository, times(1)).save(privilegeModel);
    }

    @Test
    public void testPatchPrivilege(){
        //given
        when(privilegeRepository.existsById(ID)).thenReturn(true);
        when(privilegeRepository.getOne(ID)).thenReturn(privilegeModel);
        when(privilegeRepository.findByName(name)).thenReturn(Optional.empty());
        when(privilegeRepository.save(privilegeModel)).thenReturn(privilegeModel);

        //when
        defaultPrivilegeService.patchPrivilege(privilegeModel, ID);
        //then
        verify(privilegePopulator, times(1)).populatePatch(any(), any());
        verify(privilegeRepository, times(1)).save(privilegeModel);
    }

    @Test
    public void testPatchPrivilegeNotExists(){
        //given
        when(privilegeRepository.existsById(ID)).thenReturn(false);
        when(privilegeRepository.findByName(name)).thenReturn(Optional.empty());
        when(privilegeRepository.save(privilegeModel)).thenReturn(privilegeModel);

        //when
        defaultPrivilegeService.patchPrivilege(privilegeModel, ID);
        //then
        verify(privilegePopulator, times(0)).populatePatch(any(), any());
        verify(privilegeRepository, times(1)).save(privilegeModel);
    }

}
