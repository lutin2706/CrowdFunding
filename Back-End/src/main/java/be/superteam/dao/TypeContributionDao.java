package be.superteam.dao;

import be.superteam.model.entity.Projet;
import be.superteam.model.entity.TypeContribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TypeContributionDao extends JpaRepository<TypeContribution, Long> {

    TypeContribution save(TypeContribution typeContribution);

    List<TypeContribution> getAllByProjet(Projet projet);
}
