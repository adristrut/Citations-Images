package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.Controler;
import model.Model;

import observer.Observable;
import observer.Observer;

public class GamePanel extends SContainer implements Observer{

	private Dimension dimension = new Dimension();
	/*
	private int pts = 0;
	private ImageIcon img[];
	private String mot;
	private JLabel 	nombreArt, 
					score,
					motSecret;
	private JButton bouton[];
	*/
	private String mot;
	private JLabel 	nbArtistes,
					score,
					titreChanson,
					labelTitreChanson;
	private ImageLabel imageLabel1;
	private ImageLabel imageLabel2;
	private ImageLabel imageLabel3;
	private JButton boutonStart;
	
	private Controler controler;
	private Model model;
	private int ordreAffichage;
	
	public GamePanel(Dimension dim, Model mod){
		super(dim);
		this.controler = new Controler(mod);
		initPanel();
		//initPanel(mod);
	}

	protected void initPanel() {
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		JPanel centerContent = new JPanel();
		//System.out.println("Size : " + this.dimension.getWidth());
		//Dimension dim = new Dimension((int)(this.dimension.getWidth()/2), (int)this.dimension.getHeight());
		
		JPanel head = new JPanel();
		JPanel foot = new JPanel();
		
			this.imageLabel1 = new ImageLabel();
			this.imageLabel1.setPreferredSize(new Dimension(150, 150));
			this.imageLabel1.setHorizontalAlignment(JLabel.CENTER);
			//this.imageLabel1.setVerticalAlignment(JLabel.CENTER);
		
			this.imageLabel2 = new ImageLabel();
			this.imageLabel2.setPreferredSize(new Dimension(150, 150));
			this.imageLabel2.setHorizontalAlignment(JLabel.CENTER);
			//this.imageLabel2.setVerticalAlignment(JLabel.CENTER);			
		
			this.imageLabel3 = new ImageLabel();
			this.imageLabel3.setPreferredSize(new Dimension(150, 150));
			this.imageLabel3.setVerticalAlignment(JLabel.CENTER);
			
		this.nbArtistes = new JLabel();
		this.score = new JLabel(); 
		
		this.dimension = new Dimension(400, 530); 
		centerContent.setPreferredSize(this.dimension);
		
		Random r = new Random();
		ordreAffichage = r.nextInt(3);
		System.out.println(ordreAffichage);
		if(ordreAffichage==1)
		{
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
		}
		else if(ordreAffichage==2)
		{
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
		}
		else
		{
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
		}
		centerContent.setBackground(Color.white);
		
		leftContent.setPreferredSize(this.dimension);
		
		Dimension dim = new Dimension(410, 200);
		head.setPreferredSize(new Dimension(410, 100));
		
		this.nbArtistes.setText("Nombre d'artistes  trouvés : 0");
		this.nbArtistes.setPreferredSize(new Dimension(300, 20));
		this.nbArtistes.setHorizontalAlignment(JLabel.CENTER);
		this.nbArtistes.setFont(arial);
		
		head.add(this.nbArtistes, BorderLayout.NORTH);
		
		this.score.setText("Votre score actuel est de 0 point.");
		this.score.setPreferredSize(new Dimension(300, 20));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		this.score.setFont(arial);
		head.add(this.score, BorderLayout.SOUTH);
		head.setBackground(Color.white);
		
		
		JPanel body = new JPanel();
		body.setPreferredSize(dim);
		body.setBackground(Color.white);
		/*
		BoutonListener bl = new BoutonListener();
		Dimension buttonDimension = new Dimension(150,50);
		this.boutonStart = new JButton("Commencer");
		this.boutonStart.addActionListener(bl);
		boutonStart.setPreferredSize(buttonDimension);
		body.add(boutonStart);
		*/
		this.labelTitreChanson = new JLabel("\nTitre de la chanson : ");
		this.labelTitreChanson.setPreferredSize(new Dimension(400, 60));
		this.labelTitreChanson.setHorizontalAlignment(JLabel.CENTER);
		this.titreChanson = new JLabel("Titre de la chanson : ");
		this.titreChanson.setPreferredSize(new Dimension(400, 60));
		this.titreChanson.setForeground(Color.blue);
		this.titreChanson.setFont(comics30);
		this.titreChanson.setHorizontalAlignment(JLabel.CENTER);
		body.add(this.labelTitreChanson);
		body.add(this.titreChanson);
		
		ImageListener il = new ImageListener();
		imageLabel1.addMouseListener(il);
		imageLabel2.addMouseListener(il);
		imageLabel3.addMouseListener(il);

		/*
		this.bouton = new JButton[26];
		int i = 0;
		for(char c : carac){
			this.bouton[i] = new JButton(String.valueOf(c).toUpperCase());
			bouton[i].addActionListener(bl);
			bouton[i].setPreferredSize(buttonDimension);
			body.add(bouton[i]);
			i++;
		}
		*/
		
		leftContent.add(head, BorderLayout.NORTH);
		leftContent.add(body, BorderLayout.WEST);
		leftContent.setBackground(Color.white);
		
		this.panel.add(leftContent);
		this.panel.add(rightContent);
		this.panel.add(centerContent);
	}
	
