package com.logimastore.dao;

import com.logimastore.entities.CategorieArticle;
import com.logimastore.entities.CategorieArticleCPC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategorieArticleRepository extends JpaRepository<CategorieArticle, CategorieArticleCPC> {
    @Query("select ca from CategorieArticle ca where ca.categorieArticle.libelleCategorie like :x")
    public List<CategorieArticle> chercherCategorieArticle(@Param("x")String motClet);
}
