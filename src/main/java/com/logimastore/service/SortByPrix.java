package com.logimastore.service;

import com.logimastore.entities.Article;

import java.util.Comparator;

public class SortByPrix implements Comparator<Article> {


    @Override
    public int compare(Article o1, Article o2) {

        int r = (int) Math.round(o1.getPrix()-o2.getPrix());
        return r;
    }
}
