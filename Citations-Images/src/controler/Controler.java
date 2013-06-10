package controler;

import java.util.ArrayList;

import model.Model;
import observer.Observable;

/* Le Contr�leur est charg� de faire le lien entre notre vue et notre mod�le. 
 * Que doit faire notre contr�leur? 
 * C'est lui qui va intercepter les actions de l'utilisateur, qui va modeler les donn�es et les envoyer au mod�le. 
 * Il devra donc :
 * - agir lors d'un clic sur une image ;
 * - avertir le mod�le pour qu'il se r�initialise dans le cas d'un clic sur le bouton reset ;
 * - contr�ler les donn�es.
 * Voil� donc notre liste de m�thodes pour cet objet. 
 * Cependant, puisque notre contr�leur doit interagir avec le mod�le, 
 * il faudra qu'il poss�de une instance de notre mod�le.
 * Nous avons d�fini les actions globales de notre objet de contr�le et vous constatez aussi qu'� chaque action dans notre contr�leur,
 * celui-ci invoque la m�thode control(). Celle-ci va v�rifier les donn�es et informer le mod�le en cons�quence. 
 * Cette classe red�finit la m�thode control()et qu'elle permet d'indiquer les informations � envoyer � notre mod�le. 
 * Celui-ci mis � jour, 
 * les donn�es � afficher dans la vue seront envoy�es via l'impl�mentation du pattern observer entre notre mod�le et notre vue.
 */
public class Controler{
	
	  protected Model model;
	  protected String choixUser;
	  //protected String operateur = "", nbre = "";
	  //protected ArrayList<String> listOperateur = new ArrayList<String>();

	  public Controler(Observable mod){
	    //this.choixUser = this.model.getQuest().getChanRep();
	    //System.out.println("Je suis dans le controleur"+choixUser+"");
	    this.model = (Model) mod;
	   }
	    
	  //Efface
	  public void reset(){
	    this.model.reset();
	  }
	/*
	  //M�thode de contr�le
	  public void control() {
		    //On notifie le mod�le d'une action si le contr�le est bon
		    //--------------------------------------------------------
		
		    //Si l'op�rateur est dans la liste
		    if(this.listOperateur.contains(this.operateur)){
		      //Si l'op�rateur est = 
		      if(this.operateur.equals("="))
		        this.calc.getResultat(); //On ordonne au mod�le d'afficher le r�sultat
		      //Sinon, on passe l'op�rateur au mod�le
		      else
		        this.calc.setOperateur(this.operateur);
		    }
		 
		    //Si le nombre est conforme
		    if(this.nbre.matches("^[0-9.]+$"))
		      this.calc.setNombre(this.nbre);
		 
		    this.operateur = "";
		    this.nbre = "";
		  }
	  
	public void control(char c){
            
            if (c == 'E'){
            	char tab[] = {'�', '�', '�', '�', c};
            	this.model.assign(tab);
            }                     

            else if (c == 'A'){
            	char tab[] = {'�', '�', '�', c};
            	this.model.assign(tab);
            }                  

            else if(c == 'I'){
            	char tab[] = {'�', '�', c};
            	this.model.assign(tab);
            }

            else if (c == 'O'){
            	char tab[] = {'�', '�', c};
            	this.model.assign(tab);
            }
            else if (c == 'U'){
            	char tab[] = {'�', '�', c};
            	this.model.assign(tab);
            }

            else if (c == 'C'){
            	char tab[] = {'�', c};
            	this.model.assign(tab);
            }
            
            else
            	this.model.assign(c);
   }
*/

	public void control(String text) {
		// TODO Auto-generated method stub
		this.model.getQuest().getChanRep();
		
	}
}