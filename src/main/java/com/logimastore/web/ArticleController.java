package com.logimastore.web;

import com.logimastore.dao.ArticleRepository;
import com.logimastore.dao.CompteRepository;
import com.logimastore.dao.LignePanierRepository;
import com.logimastore.dao.LoginRepository;
import com.logimastore.entities.*;
import com.logimastore.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    LignePanierRepository lignePanierRepository;



    @RequestMapping(value = "/")
    public  String  home(Model model,@RequestParam(name = "idUser",defaultValue = "0") Long idUser){
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

        return "home";
    }

    @RequestMapping(value = "/articles")
    private String articles(Model model,@RequestParam(name = "sort", defaultValue = "prix")String sort,
                            @RequestParam(name = "prixSelect", defaultValue = "100000") Double prixSelect,
                            @RequestParam(name = "marque", defaultValue = "") String marque,
                            @RequestParam(name = "page",defaultValue ="0") int p,
                            @RequestParam(name="size",defaultValue = "10")int s,
                            @RequestParam(name="motClet",defaultValue = "")String motClet,
                            @RequestParam(name="motCletLib",defaultValue = "")String motCletLib,
                            @RequestParam(name = "idUser",defaultValue = "0") Long idUser){
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




        Page<Article> listeArticle2;
        listeArticle2 = articleService.listArticleByMotClet(sort, prixSelect, marque,"%"+motClet+"%", motCletLib,new PageRequest(p,s));


        model.addAttribute("listArticle",listeArticle2.getContent());

        int[] pages = new int[listeArticle2.getTotalPages()];
        model.addAttribute("pages",pages);
        model.addAttribute("size",s);
        model.addAttribute("pageCourante",p);
        int nombrePage = listeArticle2.getTotalPages();
        System.out.println(nombrePage);
        System.out.println("hi");
        model.addAttribute("max",nombrePage);
        model.addAttribute("motClet",motClet);
        model.addAttribute("prixSelect",prixSelect);
        model.addAttribute("marque",marque);
        model.addAttribute("motCletLib",motCletLib);

        return "articles";
    }


    @RequestMapping(value = "/supprimer")
    public String supprimer(@RequestParam(name = "idArticle",defaultValue = "0")Long idArticle,
                            @RequestParam(name = "idUser",defaultValue = "0")Long idUser){

        String username;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        username = auth.getName();
        if(!username.equals("anonymousUser")) {
            idUser = compteRepository.getOne(username).getUser().getId();
        }

        LignePanier lp = lignePanierRepository.getOne(new LingePanierCPC(idUser,idArticle));
        lignePanierRepository.delete(lp);

        return "redirect:/?idUser="+idUser;
    }



}
