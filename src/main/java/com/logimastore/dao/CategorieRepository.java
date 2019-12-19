package com.logimastore.dao;

import com.logimastore.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long>  {
}
