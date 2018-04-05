package be.superteam.dao;

import be.superteam.model.entity.TypeContribution;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeContributionDao extends JpaRepository<TypeContribution, Long> {

    TypeContribution save(TypeContribution typeContribution);
}
