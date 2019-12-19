package com.logimastore.dao;

import com.logimastore.entities.PromotionArticleGroupe;
import com.logimastore.entities.PromotionArticleGroupeCPC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionArticleGroupeRepository extends JpaRepository<PromotionArticleGroupe, PromotionArticleGroupeCPC> {
}
