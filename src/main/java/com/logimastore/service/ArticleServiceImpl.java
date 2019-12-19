package com.logimastore.service;

import com.logimastore.dao.ArticleRepository;
import com.logimastore.dao.CategorieArticleRepository;
import com.logimastore.dao.CompteRepository;
import com.logimastore.dao.LignePanierRepository;
import com.logimastore.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    CategorieArticleRepository categorieArticleRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LignePanierRepository lignePanierRepository;
    @Autowired
    CompteRepository compteRepository;

    @Override
    public Page<Article> listArticleByMotClet(String sort,Double prixSelect, String marque,String motClet,String motCletLib, Pageable pageable) {
        List<CategorieArticle> catArticle = categorieArticleRepository.chercherCategorieArticle(motClet);

        Article article;

        List<Article> listArticle = new ArrayList<Article>();
        for(CategorieArticle ca: catArticle){
            if(!listArticle.contains(articleRepository.getOne(ca.getCategorieArticle().getIdArticlec()))){
                article = articleRepository.getOne(ca.getCategorieArticle().getIdArticlec());
                if(article.getPrix()<prixSelect && article.getMarque().contains(marque) && article.getLibArticle().contains(motCletLib)){
                        listArticle.add(articleRepository.getOne(ca.getCategorieArticle().getIdArticlec()));
                }
            }

        }

        if(sort.equals("prix")){
            Collections.sort(listArticle, new SortByPrix());
        }
        else {
            Collections.sort(listArticle, new SortByDate());
        }
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize())> listArticle.size() ?  listArticle.size() : (start + pageable.getPageSize());

        Page<Article> pageArticle = new PageImpl<Article>(listArticle.subList(start,end),pageable,listArticle.size());

        return pageArticle;
    }

    @Override
    public List<Article> listArticlePanier(Long idUser) {

        List<Article> articles = new ArrayList<Article>();

        List<LignePanier> lignePaniers = lignePanierRepository.chercherPanier(idUser);
        for (LignePanier lp: lignePaniers) {
            articles.add(articleRepository.getOne(lp.getIdPanierArticle().getIdArticle()));
        }

        return articles;
    }

    @Override
    public void inscriptionEnregistrer(Compte compte) {
        String password = new BCryptPasswordEncoder().encode(compte.getPassword());
        compte.setPassword(password);

        compteRepository.save(compte);

    }

    @Override
    public boolean findEmail(Compte compte) {
        List<Compte> emails = compteRepository.findAll();
        for(Compte c:emails){
            if(c.getLogin().equals(compte.getLogin())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean stringNull(Compte compte) {
        if(compte.getUser().getNom().equals("")) return  true;
        return false;
    }
}
