package vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import vue.JPanelChamp;

import observer.Observer;

public class AjoutArtistTitlePanel extends SContainer implements Observer {

	private AudioPlayer player;
	private JFileChooser chooser;
	private AbstractAction stop;

	private AbstractAction play;
	private AbstractAction load;
	private JPanel centerContent;
	private JLabel title;
	private JLabel formTitle;
	
	private JLabel labelThematique;
	private JComboBox chxThematique;
	
	private JLabel labelNomEntite;
	private JTextField textNomEntite;
	private String nomEntite;
	
	private JLabel labelTxtAssocie;
	private JTextField txtFieldTextAssocie;
	private String txtAssocie;
	
	private JLabel labelPathAudio;
	private JTextField txtPathAudio;
	private String pathAudio;
	
	private JLabel labelPathImage;
	private JTextField txtPathImage;
	private String pathImage;

	
	public AjoutArtistTitlePanel(Dimension dim) {
		super(dim);
		// TODO Auto-generated constructor stub
		initPanel();
	}
	

	@Override
	public void update(String nomChanson, String img1Path, String img2Path,
			String img3Path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart(String word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accueil() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String nomChanson, ImageIcon imageIcon,
			ImageIcon imageIcon2, ImageIcon imageIcon3) {
		// TODO Auto-generated method stub
		
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

	@Override
	protected void initPanel() {
		centerContent = new JPanel();
		centerContent.setPreferredSize(new Dimension(600, 500));
		
		JPanel head = new JPanel(); 
		head.setPreferredSize(new Dimension(250, 10)); //largeur x hauteur
		head.setBackground(Color.blue);

		//this.nbArtistes.setText("Nombre d'artistes  trouvés : " + this.model.getPart().getNombreQuest()+ "");
		this.formTitle = new JLabel("Ajouter une entrée");
		this.formTitle.setFont(comics20);
		//this.formTitle.setText("Ajouter une entrée");
		//this.formTitle.setPreferredSize(new Dimension(300, 10));
		//this.formTitle.setHorizontalAlignment(JLabel.CENTER);


		head.add(this.formTitle);
		//head.add(this.formTitle, BorderLayout.NORTH);
		//head.setBackground(Color.white);

		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(500, 400));
		body.setBackground(Color.green);
		//body.setBackground(Color.white);
		GridLayout gridFormulaire = new GridLayout(3,2,5,5);
		body.setLayout(gridFormulaire);

		/*
		 * BoutonListener bl = new BoutonListener(); Dimension buttonDimension =
		 * new Dimension(150,50); this.boutonStart = new JButton("Commencer");
		 * this.boutonStart.addActionListener(bl);
		 * boutonStart.setPreferredSize(buttonDimension); body.add(boutonStart);
		 */
		this.labelThematique = new JLabel("\nChoix de la thématique : ");
		this.labelThematique.setFont(arial);
		String[] tab = {"Musique", "Génériques TV", "Discours", "Publicité"};
		this.chxThematique = new JComboBox(tab);
	    //Ajout du listener
		this.chxThematique.addItemListener(new ItemState());
		this.chxThematique.addActionListener(new ItemAction());
		this.chxThematique.setPreferredSize(new Dimension(100, 20));
		this.chxThematique.setFont(arial);
		this.chxThematique.setForeground(Color.blue);
		
		this.labelNomEntite = new JLabel("\nNom du chanteur : ");
		this.labelNomEntite.setPreferredSize(new Dimension(200, 40)); //Largeur x Hauteur
		this.labelNomEntite.setFont(arial);
		this.labelNomEntite.setVerticalAlignment(JLabel.CENTER);
		
		this.textNomEntite = new JTextField("Nom du chanteur à ajouter");
		this.textNomEntite.setPreferredSize(new Dimension(200, 40));
		this.textNomEntite.setFont(arial);

		
		this.labelTxtAssocie = new JLabel("\nTitre de la chanson : ");
		this.labelTxtAssocie.setPreferredSize(new Dimension(200, 40)); //Largeur x Hauteur
		this.labelTxtAssocie.setFont(arial);
		this.labelTxtAssocie.setVerticalAlignment(JLabel.CENTER);
		
		this.txtFieldTextAssocie = new JTextField("Titre de la chanson à ajouter");
		this.txtFieldTextAssocie.setPreferredSize(new Dimension(200, 40));
		this.txtFieldTextAssocie.setFont(arial);


		body.add(this.labelThematique);
		body.add(this.chxThematique);
		body.add(this.labelNomEntite);
		body.add(this.textNomEntite);
		body.add(this.labelTxtAssocie);
		body.add(this.txtFieldTextAssocie);
		
		final JPanel foot = new JPanel(new BorderLayout());
		foot.setPreferredSize(new Dimension(400, 100));
		foot.setBackground(Color.orange);
		
		//this.ap = new AudioPlayerGUI();
		//this.ap.setPreferredSize(new Dimension(400, 100));
		//foot.add(ap);
		 player = new AudioPlayer();
		 //contentPane = new JPanel(new BorderLayout());
				chooser = new JFileChooser();
				chooser.setFileFilter(new FileNameExtensionFilter("Son", "wav", "mp3"));
				/*
				chooser.setFileFilter(new FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.getName().endsWith(".wav"))
							return true;
						else
							return false;
					}
					@Override
					public String getDescription() {
						return null;
					}
				});*/
		
				foot.setPreferredSize(new Dimension(200, 50));
		
				stop = new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						//Thread.currentThread().interrupt();				
						player.stop();				
					}
				};
				stop.putValue(Action.SMALL_ICON, new ImageIcon("Images/Stop-Button.png"));		
				
