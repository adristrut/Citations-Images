package model;

import java.util.Random;

public class Question {

	private int nbErreurs = 0;
	private int nbreCoups = 0;
	private String chansonRep;
	private String[] artistQuest;
	// Tableau de chaine de caractères contenant les artistes
	private String[][] ListSingerSongs = {
			{ "Claude François", "Alain Souchon", "Johnny Hallyday",
					"Jacques Brel", "Julien Clerc", "Serge Gainsbourg",
					"Edith Piaf", "Georges Brassens", "Jacques Dutronc",
					"Charles Aznavour", "Daniel Balavoine", "Patrick Bruel",
					"Renaud", "Patricia Kaas" },
			{ "Comme d'habitude", "Foule sentimentale",
					"Les portes du pénitencier", "Ne me quitte pas", "Mélissa",
					"Le poinçonneur des Lilas", "Je ne regrette rien",
					"Les copains d'abord", "Paris s'éveille", "Les comédiens",
					"Le chanteur", "Place des grands hommes",
					"Mistral gagnant", "Mon mec à moi" } };

	public Question() {
		initQuestion();
	}

	/*
	 * initQuestion()
	 */
	public void initQuestion() {
		// sélection aléatoire de l'artiste
		this.chansonRep = "";
		this.artistQuest = new String[3];
		Random r = new Random();
		int valeur1 = r.nextInt(14), valeur2, valeur3;

		artistQuest[0] = ListSingerSongs[0][valeur1];
		this.chansonRep = ListSingerSongs[1][valeur1];
		System.out.println("Chanson du chanteur mystère : "
				+ ListSingerSongs[1][valeur1] + "");
		System.out.println("Le chanteur mystère est : "
				+ ListSingerSongs[0][valeur1] + "");
		do {
			valeur2 = r.nextInt(13);
			artistQuest[1] = ListSingerSongs[0][valeur2];
		} while (valeur2 == valeur1);
		do {
			valeur3 = r.nextInt(13);
			artistQuest[2] = ListSingerSongs[0][valeur3];
		} while ((valeur3 == valeur1) || (valeur3 == valeur2));

		this.nbreCoups = 0;
	}

	public boolean verifyQuestion(String s) {

		boolean bo = false;
		System.out
				.println("Nom de l'artiste comparé avec le choix du User dans le verify : "
						+ artistQuest[0]);
		if (s.compareTo(artistQuest[0]) == 0) {
			System.out.println("Bonne réponse");
			//nbErreurs = 0;
			bo = true;
		} else if (s.compareTo(artistQuest[0]) != 0 && nbErreurs == 2) {
			System.out.println("Mauvaise réponse. La bonne réponse était "
					+ this.artistQuest[0] + " de " + this.artistQuest[0]);
			//nbErreurs = 0;
			bo = false;
		} else if (s.compareTo(artistQuest[0]) != 0 && nbErreurs < 2) {
			System.out.println("Mauvaise réponse. Essaye encore !");
			//nbErreurs++;
			bo = false;
		} else
			System.out
					.println("Erreur ! Le test booléen ne fonctionne pas lors de la vérification de la réponse.");
		++this.nbreCoups;
		return bo;
	}

	public int getNbErreurs() {
		return nbErreurs;
	}

	public void setNbErreurs(int nbErreurs) {
		this.nbErreurs = nbErreurs;
	}

	public String getChanRep() {
		return chansonRep;
	}

	public void setChanRep(String chanRep) {
		this.chansonRep = chanRep;
	}

	public String[] getArtistQuest() {
		return artistQuest;
	}

	public void setArtistQuest(String[] artistQuest) {
		this.artistQuest = artistQuest;
	}

	public String[][] getListSingerSongs() {
		return ListSingerSongs;
	}

	public void setListSingerSongs(String[][] listSingerSongs) {
		ListSingerSongs = listSingerSongs;
	}

	public int getNombreCoups() {
		return nbreCoups;
	}

}
