package be.superteam.model.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contribution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int montant;
		
	@Column(nullable = false)
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User contributeur;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Projet projet;

	@ManyToMany
	private Set<TypeContribution> types = new HashSet<>();
	
	protected Contribution() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Set<TypeContribution> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeContribution> types) {
		this.types = types;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public User getContributeur() {
		return contributeur;
	}

	public void setContributeur(User contributeur) {
		this.contributeur = contributeur;
	}

	@Override
	public String toString() {
		return "Contribution [id=" + id + ", montant=" + montant + ", "
				+ (date != null ? "date=" + date + ", " : "")
				+ (contributeur != null ? "contributeur=" + contributeur + ", " : "")
				+ (projet != null ? "projet=" + projet : "") + "]";
	}

	
}
