package com.logimastore;

import com.logimastore.dao.*;
import com.logimastore.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@SpringBootApplication
@ComponentScan({"com.logimastore.*"})
public class LogimastoreApplication {

    public static void main(String[] args) throws ParseException {
       ApplicationContext ctx = SpringApplication.run(LogimastoreApplication.class, args);

      /*  UserRoleRepository userRoleRepository= ctx.getBean(UserRoleRepository.class);

        userRoleRepository.save(new UserRole("oncobe-gfx@hotmail.fr","USER"));
        userRoleRepository.save(new UserRole("mohammed-gfx@hotmail.fr","USER"));

       Groupe groupe = new Groupe("Normal");



       Ville v1 = new Ville("Al Arouit",66500,"Nador","Oujda");
       String password1 = new BCryptPasswordEncoder().encode("abcd");

            User user1 = new User("ismail","barkani",new SimpleDateFormat("dd/MM/YY").parse("17/11/1995"),
                    "BD Resistance","0677553192",v1,groupe);



        VilleRepository villeRepository = ctx.getBean(VilleRepository.class);
        GroupeRepository groupeRepository = ctx.getBean(GroupeRepository.class);
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        LoginRepository loginRepository = ctx.getBean(LoginRepository.class);
        RoleRepository roleRepository = ctx.getBean(RoleRepository.class);




        villeRepository.save(v1);

        groupeRepository.save(groupe);

        userRepository.save(user1);

        loginRepository.save(new Compte("ab@ab.fr",password1,1,user1));

        ArticleRepository articleRepository = ctx.getBean(ArticleRepository.class);
        CategorieRepository categorieRepository = ctx.getBean(CategorieRepository.class);
        CategorieArticleRepository categorieArticleRepository = ctx.getBean(CategorieArticleRepository.class);


       //categorieRepository.save(new Categorie(("pc portable")));

     Article article = new Article(
             "\n" +
                     "TB02 Android 6.0 Tablet PC 10.1'' INCH Quad Core 3G Dual SIM 1GB+16GB IPS HD-Blue",
               699,20,"XGODY","Brand :  XGODY  \n" +
             "\n" +
             "Model :  TB02  \n" +
             "\n" +
             "Screen :  10.1 inch 2.5D Screen Arc 5-Point IPS HD Capacitive Touch Screen\n" +
             "\n" +
             "Resolution :  1280x800 \n" +
             "\n" +
             "CPU :  MTK6737 Quad-Core  \n" +
             "\n" +
             "RAM :  1GB DDR3  \n" +
             "\n" +
             "ROM :  16GB ROM \n" +
             "\n" +
             "Operating System :  Android 6.0.X Marshmallow  \n" +
             "\n" +
             "Band :  3G:(WCDMA 2100MHz) 2G:(GSM 850/900/1800/1900MHz)  \n" +
             "\n" +
             "Front Camera: 2.0MP \n" +
             "\n" +
             "Rear Camera: 5.0MP  \n" +
             "\n" +
             "WiFi :  Wi-Fi 802.11 b/g/n  \n" +
             "\n" +
             "Bluetooth :  YES  \n" +
             "\n" +
             "GPS :  YES  \n" +
             "\n" +
             "\n" +
             "\n" +
             "Play Store :  Yes, Support Thousands of APPS(Games, Skype ,MSN ,Facebook, Twitter, etc.)  \n" +
             "\n" +
             "Battery :  Built-in 4000mAh / 3.7V Li-ion Battery  \n" +
             "\n" +
             "Working Time :  2-3hours  \n" +
             "\n" +
             "Charge Time :  3-4 hours, Sometimes can only charge to 99%  \n" +
             "\n" +
             "Charge Mode :  Input AC 100-240V,Output DC 5V  \n" +
             "\n" +
             "Data Interface :  USB HOST 2.0 high speed interface (Micro),Support Extra Hard Disk, Ethernet, 3G Dongle and other peripherals\n" +
             "\n" +
             "Interface :  2xStanard Sim Card Slot 1xMicro USB 1xAudio Output 3.5mm 1xTF Card Slot  \n" +
             "\n" +
             "Size :  240mm x 170mm x 9 mm  \n" +
             "\n" +
             "Tablet Weight :  494g  \n" +
             "\n" +
             "Language :  Afrikaans, Azerbaijani, Indonesia, Malay, Catalan, Czech, Danish, Germany, English, Eesti, Spanish, French, Philippines, Croatian, Zulu, Italia, Kiswahili, Latviesu, Latvian, Hungarian, Dutch, Norsk Bokmal, Polish, Portuguese ; Romance, Romanian, Slovak, Finnish, Swedish, Vietnam, Turkish, Greek, Bulgarian, Arabic, Persian, Russian, Ukrainian, Serbian, Thai, Mongolian, Urdu, Hindi, Bengali, Korea, Japanese,Chinese  ",
               "1/img/articles/produit_tb02.jpg",
               "1/img/articles/thumb_tb021.jpg",
               "1/img/articles/thumb_tb022.jpg",
               "1/img/articles/thumb_ptb023.jpg",
               "1/img/articles/thumb_tb023.jpg",
               "noeuf");

        article=articleRepository.save(article);

        categorieArticleRepository.save(new CategorieArticle( new CategorieArticleCPC("tablette",article.getIdArticle())));
        */

    }

}
