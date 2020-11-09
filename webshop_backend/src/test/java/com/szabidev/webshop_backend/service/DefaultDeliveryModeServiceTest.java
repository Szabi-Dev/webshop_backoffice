package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.DeliveryModeRepository;
import com.szabidev.webshop_backend.model.DeliveryModeModel;
import com.szabidev.webshop_backend.service.impl.DefaultDeliveryModeService;
import com.szabidev.webshop_backend.service.populator.impl.DeliveryModePopulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultDeliveryModeServiceTest {

    @Mock
    private DeliveryModeRepository deliveryModeRepository;

    @Mock
    private DeliveryModePopulator populator;

    @InjectMocks
    private DefaultDeliveryModeService service;

    private DeliveryModeModel deliveryModeModel;
    private Long Id = 1L;
    private String code = "code";

    @BeforeEach
    public void setUp(){
        deliveryModeModel = new DeliveryModeModel();
        deliveryModeModel.setCode(code);
        deliveryModeModel.setId(Id);
    }

    @Test
    public void findById(){
      //given
        when(deliveryModeRepository.findById(Id)).thenReturn(Optional.of(deliveryModeModel));
      //when
        service.getDeliveryModeById(Id);
      //then
        verify(deliveryModeRepository, times(1)).findById(Id);
    }

    @Test
    public void findAll(){
        //given
        when(deliveryModeRepository.findAll()).thenReturn(Arrays.asList(deliveryModeModel));
        //when
        service.findAllDeliveryModes();
        //then
        verify(deliveryModeRepository, times(1)).findAll();
    }

    @Test
    public void create(){
        //given
        when(deliveryModeRepository.save(deliveryModeModel)).thenReturn(deliveryModeModel);
        when(deliveryModeRepository.findByCode(code)).thenReturn(Optional.empty());
        //when
        service.createDeliveryMode(deliveryModeModel);
        //then
        verify(deliveryModeRepository, times(1)).findByCode(code);
        verify(deliveryModeRepository, times(1)).save(deliveryModeModel);
    }

    @Test
    public void createExisting(){
        //given
        when(deliveryModeRepository.findByCode(code)).thenReturn(Optional.of(deliveryModeModel));
        //when
        service.createDeliveryMode(deliveryModeModel);
        //then
        verify(deliveryModeRepository, times(1)).findByCode(code);
        verify(deliveryModeRepository, times(0)).save(deliveryModeModel);
    }

    @Test
    public void patch(){
        //given
        when(deliveryModeRepository.save(deliveryModeModel)).thenReturn(deliveryModeModel);
        when(deliveryModeRepository.findById(Id)).thenReturn(Optional.of(deliveryModeModel));

        //when
        service.patchDeliveryMode(deliveryModeModel, Id);
        //then
        verify(populator, times(1)).populatePatch(deliveryModeModel, deliveryModeModel);
        verify(deliveryModeRepository, times(1)).save(deliveryModeModel);
    }

    @Test
    public void patchNonExistent(){
        //given
        when(deliveryModeRepository.findById(Id)).thenReturn(Optional.empty());

        //when
        service.patchDeliveryMode(deliveryModeModel, Id);
        //then
        verify(populator, times(0)).populatePatch(deliveryModeModel, deliveryModeModel);
        verify(deliveryModeRepository, times(0)).save(deliveryModeModel);
    }

    @Test
    public void delete(){
        //given
        when(deliveryModeRepository.findById(Id)).thenReturn(Optional.of(deliveryModeModel));

        //when
        service.deleteDeliveryMode(Id);
        //then

        verify(deliveryModeRepository, times(1)).deleteById(Id);
    }

    @Test
    public void deleteNoinExistent(){
        //given
        when(deliveryModeRepository.findById(Id)).thenReturn(Optional.empty());

        //when
        service.deleteDeliveryMode(Id);
        //then

        verify(deliveryModeRepository, times(0)).deleteById(Id);
    }

}
