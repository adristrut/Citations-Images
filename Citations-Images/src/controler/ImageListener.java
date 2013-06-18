package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Model;

import vue.GamePanel;
import vue.ImageLabel;

public class ImageListener implements MouseListener {

	GamePanel parent;
	Model objMod;

	public ImageListener(GamePanel parent, Model objMod) {
		this.parent = parent;
		this.objMod = objMod;
		// this.objMod = new Model();
		// this.objMod.initModel();

	}

	/*
	 * JButton boutonCliqué = (JButton) événement.getSource(); String
	 * texteChampAffichage = parent.champAffichage.getText();
	 * 
	 * // Retrouve le nombre présenté dans le champ texte s'il n'est pas vide if
	 * (!"".equals(texteChampAffichage)) { valeurAffichée = // analyse la chaîne
	 * de caractères formatNombres.parse( texteChampAffichage, new
	 * ParsePosition(0) ). // puis donne sa valeur en tant que double
	 * //doubleValue(); } Object sourceEvénement = événement.getSource();
	 */
	@Override
	public void mouseClicked(MouseEvent evenement) {
		// TODO Auto-generated method stub
		// ImageLabel imageClicked = (ImageLabel)evenement.getSource();
		String choixUser = (((ImageLabel) evenement.getSource()).getText());
		System.out.println("Le choix de l'utilisateur est : " + choixUser);
		this.objMod.assign(choixUser);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
