package com.logimastore.dao;

import com.logimastore.entities.Date_DB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface Date_DBRepository extends JpaRepository<Date_DB, Date> {
}
