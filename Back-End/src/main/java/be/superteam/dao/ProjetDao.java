package be.superteam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.superteam.model.entity.Projet;

public interface ProjetDao extends JpaRepository<Projet, Long> {

	List<Projet> findAll();
	
	
}
