package fr.sjo.heros.enums;

public enum Traduction {

	MSG_ERREUR ("Conditions initiales �ronn�es", "Wrong initial conditions"),
	MSG_DEPLACEMENT_IMPOSSIBLE ("D�placement impossible","Movement impossible"),
	MSG_FIC_TERRAIN_NON_TROUVE ("Fichier terrain non trouv�","Field file not found"),
	MSG_FIC_DEPLACEMENT_NON_TROUVE ("Fichier d�placement non trouv�","Move file not found");
	
	private final String valeurFr;
	private final String valeurEn;
	
	private Traduction(String valeurFr, String valeurEn) {
	    this.valeurFr = valeurFr;
	    this.valeurEn = valeurEn;
	}
	
	public String getValeurFr() {
	    return this.valeurFr;
	}
	
	public String getValeurEn() {
	    return this.valeurEn;
	}
}
