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
	
	//R�f�rencement d'un objet environnement
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
		this.objMod.getQuest().setChanRep(text);
		if(this.objMod.getQuest().verifyQuestion(text) == true)
		{
			System.out.println("Je suis dans le controleur !");
			JOptionPane.showMessageDialog(null,
                    "Bravo ! Vous avez trouv� le bon chanteur !",
					"R�sultat",
					JOptionPane.INFORMATION_MESSAGE);			
		}
	    //System.out.println("Je suis dans le controleur"+choixUser+"");
		//this.choixUser = text;
		//model.assign(choixUser);
		
	}
}