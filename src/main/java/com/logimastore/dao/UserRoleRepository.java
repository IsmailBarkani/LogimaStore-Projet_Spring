package com.logimastore.dao;

import com.logimastore.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {
}
