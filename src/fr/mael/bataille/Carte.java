package fr.mael.bataille;

import java.util.Arrays;
import java.util.List;

public class Carte {

	public static List<String> COULEURS = Arrays.asList("Coeur", "Carreau", "Pique", "Trèfle");
	public static List<String> VALEURS = Arrays.asList("As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi");
	
	private int indexCouleur;
	private int indexValeur;
	
	public Carte (int indexCouleur, int indexValeur)
	{
		this.indexCouleur = indexCouleur;
		this.indexValeur = indexValeur;
	}
	
	public int getCouleurIndex()
	{
		return this.indexCouleur;
	}
	
	public String getCouleur()
	{
		return COULEURS.get(this.indexCouleur);
	}
	
	public int getValeurIndex()
	{
		return this.indexValeur;
	}
	
	public String getValeur()
	{
		return VALEURS.get(this.indexValeur);
	}
	
	public int compareTo(Carte carte)
	{
		if (this.indexValeur == 0 || carte.getValeurIndex() == 0)
		{
			if (this.indexValeur == 0 && carte.getValeurIndex() == 0) 
			{
				return 0;
			}
			
			if (this.indexValeur == 0) 
			{
				return 1;
			}
			
			if (carte.indexValeur == 0)
			{
				return -1;
			}
		} 
		else if (this.indexValeur > carte.indexValeur) 
		{
			return 1;
		}
		else if (carte.indexValeur > this.indexValeur)
		{
			return -1;
		}
		else if (this.indexValeur == carte.indexValeur)
		{
			return 0;
		}
		
		return -2;
	}
	
	public String toString()
	{
		return VALEURS.get(this.indexValeur) + " de " + COULEURS.get(this.indexCouleur);
	}
}
