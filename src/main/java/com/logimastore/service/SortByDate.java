package com.logimastore.service;

import com.logimastore.entities.Article;

import java.util.Comparator;

public class SortByDate implements Comparator<Article> {
    @Override
    public int compare(Article o1, Article o2) {
        int r = (int) (o1.getDateAjoute().getTime() - o2.getDateAjoute().getTime());
        return r;
    }
}
