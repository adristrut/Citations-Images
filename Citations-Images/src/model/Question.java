package model;

import java.util.Random;

public class Question {

	private int nbErreurs = 0;
	private int nbreCoups = 0;
	private String chansonRep;
	private String[] artistQuest;
	// Tableau de chaine de caract�res contenant les artistes
	private String[][] ListSingerSongs = {
			{ "Claude Fran�ois", "Alain Souchon", "Johnny Hallyday",
					"Jacques Brel", "Julien Clerc", "Serge Gainsbourg",
					"Edith Piaf", "Georges Brassens", "Jacques Dutronc",
					"Charles Aznavour", "Daniel Balavoine", "Patrick Bruel",
					"Renaud", "Patricia Kaas" },
			{ "Comme d'habitude", "Foule sentimentale",
					"Les portes du p�nitencier", "Ne me quitte pas", "M�lissa",
					"Le poin�onneur des Lilas", "Je ne regrette rien",
					"Les copains d'abord", "Paris s'�veille", "Les com�diens",
					"Le chanteur", "Place des grands hommes",
					"Mistral gagnant", "Mon mec � moi" } };

	public Question() {
		initQuestion();
	}

	/*
	 * initQuestion()
	 */
	public void initQuestion() {
		// s�lection al�atoire de l'artiste
		this.chansonRep = "";
		this.artistQuest = new String[3];
		Random r = new Random();
		int valeur1 = r.nextInt(14), valeur2, valeur3;

		artistQuest[0] = ListSingerSongs[0][valeur1];
		this.chansonRep = ListSingerSongs[1][valeur1];
		System.out.println("Chanson du chanteur myst�re : "
				+ ListSingerSongs[1][valeur1] + "");
		System.out.println("Le chanteur myst�re est : "
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
				.println("Nom de l'artiste compar� avec le choix du User dans le verify : "
						+ artistQuest[0]);
		if (s.compareTo(artistQuest[0]) == 0) {
			System.out.println("Bonne r�ponse");
			//nbErreurs = 0;
			bo = true;
		} else if (s.compareTo(artistQuest[0]) != 0 && nbErreurs == 2) {
			System.out.println("Mauvaise r�ponse. La bonne r�ponse �tait "
					+ this.artistQuest[0] + " de " + this.artistQuest[0]);
			//nbErreurs = 0;
			bo = false;
		} else if (s.compareTo(artistQuest[0]) != 0 && nbErreurs < 2) {
			System.out.println("Mauvaise r�ponse. Essaye encore !");
			//nbErreurs++;
			bo = false;
		} else
			System.out
					.println("Erreur ! Le test bool�en ne fonctionne pas lors de la v�rification de la r�ponse.");
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
