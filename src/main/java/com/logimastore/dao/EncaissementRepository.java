package com.logimastore.dao;

import com.logimastore.entities.Encaissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncaissementRepository extends JpaRepository<Encaissement,Long>  {

}
