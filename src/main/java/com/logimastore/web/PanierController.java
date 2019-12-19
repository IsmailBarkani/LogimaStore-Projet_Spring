package com.logimastore.web;

import com.logimastore.dao.ArticleRepository;
import com.logimastore.dao.CompteRepository;
import com.logimastore.dao.LignePanierRepository;
import com.logimastore.dao.LoginRepository;
import com.logimastore.entities.*;
import com.logimastore.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PanierController {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    LignePanierRepository lignePanierRepository;
    @Autowired
    ArticleServiceImpl articleService;
    Article article = new Article();

    @RequestMapping(value = "/panier")
    public String panier(Model model, @RequestParam(name = "idArticle",defaultValue = "0")Long id,@RequestParam(name = "idUser",defaultValue = "0") Long idUser){
        int nbr=0;
        double totale = 0;
        String username;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        if(!username.equals("anonymousUser")) {
            idUser = compteRepository.getOne(username).getUser().getId();
        }


        List<LignePanier>  lignePaniers = lignePanierRepository.chercherPanier(idUser);



        for(LignePanier lp:lignePaniers){
            nbr++;
        }

        List<Article> listeArticle = articleRepository.findAll();
        model.addAttribute("listArticle",listeArticle);

        List<Article> listeArticlePanier = articleService.listArticlePanier(idUser);
        for (Article article:listeArticlePanier){
            totale = totale + (article.getPrix()* lignePanierRepository.getOne(new LingePanierCPC(idUser,article.getIdArticle())).getQuantite());
        }
        model.addAttribute("listArticlePanier", listeArticlePanier);
        model.addAttribute("nbr",nbr);
        model.addAttribute("totale",totale);
       article = articleRepository.getOne(id);
        model.addAttribute("article",article);
        return "panier";
    }

    @RequestMapping(value = "/listePanier")
    public String listePanier(Model model, @RequestParam(name = "quantite",defaultValue = "1")int quantite,@RequestParam(name = "idUser",defaultValue = "0") Long idUser){
        int nbr=0;
        double totale = 0;
        String username;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        if(!username.equals("anonymousUser")) {
            idUser = compteRepository.getOne(username).getUser().getId();
        }


        List<LignePanier> lignePaniers = lignePanierRepository.chercherPanier(idUser);



        for(LignePanier lp:lignePaniers){
            nbr++;
        }

        List<Article> listeArticle = articleRepository.findAll();
        model.addAttribute("listArticle",listeArticle);

        List<Article> listeArticlePanier = articleService.listArticlePanier(idUser);
        for (Article article:listeArticlePanier){
            totale = totale + (article.getPrix()* lignePanierRepository.getOne(new LingePanierCPC(idUser,article.getIdArticle())).getQuantite());
        }
        model.addAttribute("listArticlePanier", listeArticlePanier);
        model.addAttribute("nbr",nbr);
        model.addAttribute("totale",totale);
        model.addAttribute("quantite",quantite);
        model.addAttribute("article",article);

      //  List<Article> listArticle = articleService.listArticlePanier(panier.getIdPanier());
        //model.addAttribute("listArticlePanier",listArticle);

        return "panier";
    }
}
