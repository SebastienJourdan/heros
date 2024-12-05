package fr.sjo.heros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.sjo.heros.enums.Traduction;
import fr.sjo.heros.exceptions.HerosException;

public class Main {
	
	private final static String TERRAIN = "TERRAIN";
	private final static String POSITION = "POSITION";
	private final static String DEPLACEMENT = "DEPLACEMENT";
	
	public static void main(String[] args) {
		System.out.println(args[0]);
		if (args.length != 2) {
			System.out.println("Vous devez donner les chemins d'accès du fichier terrain et du fichier déplacement");
		} else {
			try {
				Map<String, Object> donnees = scanFichiers(args);
				Deplacement deplacement = new Deplacement((String[])donnees.get(POSITION));
				@SuppressWarnings("unchecked")
				int[] positionFinale = deplacement.deplacement((Map<Integer, String[]>)donnees.get(TERRAIN), 
						(String[])donnees.get(DEPLACEMENT));
				System.out.println("Position finale : " + positionFinale[0] + "," + positionFinale[1]);
			} catch (HerosException e) {
				System.out.println (e.getMsg());
			}
		}
	}
	
	private static Map<String, Object> scanFichiers(String[] args) throws HerosException {
		
		Map<String, Object> retour = new HashMap<String, Object>();
		Map<Integer, String[]> terrain = scanFichierTerrain(args[0]);
		retour.put(TERRAIN, terrain);
		
		Map<String, String[]> positionEtDeplacement = scanFichierDeplacement(args[1]);
		
		if (validite(terrain, positionEtDeplacement.get(POSITION))) {
			retour.put(TERRAIN, terrain);
			retour.put(POSITION, positionEtDeplacement.get(POSITION));
			retour.put(DEPLACEMENT, positionEtDeplacement.get(DEPLACEMENT));
		}
		
		return retour;
	}
	
	private static boolean validite(Map<Integer, String[]> terrain, String[] positionDeDepart) {
		boolean valide = true;
		
		// Le terrain a au moins une ligne
		if (terrain.get(1) == null) {
			System.out.println("Pas de terrain de jeu");
			valide = false;
		}
		
		// Les coordonnées de la position initiale sont dans les limites du terrain
		if (positionDeDepart != null) {
			try {
				int x = Integer.valueOf(positionDeDepart[0]);
				int y = Integer.valueOf(positionDeDepart[1]);
				String[] ligne = terrain.get(y);
				if (ligne == null || "#".equals(ligne[x])) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Mauvaises coordonnées de départ (hors terrain ou dans la forêt)");
				valide = false;
			}
		} else {
			valide = false;
		}

		return valide;
	}
	
	private static Map<Integer, String[]> scanFichierTerrain(String args) throws HerosException {
		Map<Integer, String[]> terrain = new HashMap<Integer, String[]>();
		
		try (Scanner scanner = new Scanner(new File(args))) {
			int ligne = 0;
			System.out.println("Voici le terrain");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] dec = line.split("");
                System.out.println(line);
                terrain.put(ligne, dec);
                ligne++;
            }
        } catch (FileNotFoundException e) {
			throw new HerosException(Traduction.MSG_FIC_TERRAIN_NON_TROUVE.getValeurFr());
		}
		
		return terrain;
	}
	
	private static Map<String, String[]> scanFichierDeplacement(String args) throws HerosException {
		Map<String, String[]> retour = new HashMap<String, String[]>();
		
		String[] positionDeDepart = null;
		String[] deplacements = null;
		try (Scanner scanner = new Scanner(new File(args))) {
			System.out.println("\nVoici le déplacement");
			int ligne = 1;
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (ligne == 1) {
					positionDeDepart = line.split(",");
				} else if (ligne == 2) {
					deplacements = line.split("");
				}
				ligne++;
				System.out.println(line);
            }
		} catch (FileNotFoundException e) {
			throw new HerosException(Traduction.MSG_FIC_DEPLACEMENT_NON_TROUVE.getValeurFr());
		}
		
		retour.put(POSITION, positionDeDepart);
		retour.put(DEPLACEMENT, deplacements);
		return retour;
	}
}
