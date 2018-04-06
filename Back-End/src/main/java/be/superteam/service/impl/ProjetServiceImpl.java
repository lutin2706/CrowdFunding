package be.superteam.service.impl;

import java.util.List;

import be.superteam.dao.CategorieDao;
import be.superteam.dao.TypeContributionDao;
import be.superteam.model.entity.Categorie;
import be.superteam.model.entity.TypeContribution;
import org.springframework.stereotype.Service;

import be.superteam.dao.ProjetDao;
import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	private ProjetDao projetDao;
	private CategorieDao categorieDao;
	private TypeContributionDao typeContributionDao;
	
	protected ProjetServiceImpl(ProjetDao projetDao, CategorieDao categorieDao, TypeContributionDao typeContributionDao) {
		this.projetDao = projetDao;
		this.categorieDao = categorieDao;
		this.typeContributionDao = typeContributionDao;
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
	public TypeContribution save(TypeContribution typeContribution) {
		return typeContributionDao.save(typeContribution);
	}

	@Override
	public List<TypeContribution> getAllByProjet(long projetId) {
		return typeContributionDao.getAllByProjet(projetDao.findById(projetId));
	}

	@Override
	public Projet findProjet(long id) {
		return projetDao.findById(id);
	}

}
