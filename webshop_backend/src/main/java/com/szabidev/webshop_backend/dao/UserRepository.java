package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DAO to fetch user specific data
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserModel, Long> {

    /**
     * Fetch user by email
     *
     * @param email - email
     * @return {@link Optional<UserModel>}
     */
    Optional<UserModel> findByEmail(String email);
}
