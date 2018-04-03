package be.superteam.model.dto;

import be.superteam.model.entity.*;
import java.time.LocalDate;


public class ProjetDTO {

    private long id;

    private String nom;

    private LocalDate dateFin;

    private int montant;

    private String image;

    private String description;

    private String entrepreneuse;

    private Statut statut;

    private Long categorieId;

    public ProjetDTO() {
    }

    public ProjetDTO(Projet projet) {
        this.id = projet.getId();
        this.nom = projet.getNom();
        this.dateFin = projet.getDateFin();
        this.montant = projet.getMontant();
        this.image = projet.getImage();
        this.description = projet.getDescription();
        this.entrepreneuse = projet.getEntrepreneuse().getUsername();
        this.statut = projet.getStatut();
        this.categorieId = projet.getCategorie().getId();
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

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntrepreneuse() {
        return entrepreneuse;
    }

    public void setEntrepreneuse(String entrepreneuse) {
        this.entrepreneuse = entrepreneuse;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public long getCategorieId() {
        return categorieId;
    }

    public void setCategorie(long categorieId) {
        this.categorieId = categorieId;
    }

    public Projet toProjet(User entrepreneuse, Categorie categorie, Statut statut) {
        return new Projet(this.nom, this.dateFin, this.montant, this.image, this.description, entrepreneuse, statut, categorie);
    }
}
