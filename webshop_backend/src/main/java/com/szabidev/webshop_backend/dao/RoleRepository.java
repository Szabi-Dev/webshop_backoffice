package com.szabidev.webshop_backend.dao;

import com.szabidev.webshop_backend.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
