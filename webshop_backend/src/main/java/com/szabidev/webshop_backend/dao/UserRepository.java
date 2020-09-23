package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO to fetch user specific data
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
