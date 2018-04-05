package be.superteam.service;

import java.util.List;

import be.superteam.model.entity.Categorie;
import be.superteam.model.entity.Projet;
import be.superteam.model.entity.Statut;
import be.superteam.model.entity.TypeContribution;
import org.springframework.data.jpa.repository.Query;

public interface ProjetService {

	List<Projet> findAll();

    List<Projet> findProjetsVisibles();

    Projet save(Projet projet);

    Projet findProjet(long id);

    Categorie save(Categorie categorie);

    TypeContribution save(TypeContribution typeContribution);
}
