package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Model;

import observer.Observable;
import observer.Observer;

public class Fenetre extends JFrame implements Observer {

	private JMenuBar menu = null;

	private JMenu fichier = null;
	private JMenuItem nouveau = null;
	private JMenuItem score = null;
	private JMenuItem quitter = null;
	private JMenu apropos = null;
	private JMenuItem apropos2 = null;
	private JMenuItem rules = null;
	private JMenu customize = null;
	private JMenuItem ajouterEntree = null;
	private JMenuItem ajouterChanteurChanson = null;

	//private JPanel conteneur = new JPanel();
	private CustomComponents conteneur = new CustomComponents();
	private Dimension size;
	// private Observable model;
	private Model model1;

	public Fenetre() {
		Box box = new Box(BoxLayout.Y_AXIS);
        box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(Box.createVerticalGlue());
        box.add(conteneur);
        box.add(Box.createVerticalGlue());
        add(box);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(getMinimumSize());
        setMinimumSize(getMinimumSize());
        setPreferredSize(getPreferredSize());
        setLocation(150, 150);
        //setVisible(true);
		
		this.setTitle("Citations-Images");
		//this.setSize(1000, 400); // Taille(Largeur x Hauteur)
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setIconImage(new ImageIcon("Images/logo.png").getImage());
		//this.setDefaultLookAndFeelDecorated(false);    
		this.setExtendedState(this.MAXIMIZED_BOTH);
		
		
		/*
		 * this.model = obs; modif
		 * "Suppression du passage en paramètre d'un objet du type Observable"
		 * this.model.addObserver(this); modif
		 * "Suppression du passage en paramètre d'un objet du type Observable"
		 */
		// this.model1 = model;
		// this.model1.addObserver(this); A supprimer si on ne fait pas la ligne
		// au dessus (Null pointer Exception)
		this.size = new Dimension(this.getWidth(), this.getHeight());
		System.out.println(this.getWidth()+" "+this.getHeight());

		menu = new JMenuBar();

		fichier = new JMenu("Fichier");
		fichier.setMnemonic('f');
		// fichier.addActionListener(this);

		nouveau = new JMenuItem("Nouveau");
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 
				conteneur.removeAll();
				// Pour relancer une nouvelle partie avec un nouveau model
				initModel();
				GamePanel gp = new GamePanel(size, model1);
				// model.addObserver(gp); modif
				// "Suppression du passage en paramètre d'un objet du type Observable"
				model1.addObserver(gp);
				conteneur.add(gp.getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
			}
		});

		score = new JMenuItem("Score");
		score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				KeyEvent.CTRL_MASK));
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conteneur.removeAll();
				// conteneur.add(new ScorePanel(size,
				// model.getScores()).getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
				// model.reset(); modif
				// "Suppression du passage en paramètre d'un objet du type Observable"
				model1.reset();
			}
		});

		quitter = new JMenuItem("Quitter");
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				KeyEvent.CTRL_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fichier.add(nouveau);
		fichier.add(score);
		fichier.addSeparator();
		fichier.add(quitter);

		apropos = new JMenu("À propos");
		apropos.setMnemonic('o');
		// apropos.addActionListener(this);

		rules = new JMenuItem("Règles du jeu");
		rules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conteneur.removeAll();
				// conteneur.add(new RulesPanel(size).getPanel(),
				// BorderLayout.CENTER);
				conteneur.revalidate();
				// model.reset(); modif
				// "Suppression du passage en paramètre d'un objet du type Observable"
				model1.reset();
			}
		});

		apropos2 = new JMenuItem("   ?   ");
		apropos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Créateur : Adrien\nLicence : Freeware\nCopyright : Sophie LEBFEVRE Orthophoniste",
								"Informations", JOptionPane.NO_OPTION);
				conteneur.removeAll();
				System.out.println(size);
				conteneur.add(new AccueilPanel(size).getPanel());
				conteneur.revalidate();
				// model.reset(); modif
				// "Suppression du passage en paramètre d'un objet du type Observable"
				model1.reset();
			}
		});

		apropos.add(rules);
		apropos.add(apropos2);

		customize = new JMenu("Personnaliser");
		apropos.setMnemonic('o');
		// apropos.addActionListener(this);

		ajouterEntree = new JMenuItem("Ajouter une Entrée");
		ajouterEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conteneur.removeAll();
				// Pour relancer une nouvelle partie avec un nouveau model
				//initModel();
				//GamePanel gp = new GamePanel(size, model1);
				AjoutArtistTitlePanel atp = new AjoutArtistTitlePanel(size);

				// "Suppression du passage en paramètre d'un objet du type Observable"
				//model1.addObserver(gp);
				//conteneur.add(gp.getPanel(), BorderLayout.CENTER);
				//conteneur.revalidate();
				conteneur.removeAll();
				conteneur.add(atp.getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
				//model1.reset();
			}
		});

		ajouterChanteurChanson = new JMenuItem("Ajouter un Artiste & un titre");
		ajouterChanteurChanson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String artisteEtTitre = (String) JOptionPane.showInputDialog(null,
						// AppliJOptionPane.this,
						"Ajouter un artiste avec une nouvelle chanson : \n", "Ajouter un artiste avec un nouveau titre",
						JOptionPane.QUESTION_MESSAGE, null,// new
															// ImageIcon(getClass().getResource("logo.png")),
						null, // c'est ouvert !!!
						"Nom de l'Artiste.Titre de la chanson"); // valeur initiale
				if ((artisteEtTitre != null) && (artisteEtTitre.length() > 0))
					// model1.getQuest().getListSingerSongs()[model1.getQuest().getListSingerSongs().length][model1.getQuest().getListSingerSongs().length]
					model1.setChanteurChoisi("\"un plus un = ...\" "
							+ artisteEtTitre + "!");
				conteneur.removeAll();
				conteneur.add(new AccueilPanel(size).getPanel());
				conteneur.revalidate();
				// model.reset(); modif
				// "Suppression du passage en paramètre d'un objet du type Observable"
				// model1.reset();
			}
		});

		customize.add(ajouterEntree);
		customize.add(ajouterChanteurChanson);

		menu.add(fichier);
		menu.add(customize);
		menu.add(apropos);

		this.conteneur.setPreferredSize(this.size);
		//this.conteneur.setBackground(Color.blue);
		this.conteneur.add(new AccueilPanel(this.size).getPanel());
				
		//this.add(this.conteneur, BorderLayout.CENTER);
		//this.setContentPane(this.conteneur);
		this.setJMenuBar(menu);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
			// force chaque composant de la fenêtre à appeler sa méthode
			// updateUI
		} catch (InstantiationException e) {
		} catch (ClassNotFoundException e) {
		} catch (UnsupportedLookAndFeelException e) {
		} catch (IllegalAccessException e) {
		}
	}

	/*
	 * public void showScore(Score[] list){ conteneur.removeAll();
	 * conteneur.add(new ScorePanel(this.size, list).getPanel(),
	 * BorderLayout.CENTER); conteneur.revalidate(); model.reset(); }
	 */
	public void accueil() {
		System.out.println("Mise à jour de l'accueil…");
		conteneur.removeAll();
		conteneur.add(new AccueilPanel(size).getPanel(), BorderLayout.CENTER);
		conteneur.revalidate();
	}

	private void initModel() {
		/*
		 * this.model = new Model(); modif
		 * "Suppression du passage en paramètre d'un objet du type Observable"
		 * this.model.addObserver(this);
		 */
		this.model1 = new Model();
		this.model1.addObserver(this);
	}

	// public void update(String mot, int pts, String imgPath, int nbreMot) {}
	public void restart(String word) {
	}

	@Override
	public void update(String nomChanson, String img1Path, String img2Path,
			String img3Path) {
	}

	@Override
	public void update(String nomChanson, ImageIcon imageIcon,
			ImageIcon imageIcon2, ImageIcon imageIcon3) {
	}

	@Override
	public void update(String nomChanson, String img1Path, String img2Path,
			String img3Path, int pts, int nbArtist) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String nomChanson, String nomChanteur, String img1Path,
			String img2Path, String img3Path, int pts, int nbArtist) {
		// TODO Auto-generated method stub

	}

}
