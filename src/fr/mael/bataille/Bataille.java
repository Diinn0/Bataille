package fr.mael.bataille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bataille {

	public static void main(String[] args) {

		Joueur j1 = new Joueur("Joueur 1");
		Joueur j2 = new Joueur("Joueur 2");
		
		List<Carte> cartes = new ArrayList<Carte>();
		
		for (int i = 0; i < Carte.COULEURS.size(); i++)
		{
			for (int j = 0; j < Carte.VALEURS.size(); j++)
			{
				Carte carte = new Carte(i, j);
				cartes.add(carte);
			}
		}
		
		Collections.shuffle(cartes);
		
		for (int i = 0; i < cartes.size(); i++) {
			if (i < cartes.size() / 2) {
				j1.addCarte(cartes.get(i));
			} else {
				j2.addCarte(cartes.get(i));
			}
		}
		
		System.out.println("=======================");
		
		while (j1.getCartes().size() > 0 && j2.getCartes().size() > 0)
		{
			Carte carteJ1 = j1.drawCarte();
			Carte carteJ2 = j2.drawCarte();
			List<Carte> reserve = new ArrayList<>();
			int compare = carteJ1.compareTo(carteJ2);
			
			if (compare == 1) {
				j1.addCarte(carteJ1);
				j1.addCarte(carteJ2);
				
				for (Carte carte : reserve) {
					j1.addCarte(carte);					
				}
				reserve.clear();
				
				System.out.println(carteJ1 + " > " + carteJ2);
			} 
			else if (compare == -1) 
			{
				j2.addCarte(carteJ1);
				j2.addCarte(carteJ2);
				
				for (Carte carte : reserve) {
					j2.addCarte(carte);					
				}
				reserve.clear();
				
				System.out.println(carteJ1 + " < " + carteJ2);
			} else {
				reserve.add(carteJ1);
				reserve.add(carteJ2);
								
				System.out.println(carteJ1 + " = " + carteJ2);

			}
				
		}
		
		System.out.println("Score J1: " + j1.getScore());
		System.out.println("Score J2: " + j2.getScore());

		
		
		if (j1.getCartes().size() == 0)
		{
			System.out.println("J2 Gagne");
		}
		
		if (j2.getCartes().size() == 0)
		{
			System.out.println("J1 Gagne");
		}
		
	}

}
