package be.superteam.model.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Projet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String nom;
	
	@Column(nullable = false)
	private LocalDate dateFin;
	
	private int montant;
	
	private String image;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User entrepreneuse;
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Statut statut = Statut.BROUILLON;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Categorie categorie;
	
	@OneToMany
	private Set<Contribution> contributions = new HashSet<>();
	
	@OneToMany
	private Set<TypeContribution> typesContributions = new HashSet<>();

	protected Projet() {
	}

	public Projet(String nom, LocalDate dateFin, int montant, String image, String description, User entrepreneuse, Statut statut, Categorie categorie) {
		this.nom = nom;
		this.dateFin = dateFin;
		this.montant = montant;
		this.image = image;
		this.description = description;
		this.entrepreneuse = entrepreneuse;
		this.statut = statut;
		this.categorie = categorie;
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

	public User getEntrepreneuse() {
		return entrepreneuse;
	}

	public void setEntrepreneuse(User entrepreneuse) {
		this.entrepreneuse = entrepreneuse;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Set<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(Set<Contribution> contributions) {
		this.contributions = contributions;
	}

	
	public Set<TypeContribution> getTypesContributions() {
		return typesContributions;
	}

	public void setTypesContributions(Set<TypeContribution> typesContributions) {
		this.typesContributions = typesContributions;
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", " + (nom != null ? "nom=" + nom + ", " : "")
				+ (dateFin != null ? "dateFin=" + dateFin + ", " : "") + "montant=" + montant + ", "
				+ (image != null ? "image=" + image + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (entrepreneuse != null ? "entrepreneuse=" + entrepreneuse + ", " : "")
				+ (statut != null ? "statut=" + statut + ", " : "")
				+ (categorie != null ? "categorie=" + categorie : "") + "]";
	}

}
