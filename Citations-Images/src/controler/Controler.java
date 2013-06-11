package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Model;
import observer.Observable;
import vue.Fenetre;
import vue.GamePanel;
import vue.ImageLabel;

/* Le Contrôleur est chargé de faire le lien entre notre vue et notre modèle. 
 * Que doit faire notre contrôleur? 
 * C'est lui qui va intercepter les actions de l'utilisateur, qui va modeler les données et les envoyer au modèle. 
 * Il devra donc :
 * - agir lors d'un clic sur une image ;
 * - avertir le modèle pour qu'il se réinitialise dans le cas d'un clic sur le bouton reset ;
 * - contrôler les données.
 * Voilà donc notre liste de méthodes pour cet objet. 
 * Cependant, puisque notre contrôleur doit interagir avec le modèle, 
 * il faudra qu'il possède une instance de notre modèle.
 * Nous avons défini les actions globales de notre objet de contrôle et vous constatez aussi qu'à chaque action dans notre contrôleur,
 * celui-ci invoque la méthode control(). Celle-ci va vérifier les données et informer le modèle en conséquence. 
 * Cette classe redéfinit la méthode control()et qu'elle permet d'indiquer les informations à envoyer à notre modèle. 
 * Celui-ci mis à jour, 
 * les données à afficher dans la vue seront envoyées via l'implémentation du pattern observer entre notre modèle et notre vue.
 */

public class Controler{
	
	//Référencement d'un objet environnement
	  private Model objMod;
	  
	  public Controler(Observable mod){
	    this.objMod = (Model) mod;
	    //this.choixUser = this.model.getQuest().getChanRep();
	    //System.out.println("Je suis dans le controleur"+choixUser+"");
	   }
	    
	  //Efface
	  public void reset(){
	    this.objMod.reset();
	  }
	/*
	  //Méthode de contrôle
	  public void control() {
		    //On notifie le modèle d'une action si le contrôle est bon
		    //--------------------------------------------------------
		
		    //Si l'opérateur est dans la liste
		    if(this.listOperateur.contains(this.operateur)){
		      //Si l'opérateur est = 
		      if(this.operateur.equals("="))
		        this.calc.getResultat(); //On ordonne au modèle d'afficher le résultat
		      //Sinon, on passe l'opérateur au modèle
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
            	char tab[] = {'É', 'È', 'Ê', 'Ë', c};
            	this.model.assign(tab);
            }                     

            else if (c == 'A'){
            	char tab[] = {'À', 'Â', 'Ä', c};
            	this.model.assign(tab);
            }                  

            else if(c == 'I'){
            	char tab[] = {'Î', 'Ï', c};
            	this.model.assign(tab);
            }

            else if (c == 'O'){
            	char tab[] = {'Ô', 'Ö', c};
            	this.model.assign(tab);
            }
            else if (c == 'U'){
            	char tab[] = {'Û', 'Ü', c};
            	this.model.assign(tab);
            }

            else if (c == 'C'){
            	char tab[] = {'Ç', c};
            	this.model.assign(tab);
            }
            
            else
            	this.model.assign(c);
   }
*/

	public void control(String text) {
		// TODO Auto-generated method stub
		this.objMod.getQuest().setChanRep(text);
		if(this.objMod.getQuest().verifyQuestion(text) == true)
		{
			System.out.println("Je suis dans le controleur !");
			JOptionPane.showMessageDialog(null,
                    "Bravo ! Vous avez trouvé le bon chanteur !",
					"Résultat",
					JOptionPane.INFORMATION_MESSAGE);			
		}
	    //System.out.println("Je suis dans le controleur"+choixUser+"");
		//this.choixUser = text;
		//model.assign(choixUser);
		
	}
}