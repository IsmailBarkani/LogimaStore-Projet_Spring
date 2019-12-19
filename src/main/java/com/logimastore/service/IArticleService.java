package com.logimastore.service;

import com.logimastore.entities.Article;
import com.logimastore.entities.Compte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IArticleService {
    public Page<Article> listArticleByMotClet(String sort,Double prixSelect, String marque,String motClet,String motCletLib,Pageable pageable);

    public List<Article> listArticlePanier(Long idPanier);

    public void inscriptionEnregistrer(Compte compte);

    public boolean findEmail(Compte compte);
    public boolean stringNull(Compte compte);

}
