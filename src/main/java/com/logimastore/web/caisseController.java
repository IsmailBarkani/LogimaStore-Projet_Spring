package com.logimastore.web;

import com.logimastore.dao.ArticleRepository;
import com.logimastore.dao.CompteRepository;
import com.logimastore.dao.LignePanierRepository;
import com.logimastore.entities.Article;
import com.logimastore.entities.Compte;
import com.logimastore.entities.LignePanier;
import com.logimastore.entities.LingePanierCPC;
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
public class caisseController {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    LignePanierRepository lignePanierRepository;

    Article article = new Article();


    @RequestMapping(value = "/caisse")
    public String caisse(Model model, @RequestParam(name = "quantite", defaultValue = "0") int quantite,
                         @RequestParam(name = "idArticle", defaultValue = "0") Long idArticle,
                         @RequestParam(name = "idUser", defaultValue = "0") Long idUser) {

        int nbr = 0;
        double totale = 0;
        String username;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        if (!username.equals("anonymousUser")) {
            idUser = compteRepository.getOne(username).getUser().getId();
        }
        if (quantite != 0) {
            lignePanierRepository.save(new LignePanier(new LingePanierCPC(idUser, idArticle), quantite));
        }


        List<LignePanier> lignePaniers = lignePanierRepository.chercherPanier(idUser);
        for (LignePanier lp : lignePaniers) {
            nbr++;
        }
        List<Article> listeArticlePanier = articleService.listArticlePanier(idUser);
        for (Article article : listeArticlePanier) {
            totale = totale + (article.getPrix() * lignePanierRepository.getOne(new LingePanierCPC(idUser, article.getIdArticle())).getQuantite());
        }
        model.addAttribute("listArticlePanier", listeArticlePanier);
        model.addAttribute("totale", totale);
        model.addAttribute("lignePaniers", lignePaniers);
        model.addAttribute("idArticle", idArticle);
        model.addAttribute("nbr", nbr);

        return "caisse";
    }


    @RequestMapping(value = "/listePanierArticle")
    public String listePanierArticle(Model model, @RequestParam(name = "quantite", defaultValue = "0") int quantite,
                                     @RequestParam(name = "idArticle", defaultValue = "0") Long idArticle,
                                     @RequestParam(name = "idUser", defaultValue = "0") Long idUser) {

        int nbr = 0;
        double totale = 0;
        String username;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        if (!username.equals("anonymousUser")) {
            idUser = compteRepository.getOne(username).getUser().getId();
        }
        if (quantite != 0) {
            lignePanierRepository.save(new LignePanier(new LingePanierCPC(idUser, idArticle), quantite));
        }


        List<LignePanier> lignePaniers = lignePanierRepository.chercherPanier(idUser);
        for (LignePanier lp : lignePaniers) {
            nbr++;
        }
        List<Article> listeArticlePanier = articleService.listArticlePanier(idUser);
        for (Article article : listeArticlePanier) {
            totale = totale + (article.getPrix() * lignePanierRepository.getOne(new LingePanierCPC(idUser, article.getIdArticle())).getQuantite());
        }
        model.addAttribute("listArticlePanier", listeArticlePanier);
        model.addAttribute("totale", totale);
        model.addAttribute("lignePaniers", lignePaniers);
        model.addAttribute("idArticle", idArticle);
        model.addAttribute("nbr", nbr);

        return "listePanier";
    }

    @RequestMapping(value = "/paiement")
    public String paiement(Model model, @RequestParam(name = "quantite",defaultValue = "1")int quantite,@RequestParam(name = "idUser",defaultValue = "0") Long idUser){
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

        return "paiement";
    }
    @RequestMapping(value = "/confirmation")
    public String confirmationPaiement(Model model, @RequestParam(name = "quantite",defaultValue = "1")int quantite,@RequestParam(name = "idUser",defaultValue = "0") Long idUser){
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
        return "confirmationPaiement";
    }
}
