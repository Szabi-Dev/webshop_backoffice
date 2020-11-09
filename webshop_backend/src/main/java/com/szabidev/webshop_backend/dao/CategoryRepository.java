package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("categoryRepository")
public interface CategoryRepository  extends JpaRepository<CategoryModel, Long> {

    /**
     * Fetch category by code
     * @param code - code
     * @return {@link Optional<CategoryModel>}
     */
    Optional<CategoryModel> findByCode(String code);
}
