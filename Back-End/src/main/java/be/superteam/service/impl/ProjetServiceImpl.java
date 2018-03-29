package be.superteam.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import be.superteam.dao.ProjetDao;
import be.superteam.model.entity.Projet;
import be.superteam.service.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {

	private ProjetDao projetDao;
	
	
	protected ProjetServiceImpl(ProjetDao projetDao) {
		this.projetDao = projetDao;
	}

	@Override
	public List<Projet> findAll() {
		return projetDao.findAll();
	}

}
