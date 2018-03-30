package be.superteam.service.impl;

import java.util.List;

import be.superteam.dao.CategorieDao;
import be.superteam.model.entity.Categorie;
import org.springframework.stereotype.Service;

import be.superteam.dao.ProjetDao;
import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	private ProjetDao projetDao;
	private CategorieDao categorieDao;
	
	protected ProjetServiceImpl(ProjetDao projetDao, CategorieDao categorieDao) {
		this.projetDao = projetDao;
		this.categorieDao = categorieDao;
	}

	@Override
	public List<Projet> findAll() {
		return projetDao.findAll();
	}

	@Override
	public List<Projet> findProjetsVisibles() {
		return projetDao.findProjetsVisibles();
	}

	@Override
	public Projet save(Projet projet) {
		return projetDao.save(projet);
	}

	@Override
	public Categorie save(Categorie categorie) {
		return categorieDao.save(categorie);
	}

	@Override
	public Projet findProjet(long id) {
		return projetDao.findById(id);
	}

}
