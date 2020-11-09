package com.szabidev.webshop_backend.service;

import com.szabidev.webshop_backend.dao.CategoryRepository;
import com.szabidev.webshop_backend.model.CategoryModel;
import com.szabidev.webshop_backend.service.impl.DefaultCategoryService;
import com.szabidev.webshop_backend.service.populator.impl.CategoryPopulator;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryPopulator categoryPopulator;

    @InjectMocks
    private DefaultCategoryService service;

    private final Long ID = 1L;
    private CategoryModel categoryModel;
    private String code = "code";

    @BeforeEach
    void setUp(){
        categoryModel = new CategoryModel();
        categoryModel.setId(ID);
        categoryModel.setCode(code);
    }

    @Test
    public void findAllCategories() {
        //given
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(categoryModel));
        //when
        service.findAllCategories();
        //then
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void findCategoryById() {
        //given
        when(categoryRepository.findById(ID)).thenReturn(Optional.of(categoryModel));
        //when
        service.getCategoryById(ID);
        //then
        verify(categoryRepository, times(1)).findById(ID);
    }

    @Test
    public void createCategory() {
        //given
        when(categoryRepository.save(categoryModel)).thenReturn(categoryModel);
        when(categoryRepository.findByCode(code)).thenReturn(Optional.empty());
        //when
        service.createCategory(categoryModel);
        //then
        verify(categoryRepository, times(1)).save(categoryModel);
    }

    @Test
    public void createCategoryExisting() {
        //given
        when(categoryRepository.findByCode(code)).thenReturn(Optional.of(categoryModel));
        //when
        service.createCategory(categoryModel);
        //then
        verify(categoryRepository, times(0)).save(categoryModel);
    }


    @Test
    public void patchCategory() {
        //given
        when(categoryRepository.findById(ID)).thenReturn(Optional.of(categoryModel));
        when(categoryRepository.save(categoryModel)).thenReturn(categoryModel);
        //when
        service.patchCategory(categoryModel, ID);
        //then
        verify(categoryRepository, times(1)).save(categoryModel);
        verify(categoryPopulator, times(1)).populatePatch(categoryModel, categoryModel);
    }

    @Test
    public void patchCategoryNonExisting() {
        //given
        when(categoryRepository.findById(ID)).thenReturn(Optional.empty());
        //when
        service.patchCategory(categoryModel, ID);
        //then
        verify(categoryRepository, times(0)).save(categoryModel);
        verify(categoryPopulator, times(0)).populatePatch(categoryModel, categoryModel);
    }

    @Test
    public void deleteCategory() {
        //given
        when(categoryRepository.findById(ID)).thenReturn(Optional.of(categoryModel));
        //when
        service.deleteCategory(ID);
        //then
        verify(categoryRepository, times(1)).delete(categoryModel);
    }

    @Test
    public void deleteCategoryNonExisting() {
        //given
        when(categoryRepository.findById(ID)).thenReturn(Optional.empty());
        //when
        service.deleteCategory(ID);
        //then
        verify(categoryRepository, times(0)).delete(categoryModel);
    }


}
