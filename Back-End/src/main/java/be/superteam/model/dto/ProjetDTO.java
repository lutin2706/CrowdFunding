package be.superteam.model.dto;

import be.superteam.model.entity.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


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

    private int montantRecolte;

    private List<Long> typesContributions;

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
        this.montantRecolte = projet.getContributions().stream().mapToInt(contrib -> contrib.getMontant()).sum();
        this.typesContributions = projet.getTypesContributions().stream().map(type -> type.getId()).collect(Collectors.toList());
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

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public int getMontantRecolte() {
        return montantRecolte;
    }

    public void setMontantRecolte(int montantRecolte) {
        this.montantRecolte = montantRecolte;
    }

    public List<Long> getTypesContributions() {
        return typesContributions;
    }

    public void setTypesContributions(List<Long> typesContributions) {
        this.typesContributions = typesContributions;
    }

    public Projet toProjet(User entrepreneuse, Categorie categorie, Statut statut) {
        return new Projet(this.nom, this.dateFin, this.montant, this.image, this.description, entrepreneuse, statut, categorie);
    }
}
