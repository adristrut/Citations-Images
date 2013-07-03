package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AccueilPanel extends SContainer{
	
	public AccueilPanel(Dimension dim){
		super(dim);
		initPanel();
	}

	public void initPanel(){
		JLabel titre = new JLabel("Bienvenue dans le jeu Citations-Images");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setVerticalTextPosition(JLabel.CENTER);
		titre.setFont(comics40);
		
		JTextArea texte = new JTextArea("Vous avez deux chances pour trouver le chanteur caché. Si vous réussissez, on recommence !");
		texte.setFont(arial);
		texte.setEditable(false);
		texte.setBackground(Color.white);
		
		this.panel.add(new JLabel(new ImageIcon("Images/visage-inconnu.jpg")), BorderLayout.NORTH);
		this.panel.add(titre, BorderLayout.CENTER);
		this.panel.add(texte, BorderLayout.SOUTH);
		this.panel.setBackground(Color.red);
	}
	
}

