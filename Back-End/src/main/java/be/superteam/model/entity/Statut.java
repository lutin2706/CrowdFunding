package be.superteam.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Statut {

	BROUILLON("brouillon"),
	ATTENTE_VALIDATION("en attente de validation"),
	PUBLIE("publié"),
	VALIDE("validé"),
	ATTENTE_SUPPRESSION("en attente de suppression"),
	SUPPRIME("supprimé");
	
	private String name;
	
	Statut(String name) {
		this.name = name;
	}

	@JsonValue
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return  name;
	}
}
