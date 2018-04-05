package be.superteam.model.entity;

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
public class TypeContribution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Projet projet;
	
	@ManyToMany(mappedBy = "types")
	private Set<Contribution> contributions = new HashSet<>();

	private TypeContribution() {
	}

	public TypeContribution(String name, Projet projet) {
		this.name = name;
		this.projet = projet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Set<Contribution> getContributions() {
		return contributions;
	}

	public void setContributions(Set<Contribution> contributions) {
		this.contributions = contributions;
	}

	@Override
	public String toString() {
		return "TypeContribution [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (projet != null ? "projet=" + projet : "") + "]";
	}
	
	
}
