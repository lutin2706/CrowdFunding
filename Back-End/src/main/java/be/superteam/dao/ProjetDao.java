package be.superteam.dao;

import java.util.List;

import be.superteam.model.entity.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import be.superteam.model.entity.Projet;
import org.springframework.data.jpa.repository.Query;

public interface ProjetDao extends JpaRepository<Projet, Long> {

	Projet save(Projet projet);

	List<Projet> findAll();

	Projet findById(long id);

	@Query("SELECT p from Projet p WHERE p.statut = 'PUBLIE' OR p.statut = 'VALIDE' OR p.statut = 'ATTENTE_SUPPRESSION'")
    List<Projet> findProjetsVisibles();
}
