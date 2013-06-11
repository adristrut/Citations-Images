package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import observer.Observable;
import observer.Observer;

public class Model implements Observable{

	// Tableau d'images qui stocke les images choisies
	private ImageIcon[] tabImages;
	private Question quest;
	private Partie part;
	private String chanteurChoisi, chansonQuest;
	private int nbQuestions = 1;

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();  

	public Model() {
		this.part = new Partie();
		initModel();
		//testModelCmd();	
	}
/*
	public void initModel(){
		
		String tab[] = new String[3];
		chansonQuest = "";

		//initialisation des images contenues dans le tableau
		this.tabImages = new ImageIcon[3];
		this.tabImages[0] = new ImageIcon("Images/visage-inconnu.jpg");
		this.tabImages[1] = new ImageIcon("Images/visage-inconnu.jpg");
		this.tabImages[2] = new ImageIcon("Images/visage-inconnu.jpg");
		this.notifyObserver();
	}
	*/
	
	//public void startModel(){
	public void initModel(){
		System.out.println("Je créé une nouvelle instance du modèle !");
		quest = new Question();
		String tab[] = new String[3];
		chansonQuest = this.quest.getChanRep();
		tab = quest.getArtistQuest();
		System.out.println(tab[0]);
		System.out.println(tab[1]);
		System.out.println(tab[2]);
		//initialisation des images contenues dans le tableau
		this.tabImages = new ImageIcon[3];
		this.tabImages[0] = new ImageIcon("Images/"+tab[0]+".jpg");
		this.tabImages[1] = new ImageIcon("Images/"+tab[1]+".jpg");
		this.tabImages[2] = new ImageIcon("Images/"+tab[2]+".jpg");

	//On avertit les observateurs que les images ont été mise à jour
	this.notifyObserver();
	}	
	
public void assign(String s){
		
		int i = 0;
		i = s.lastIndexOf(".");
		
		chanteurChoisi = s.substring(7,i);
		System.out.println("Traitement du choix de l'Utilisateur : "+chanteurChoisi);
		
		if(this.quest.verifyQuestion(chanteurChoisi) == true){
			
			if(this.nbQuestions <= 10)
			{
				this.part.initPoint(this.quest.getNbErreurs());
				this.part.setNombreQuest(this.part.getNombreQuest()+1);
				JOptionPane.showMessageDialog(null,
						                        "Vous avez trouvé en "+this.quest.getNombreCoups()+" "+" coup" + ((this.quest.getNombreCoups() > 1) ? "s" : "\n") +
						                        "que l'artiste de la chanson était << " + this.quest.getArtistQuest()[0] +
						                        " >> " +
												", avec " + this.quest.getNbErreurs() +
						                        " erreur" + ((this.quest.getNbErreurs() > 1) ? "s" : "") + ".\n" +
						                        "\tVous marquez donc " +
						                        this.part.getPointMarque() + " pts.\n" +
												"\tVotre avez maintenant un total de " +
												this.part.getPoint() + " pts.",
												"Résultat : Extrait n°"+this.nbQuestions+"",
												JOptionPane.INFORMATION_MESSAGE);
				//this.quest.initQuestion();
				this.quest.setNbErreurs(0);
				this.nbQuestions++;
				
				initModel();
				this.restartObserver();
			}
			
			this.notifyObserver();
		}
		else{
			this.quest.setNbErreurs(this.quest.getNbErreurs()+1);
			this.notifyObserver();
			
			if(this.quest.getNbErreurs() == 3){
				
				JOptionPane.showMessageDialog(null,
						                        "Le nom de l'artiste était :\n\t" +
						                        this.quest.getChanRep(),
												"Vous avez perdu", JOptionPane.NO_OPTION);
				/*
				if(this.scoreSerializer.isAccpeted(this.score)){
					String nom = "";
					nom  = (String)JOptionPane.showInputDialog(null,
										"Entrez votre pseudonyme :", "Félicitations",
										JOptionPane.QUESTION_MESSAGE);
					
					this.score.setNom(nom);
					this.scoreSerializer.serialize();
					this.scoreObserver();
				}
				else{
					JOptionPane.showMessageDialog(null,
				            "Désolé, vous avez perdu…\n" +
				            "\n\n\tVous n'avez malheureusement pas assez de points pour enregistrer votre score.\n" +
				            "Retentez votre chance à l'occasion !",
				            "Vous avez perdu", JOptionPane.NO_OPTION);
					this.accueilObserver();
				}*/			
			}
			else{
				this.notifyObserver();
			}
		}			
	}
	
	public void testModelCmd()
	{
		for(int i = 0;i<20; i++)
		{
			boolean test = false;
			chanteurChoisi = "Renaud";
			do {
				test = quest.verifyQuestion(chanteurChoisi);
			}
			while(test == false);
			initModel();
		}	
	}
	
	//Ajoute un observateur à la liste
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.listObserver.add(obs);
		this.notifyObserver();
	}
	
	//Avertit les observateurs que l'objet observable a changé 
	//et invoque la méthode update() de chaque observateur
	@Override
	public void notifyObserver() {
		//this.image = new ImageIcon("images/pendu"+this.mot.getNombreErreur()+".jpg");
		//this.tabImages[0] = new ImageIcon("Images/"+this.quest.getArtistQuest()[0]+".jpg");
		//this.tabImages[1] = new ImageIcon("Images/"+this.quest.getArtistQuest()[1]+".jpg");
		//this.tabImages[2] = new ImageIcon("Images/"+this.quest.getArtistQuest()[2]+".jpg");
		// TODO Auto-generated method stub
		//System.out.println(tabImages[0]);
		//System.out.println(tabImages[1]);
		//System.out.println(tabImages[2]);
	      for(Observer obs : this.listObserver)
	        obs.update(this.chansonQuest,""+this.tabImages[0]+"",""+this.tabImages[1]+"",""+this.tabImages[2]+"");
	}

	//Retire tous les observateurs de la liste
	@Override
	public void deleteObserver() {
		// TODO Auto-generated method stub
		this.listObserver = new ArrayList<Observer>();
	}

	public void reset() {
		// TODO Auto-generated method stub
		this.quest.initQuestion();
		//this.mot.initWord();
		//this.mot.setNombreErreur(0);
		//this.nombreMot = 0;
		//this.score = new Score();
	}

	@Override
	public void restartObserver() {
		// TODO Auto-generated method stub
		for(Observer obs : this.listObserver)
			obs.restart(this.quest.getChanRep());
	}

	@Override
	public void accueilObserver() {
		// TODO Auto-generated method stub
		
	}
	
	public String getChanteurChoisi() {
		return chanteurChoisi;
	}

	public void setChanteurChoisi(String chanteurChoisi) {
		this.chanteurChoisi = chanteurChoisi;
	}

	public ImageIcon[] getTabImages() {
		return tabImages;
	}

	public void setTabImages(ImageIcon[] tabImages) {
		this.tabImages = tabImages;
	}

	public Question getQuest() {
		return quest;
	}

	public void setQuest(Question quest) {
		this.quest = quest;
	}
}
