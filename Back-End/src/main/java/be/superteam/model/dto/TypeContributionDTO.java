package be.superteam.model.dto;

import be.superteam.model.entity.Projet;
import be.superteam.model.entity.TypeContribution;

public class TypeContributionDTO {

    private String nom;

    private long projetId;

    public TypeContributionDTO(TypeContribution typeContribution) {
        this.nom = typeContribution.getName();
        this.projetId = typeContribution.getProjet().getId();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getProjetId() {
        return projetId;
    }

    public void setProjetId(long projetId) {
        this.projetId = projetId;
    }

    public TypeContribution toTypeContribution(Projet projet) {
        return new TypeContribution(this.nom, projet);
    }
}