	public void start(){		
		// Pour que les boutons puissent être sélectionnable quand on recommence la partie 
		//for(JButton bout : this.bouton)
		//	bout.setEnabled(true);
		this.imageLabel1.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel2.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel3.setImagePath("Images/visage-inconnu.jpg");
		this.titreChanson.setText("");
	}
	
	public void restart(String word){		
		// Pour que les boutons puissent être sélectionnable quand on recommence la partie 
		//for(JButton bout : this.bouton)
		//	bout.setEnabled(true);
		this.imageLabel1.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel2.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel3.setImagePath("Images/visage-inconnu.jpg");
		this.titreChanson.setText(word);
	}

	@Override
	public void update(String nomChanson, String img1Path, String img2Path, String img3Path) {
			this.titreChanson.setText(nomChanson);
			this.imageLabel1.setImagePath(img1Path);
			this.imageLabel2.setImagePath(img2Path);
			this.imageLabel3.setImagePath(img3Path);
	}

	@Override
	public void accueil() {
		// TODO Auto-generated method stub
		
	}
	
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			((JButton)e.getSource()).setEnabled(false);
			//controler.control(((JButton)e.getSource()).getText());
			//model = new Model();
			//model.startModel();
		}		
	}
	
	class ImageListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			//controler.control(((ImageLabel)arg0.getSource()).getText());
			System.out.println("Label de l'image cliquée : "+((ImageLabel)arg0.getSource()).getText());
			if(((ImageLabel) arg0.getSource()).getText() == imageLabel1.getText())
			{
				System.out.println("Label de l'image cliquée est la bonne !");
				JOptionPane.showMessageDialog(null,
                        "Bravo ! Vous avez trouvé le bon chanteur !",
						"Résultat",
						JOptionPane.INFORMATION_MESSAGE);
/*				JOptionPane.showMessageDialog(null,
                        "Vous avez trouvé le mot " + this.mot.getWord() +
                        " en " +
                        this.mot.getNombreCoup() + " coup" + ((this.mot.getNombreCoup() > 1) ? "s" : "") +
						", avec " + this.mot.getNombreErreur() +
                        " erreur" + ((this.mot.getNombreErreur() > 1) ? "s" : "") + ".\n" +
                        "\tVous marquez donc " +
                        this.score.getPointMarque() + " pts.\n" +
						"\tVotre avez maintenant un total de " +
						this.score.getPoint() + " pts.",
						"Résultat",
						JOptionPane.INFORMATION_MESSAGE);
*/			}
			
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

	@Override
	public void update(String nomChanson, ImageIcon imageIcon,
			ImageIcon imageIcon2, ImageIcon imageIcon3) {
		// TODO Auto-generated method stub
		
	}	
}

