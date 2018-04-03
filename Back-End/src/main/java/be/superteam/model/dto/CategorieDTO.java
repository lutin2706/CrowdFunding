package be.superteam.model.dto;

import be.superteam.model.entity.Categorie;
import be.superteam.model.entity.Projet;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class CategorieDTO {

    @Min(0)
    private long id;

    @NotNull
    private String nom;

    public CategorieDTO(Categorie categorie) {
        this.id = categorie.getId();
        this.nom = categorie.getNom();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