				this.nomEntite = "";
				play= new AbstractAction() {
					private File audioFile;
					private Thread audioPlayerThread;

					public void actionPerformed(ActionEvent arg0) {
						//Pour aller chercher automatiquement le son dans le dossier "Wave/"
						//chooser.setSelectedFile(new File("Wave/"+nomArtiste+".wav"));
						//audioFile=chooser.getSelectedFile();
						//player.setFile(audioFile);	
						//player.init();
	                   //title.setText("Fichier en cours de lecture: "+ audioFile.getName());
	                  // foot.paintAll(foot.getGraphics());
							player.init();
							audioPlayerThread = new Thread(player);
							audioPlayerThread.start();
		                  
							player.getLine().addLineListener(new LineListener(){
		
								public void update(LineEvent le) {
									if(le.getType()==LineEvent.Type.STOP){					
										play.setEnabled(true);
										stop.setEnabled(false);																					
									}
									if(le.getType()==LineEvent.Type.START){					
										play.setEnabled(false);
										stop.setEnabled(true);											
									}	
								}			
							});						
					}
				};
				play.putValue(Action.SMALL_ICON, new ImageIcon("Images/Play-Button.png"));		
		
				load = new AbstractAction() {
					private File audioFile;
					private AbstractButton title;

					public void actionPerformed(ActionEvent arg0) {
						int returnVal = chooser.showOpenDialog(foot);
						if (returnVal == JFileChooser.APPROVE_OPTION) {				
							audioFile=chooser.getSelectedFile();
							player.setFile(audioFile);	
		                   player.init();
		                   title.setText("Fichier en cours de lecture: "+ audioFile.getName());
		                   foot.paintAll(foot.getGraphics());							
						}
					}
				};
				load.putValue(Action.SMALL_ICON, new ImageIcon("Images/Load-Button.jpg"));
				//load.putValue(Action.SMALL_ICON, new ImageIcon("Images/load.png"));	
				
				JToolBar toolbar = new JToolBar(null, JToolBar.VERTICAL);
				title=new JLabel("Aucun titre en cours de lecture");
				
				toolbar.setSize(200, 50);
				toolbar.add(load);
				toolbar.add(play);
				toolbar.add(stop);
				
				//title.setText("Fichier en cours de lecture");
				//toolbar.add(title);
				
				toolbar.setBackground(Color.white);
				toolbar.setFloatable(false);
		
				foot.add(toolbar, BorderLayout.NORTH);
				
				centerContent.setBackground(Color.white);
				
				GridLayout formePanPrincipal = new GridLayout(3,1,5,5);
				centerContent.setLayout(formePanPrincipal);
				
				//centerContent.add(head);
				centerContent.add(body);
				centerContent.add(foot);
				centerContent.setBackground(Color.white);
				;
				this.panel.add(centerContent);
				
	}
	
	  class ItemAction implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		      System.out.println("ActionListener : action sur " + chxThematique.getSelectedItem());
		    }              
		  }

	  //Classe interne implémentant l'interface ItemListener
	  class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	      System.out.println("événement déclenché sur : " + e.getItem());
	    }              
	  }	  	
}
