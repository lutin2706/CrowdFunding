package be.superteam.dao;

import be.superteam.model.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieDao extends JpaRepository<Categorie, Long> {

    Categorie save(Categorie cat);

    List<Categorie> findAll();
}
