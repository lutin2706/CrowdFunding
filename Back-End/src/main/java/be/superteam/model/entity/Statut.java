package be.superteam.model.entity;

public enum Statut {

	BROUILLON("brouillon"),
	ATTENTE_VALIDATION("en attente de validation"),
	PUBLIE("publié"),
	VALIDE("validé"),
	ATTENTE_SUPPRESSION("en attente de suppression"),
	SUPPRIME("supprimé");
	
	private String name = "brouillon";
	
	Statut(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
