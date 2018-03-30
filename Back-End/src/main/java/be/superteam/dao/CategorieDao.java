package be.superteam.dao;

import be.superteam.model.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

    Categorie save(Categorie cat);
}
