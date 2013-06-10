package model;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Observer;
import java.util.Random;

import observer.Observable;

public class Partie {
//public class Model implements Observable {	

	// Tableau d'images qui stocke les images choisies
	private ImageIcon[] tabImages;
	// Tableau de chaine de caractères contenant les artistes
	private String[][] chanteurs = {
			{ "Claude François", "Alain Souchon", "Johnny Hallyday","Jacques Brel", "Julien Clerc", "Serge Gainsbourg","Edith Piaf", "Georges Brassens", "Jacques Dutronc","Charles Aznavour", "Daniel Balavoine", "Patrick Bruel",	"Renaud", "Patricia Kaas" },
			{ "Comme d'habitude","Foule sentimentale","Les portes du pénitencier", "Ne me quitte pas","Mélissa", "Le poinçonneur des Lilas","Je ne regrette rien","Les copains d'abord", "Paris s'éveille", "Les comédiens","Le chanteur", "Place des grands hommes","Mistral gagnant", "Mon mec à moi" } };


	private String chanson;

	//public Model() {
	public Partie(){
		initPartie();
	}

	public void initPartie(){
		// sélection aléatoire de l'artiste
		this.chanson = "";
		Random r = new Random();
		int valeur1 = r.nextInt(14), valeur2, valeur3;
		this.chanson = chanteurs[1][valeur1];
		System.out.println("Chanson du chanteur mystère : "+chanteurs[1][valeur1]+"");
		System.out.println("Le chanteur mystère est : "+ chanteurs[0][valeur1] + "");
		do{
			valeur2 = r.nextInt(13);
		}while(valeur2 == valeur1);
		do{
			valeur3 = r.nextInt(13);
		}while((valeur3 == valeur1)||(valeur3 == valeur2));
		
		//initialisation des images contenues dans le tableau
		this.tabImages = new ImageIcon[3];
	this.tabImages[0] = new ImageIcon("Images/"+this.chanteurs[0][valeur1]+".jpeg");
	this.tabImages[1] = new ImageIcon("Images/"+this.chanteurs[0][valeur2]+".jpeg");
	this.tabImages[2] = new ImageIcon("Images/"+this.chanteurs[0][valeur3]+".jpeg");
	
	//this.notifyObserver();
	}	
	/*
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteObserver() {
		// TODO Auto-generated method stub

	}
	 */
}
