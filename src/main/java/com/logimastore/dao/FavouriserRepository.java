package com.logimastore.dao;

import com.logimastore.entities.Favouriser;
import com.logimastore.entities.FavouriserCPC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriserRepository extends JpaRepository<Favouriser, FavouriserCPC> {


}
