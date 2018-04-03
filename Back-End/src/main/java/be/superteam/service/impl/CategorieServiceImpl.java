package be.superteam.service.impl;

import be.superteam.dao.CategorieDao;
import be.superteam.model.entity.Categorie;
import be.superteam.service.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieDao categorieDao;

    public CategorieServiceImpl(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }

    @Override
    public List<Categorie> findCategories() {
        return categorieDao.findAll();
    }

    @Override
    public Categorie findById(long id) {
        return categorieDao.findById(id).get();
    }
}
