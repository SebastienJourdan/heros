package fr.sjo.heros.enums;

public enum Traduction {

	MSG_ERREUR ("Conditions initiales éronnées", "Wrong initial conditions"),
	MSG_DEPLACEMENT_IMPOSSIBLE ("Déplacement impossible","Movement impossible"),
	MSG_FIC_TERRAIN_NON_TROUVE ("Fichier terrain non trouvé","Field file not found"),
	MSG_FIC_DEPLACEMENT_NON_TROUVE ("Fichier déplacement non trouvé","Move file not found");
	
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
