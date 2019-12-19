package com.logimastore.web;

import com.logimastore.dao.CompteRepository;
import com.logimastore.dao.UserRepository;
import com.logimastore.dao.UserRoleRepository;
import com.logimastore.dao.VilleRepository;
import com.logimastore.entities.Compte;
import com.logimastore.entities.User;
import com.logimastore.entities.UserRole;
import com.logimastore.entities.Ville;
import com.logimastore.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class InscriptionController {


    @Autowired
    CompteRepository compteRepository;
    @Autowired
    VilleRepository villeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    UserRoleRepository userRoleRepository;

    @RequestMapping(value = "/inscription")
    public String inscription(Model model){

        model.addAttribute("compte",new Compte());
        model.addAttribute("ville",new Ville());
        model.addAttribute("user",new User());
        return "inscription";
    }

    @RequestMapping(value="/inscriptionConfirmation")
    public String inscriptionConfirmation(Model model, @Valid @ModelAttribute("compte") Compte compte,
                                          @Valid @ModelAttribute("ville") Ville ville,
                                          @Valid @ModelAttribute("user") User user,
                                          @RequestParam(value = "confirmePassword")String confirmePassword,
                                          BindingResult bindingRes){


        if (bindingRes.hasErrors()){
            return "inscription";
        }


        if(articleService.findEmail(compte)){
            model.addAttribute("exist",true);
            return "inscription";
        }


        if(!compte.getPassword().equals(confirmePassword)){
            model.addAttribute("notConfirme",true);
            return "inscription";
        }

        villeRepository.save(ville);
        user.setVille(ville);
        userRepository.save(user);
        compte.setUser(user);
        articleService.inscriptionEnregistrer(compte);
        userRoleRepository.save(new UserRole(compte.getLogin(),"USER"));

        return "inscriptionConfirmation";
    }
}
