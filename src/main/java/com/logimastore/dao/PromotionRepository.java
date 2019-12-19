package com.logimastore.dao;

import com.logimastore.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Float> {
}
