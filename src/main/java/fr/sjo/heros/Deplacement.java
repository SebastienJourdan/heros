package fr.sjo.heros;

import java.util.Map;

import fr.sjo.heros.enums.Traduction;
import fr.sjo.heros.exceptions.HerosException;

public class Deplacement {
	
	private String[] positionDeDepart;
	private int[] positionFinale = new int[2];
	
	public Deplacement() {
		this.positionDeDepart = null;
	}
	
	public Deplacement(String[] positionDeDepart) {
		this.positionDeDepart = positionDeDepart;
	}
	
	public int[] deplacement(Map<Integer, String[]> terrain, String[] deplacements) throws HerosException {
		this.positionFinale[0] = Integer.valueOf(this.positionDeDepart[0]);
		this.positionFinale[1] = Integer.valueOf(this.positionDeDepart[1]);
		
		if (this.positionDeDepart != null && deplacements != null) {
			for (String string : deplacements) {
				switch (string) {
					case "N":
						monte(terrain);
						break;
					case "S":
						descend(terrain);
						break;
					case "E":
						aDroite(terrain);
						break;
					case "O":
						aGauche(terrain);
						break;
					default:
						System.out.println(Traduction.MSG_DEPLACEMENT_IMPOSSIBLE.getValeurFr());
						break;
				}
			}
		} else {
			throw new HerosException(Traduction.MSG_ERREUR.getValeurFr());
		}
		
		return positionFinale;
	}
	
	private void monte(Map<Integer, String[]> terrain) {
		int ligneAAtteindre = this.positionFinale[1] - 1;
		int colonne = this.positionFinale[0];
		String[] ligne = terrain.get(ligneAAtteindre);
		if (ligne != null && !"#".equals(ligne[colonne])) {
			this.positionFinale[1] = ligneAAtteindre;
		} else {
			System.out.println(Traduction.MSG_DEPLACEMENT_IMPOSSIBLE.getValeurFr());
		}
	}
	
	private void descend(Map<Integer, String[]> terrain) {
		int ligneAAtteindre = this.positionFinale[1] + 1;
		int colonne = this.positionFinale[0];
		String[] ligne = terrain.get(ligneAAtteindre);
		if (ligne != null && !"#".equals(ligne[colonne])) {
			this.positionFinale[1] = ligneAAtteindre;
		} else {
			System.out.println(Traduction.MSG_DEPLACEMENT_IMPOSSIBLE.getValeurFr());
		}
	}
	
	private void aDroite(Map<Integer, String[]> terrain) {
		int colonneAAtteindre = this.positionFinale[0] + 1;
		int ligne = this.positionFinale[1];
		String[] ligneTerrain = terrain.get(ligne);
		if (ligneTerrain != null && !"#".equals(ligneTerrain[colonneAAtteindre])) {
			this.positionFinale[0] = colonneAAtteindre;
		} else {
			System.out.println(Traduction.MSG_DEPLACEMENT_IMPOSSIBLE.getValeurFr());
		}
	}
	
	private void aGauche(Map<Integer, String[]> terrain) {
		int colonneAAtteindre = this.positionFinale[0] - 1;
		int ligne = this.positionFinale[1];
		String[] ligneTerrain = terrain.get(ligne);
		if (ligneTerrain != null && !"#".equals(ligneTerrain[colonneAAtteindre])) {
			this.positionFinale[0] = colonneAAtteindre;
		} else {
			System.out.println(Traduction.MSG_DEPLACEMENT_IMPOSSIBLE.getValeurFr());
		}
	}
}
