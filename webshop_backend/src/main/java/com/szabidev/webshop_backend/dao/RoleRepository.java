package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    /**
     * Find roles by name
     * @param name - name
     * @return {@link Optional<RoleModel>}
     */
    Optional<RoleModel> findByName(String name);
}
