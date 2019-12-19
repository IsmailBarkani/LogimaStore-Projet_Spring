package com.logimastore.dao;

import com.logimastore.entities.LignePanier;
import com.logimastore.entities.LingePanierCPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LignePanierRepository extends JpaRepository<LignePanier, LingePanierCPC> {
    @Query("select p from LignePanier p where p.idPanierArticle.idUser = :x")
   List<LignePanier> chercherPanier(@Param("x")Long id);

}
