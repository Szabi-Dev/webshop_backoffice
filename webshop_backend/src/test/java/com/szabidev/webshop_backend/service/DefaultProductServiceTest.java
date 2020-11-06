package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.ProductRepository;
import com.szabidev.webshop_backend.model.ProductModel;
import com.szabidev.webshop_backend.service.impl.DefaultProductService;
import com.szabidev.webshop_backend.service.populator.impl.ProductPopulator;
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
public class DefaultProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductPopulator productPopulator;

    @InjectMocks
    private DefaultProductService service;

    private final Long ID = 1L;
    private final String code = "code";
    private ProductModel productModel;

    @BeforeEach
    void setUp(){
        productModel = new ProductModel();
        productModel.setId(ID);
        productModel.setCode(code);
    }

    @Test
    public void findAll(){
        //given
        when(productRepository.findAll()).thenReturn(Arrays.asList(productModel));
        //when
        service.findAllProducts();
        //then
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void findById(){
        //given
        when(productRepository.findById(ID)).thenReturn(Optional.of(productModel));
        //when
        service.getProductById(ID);
        //then
        verify(productRepository, times(1)).findById(ID);
    }

    @Test
    public void create(){
        //given
        when(productRepository.findByCode(code)).thenReturn(Optional.empty());
        when(productRepository.save(productModel)).thenReturn(productModel);
        //when
        service.createProduct(productModel);
        //then
        verify(productRepository, times(1)).findByCode(code);
        verify(productRepository, times(1)).save(any());
    }

    @Test
    public void createAlreadyExisting(){
        //given
        when(productRepository.findByCode(code)).thenReturn(Optional.of(productModel));

        //when
        service.createProduct(productModel);
        //then
        verify(productRepository, times(1)).findByCode(code);
        verify(productRepository, times(0)).save(productModel);
    }

    @Test
    public void delete(){
        //given
        when(productRepository.findById(ID)).thenReturn(Optional.of(productModel));
        //when
        service.deleteProduct(ID);
        //then
        verify(productRepository, times(1)).delete(productModel);
    }

    @Test
    public void deleteNonExisting(){
        //given
        when(productRepository.findById(ID)).thenReturn(Optional.empty());
        //when
        service.deleteProduct(ID);
        //then
        verify(productRepository, times(0)).delete(any());
    }


    @Test
    public void patch(){
        //given
        when(productRepository.findById(ID)).thenReturn(Optional.of(productModel));
        when(productRepository.save(productModel)).thenReturn(productModel);
        //when
        service.patchProduct(productModel, ID);
        //then
        verify(productPopulator, times(1)).populatePatch(productModel, productModel);
        verify(productRepository, times(1)).save(productModel);
    }

    @Test
    public void patchNonExisting(){
        //given
        when(productRepository.findById(ID)).thenReturn(Optional.empty());
        //when
        service.patchProduct(productModel, ID);
        //then
        verify(productPopulator, times(0)).populatePatch(productModel, productModel);
        verify(productRepository, times(0)).save(productModel);
    }

}
