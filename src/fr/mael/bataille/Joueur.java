package fr.mael.bataille;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueur {

	private List<Carte> cartes = new ArrayList<>();
	private int score;
	private String name;
	
	public Joueur(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	private void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public Carte drawCarte() {
		Random rand = new Random();
		Carte carte = cartes.get(rand.nextInt(cartes.size()));
		cartes.remove(carte);
		return carte;
	}
	
	public void addCarte(Carte carte) {
		this.addScore(1);
		cartes.add(carte);
	}
	
	public List<Carte> getCartes() {
		return cartes;
	}
}
