package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("categoryRepository")
public interface CategoryRepository  extends JpaRepository<CategoryModel, Long> {

}
