package com.logimastore.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class FavouriserCPC implements Serializable {

    @Column(name = "idUser")
    private Long idUser;
    @Column(name = "idArticle")
    private Long idArticle;

    public FavouriserCPC(Long idUser, Long idArticle) {
        this.idUser = idUser;
        this.idArticle = idArticle;
    }

    public FavouriserCPC() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }
}
