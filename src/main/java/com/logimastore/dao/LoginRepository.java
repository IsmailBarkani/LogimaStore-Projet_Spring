package com.logimastore.dao;

import com.logimastore.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Compte,String> {
}
