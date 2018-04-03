package be.superteam.service;

import be.superteam.model.entity.Categorie;

import java.util.List;

public interface CategorieService {

    List<Categorie> findCategories();

    Categorie findById(long id);
}
