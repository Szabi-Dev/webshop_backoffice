package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.PrivilegeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * DAO to fetch {@link PrivilegeModel}
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<PrivilegeModel, Long> {

    /**
     * Find privilege by name
     * @param name - name
     * @return {@link Optional<PrivilegeModel>}
     */
    Optional<PrivilegeModel> findByName(String name);
}
