package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import controler.Controler;
import controler.ImageListener;
import model.Model;

import observer.Observable;
import observer.Observer;

public class GamePanel extends SContainer implements Observer {

	private Dimension dimension = new Dimension();
	/*
	 * private int pts = 0; private ImageIcon img[]; private String mot; private
	 * JLabel nombreArt, score, motSecret; private JButton bouton[];
	 */
	private String mot;
	private JLabel nbArtistes, score, titreChanson, labelTitreChanson;
	private ImageLabel imageLabel1;
	private ImageLabel imageLabel2;
	private ImageLabel imageLabel3;
	private JButton boutonStart;
	

	private Controler controler;
	private Model model;
	private int ordreAffichage;

	//private AudioPlayerGUI ap;
    private Thread audioPlayerThread;		
	private AudioPlayer player;
	private Action load;
	private Action play;	
	private Action stop;	
	private JFrame frame;	
	private JPanel contentPane;	
	private JFileChooser chooser;	
	private File audioFile;	
    private JLabel title;	

	
	public GamePanel(Dimension dim, Model mod) {
		super(dim);
		this.model = mod;
		// this.controler = new Controler(mod, this);
		// initPanel();
		initPanel(this.model);
	}

	protected void initPanel(Model mod) {
		this.model = mod;
		System.out
				.println("Je suis dans le GamePanel et la rep � la question est : "
						+ this.model.getQuest().getArtistQuest()[0]);
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		JPanel centerContent = new JPanel();
		// System.out.println("Size : " + this.dimension.getWidth());
		// Dimension dim = new Dimension((int)(this.dimension.getWidth()/2),
		// (int)this.dimension.getHeight());

		JPanel head = new JPanel();

		this.imageLabel1 = new ImageLabel();
		this.imageLabel1.setPreferredSize(new Dimension(150, 150));
		this.imageLabel1.setHorizontalAlignment(JLabel.CENTER);
		// this.imageLabel1.setVerticalAlignment(JLabel.CENTER);

		this.imageLabel2 = new ImageLabel();
		this.imageLabel2.setPreferredSize(new Dimension(150, 150));
		this.imageLabel2.setHorizontalAlignment(JLabel.CENTER);
		// this.imageLabel2.setVerticalAlignment(JLabel.CENTER);

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
		if (ordreAffichage == 1) {
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
		} else if (ordreAffichage == 2) {
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
		} else {
			centerContent.add(this.imageLabel3, BorderLayout.CENTER);
			centerContent.add(this.imageLabel2, BorderLayout.CENTER);
			centerContent.add(this.imageLabel1, BorderLayout.CENTER);
		}
		centerContent.setBackground(Color.black);

		leftContent.setPreferredSize(this.dimension);

		Dimension dim = new Dimension(410, 200);
		head.setPreferredSize(new Dimension(410, 100));

		//this.nbArtistes.setText("Nombre d'artistes  trouv�s : " + this.model.getPart().getNombreQuest()+ "");
		this.nbArtistes.setText("Question n�1");
		this.nbArtistes.setPreferredSize(new Dimension(300, 20));
		this.nbArtistes.setHorizontalAlignment(JLabel.CENTER);
		this.nbArtistes.setFont(arial);

		head.add(this.nbArtistes, BorderLayout.NORTH);

		//this.score.setText("Votre score actuel est de "+ this.model.getPart().getPoint() + " point"+ ((this.model.getPart().getPoint()) > 1 ? "s" : "") + ".");
		this.score.setText("Votre score actuel est de 0 point.");
		this.score.setPreferredSize(new Dimension(300, 20));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		this.score.setFont(arial);
		head.add(this.score, BorderLayout.SOUTH);
		head.setBackground(Color.green);

		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(400, 90));
		body.setBackground(Color.red);
		/*
		 * BoutonListener bl = new BoutonListener(); Dimension buttonDimension =
		 * new Dimension(150,50); this.boutonStart = new JButton("Commencer");
		 * this.boutonStart.addActionListener(bl);
		 * boutonStart.setPreferredSize(buttonDimension); body.add(boutonStart);
		 */
		this.labelTitreChanson = new JLabel("\nTitre de la chanson : ");
		this.labelTitreChanson.setPreferredSize(new Dimension(400, 30)); //Largeur x Hauteur
		this.labelTitreChanson.setHorizontalAlignment(JLabel.CENTER);
		this.titreChanson = new JLabel("Titre de la chanson : ");
		this.titreChanson.setPreferredSize(new Dimension(400, 40));
		this.titreChanson.setForeground(Color.blue);
		this.titreChanson.setFont(comics30);
		this.titreChanson.setHorizontalAlignment(JLabel.CENTER);
		body.add(this.labelTitreChanson);
		body.add(this.titreChanson);

		final JPanel foot = new JPanel(new BorderLayout());
		foot.setPreferredSize(new Dimension(400, 120));
		foot.setBackground(Color.pink);
		//this.ap = new AudioPlayerGUI();
		//this.ap.setPreferredSize(new Dimension(400, 100));
		//foot.add(ap);
		 player = new AudioPlayer();
		 //contentPane = new JPanel(new BorderLayout());
				chooser = new JFileChooser();
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
				});
		
				foot.setPreferredSize(new Dimension(200, 50));
		
				stop = new AbstractAction() {
		
					public void actionPerformed(ActionEvent arg0) {
						//Thread.currentThread().interrupt();				
						player.stop();				
					}
				};
				stop.putValue(Action.SMALL_ICON, new ImageIcon("Images/stop.png"));		
				
				
				play= new AbstractAction() {
		
					public void actionPerformed(ActionEvent arg0) {
						
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

				play.putValue(Action.SMALL_ICON, new ImageIcon("Images/play.png"));		
		
				load = new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						int returnVal = chooser.showOpenDialog(frame);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							
							audioFile=chooser.getSelectedFile();
							player.setFile(audioFile);	
		                   player.init();
		                   title.setText("Fichier en cours de lecture: "+ audioFile.getName());
		                   foot.paintAll(foot.getGraphics());
							
						}
					}
				};
				load.putValue(Action.SMALL_ICON, new ImageIcon("Images/load.png"));
				
				JToolBar toolbar = new JToolBar();
				toolbar.add(load);
				toolbar.add(play);
				toolbar.add(stop);
		
				foot.add(toolbar, BorderLayout.NORTH);
		       title=new JLabel("Aucun titre en cours de lecture");
		       foot.add(title,BorderLayout.CENTER);
				//frame.setContentPane(contentPane);
				//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//frame.pack();



		
		ImageListener il = new ImageListener(this, this.model);
		imageLabel1.addMouseListener(il);
		imageLabel2.addMouseListener(il);
		imageLabel3.addMouseListener(il);

		/*
		 * this.bouton = new JButton[26]; int i = 0; for(char c : carac){
		 * this.bouton[i] = new JButton(String.valueOf(c).toUpperCase());
		 * bouton[i].addActionListener(bl);
		 * bouton[i].setPreferredSize(buttonDimension); body.add(bouton[i]);
		 * i++; }
		 */

		leftContent.add(head, BorderLayout.NORTH);
		leftContent.add(body, BorderLayout.WEST);
		leftContent.add(foot,BorderLayout.SOUTH);
		leftContent.setBackground(Color.blue);

		this.panel.add(leftContent);
		//this.panel.add(rightContent);
		this.panel.add(centerContent);
	}

	public void start() {
		// Pour que les boutons puissent �tre s�lectionnable quand on recommence
		// la partie
		// for(JButton bout : this.bouton)
		// bout.setEnabled(true);
		this.imageLabel1.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel2.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel3.setImagePath("Images/visage-inconnu.jpg");
		this.titreChanson.setText("");
	}

	public void restart(String word) {
		// Pour que les boutons puissent �tre s�lectionnable quand on recommence
		// la partie
		// for(JButton bout : this.bouton)
		// bout.setEnabled(true);
		this.imageLabel1.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel2.setImagePath("Images/visage-inconnu.jpg");
		this.imageLabel3.setImagePath("Images/visage-inconnu.jpg");
		this.titreChanson.setText(word);
	}

	@Override
	public void update(String nomChanson, String img1Path, String img2Path,
			String img3Path, int pts, int nbArtist) {
		this.titreChanson.setText(nomChanson);
		this.imageLabel1.setImagePath(img1Path);
		this.imageLabel2.setImagePath(img2Path);
		this.imageLabel3.setImagePath(img3Path);
		this.score.setText("Votre score actuel est de " +pts+" point"+((pts > 1) ? "s" : "")+".");
		this.nbArtistes.setText("Question n�" +nbArtist);
	}

	@Override
	public void accueil() {
		// TODO Auto-generated method stub

	}

	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((JButton) e.getSource()).setEnabled(false);
			// controler.control(((JButton)e.getSource()).getText());
			// model = new Model();
			// model.startModel();
		}
	}

	@Override
	public void update(String nomChanson, ImageIcon imageIcon,
			ImageIcon imageIcon2, ImageIcon imageIcon3) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String nomChanson, String img1Path, String img2Path,
			String img3Path) {
		// TODO Auto-generated method stub
		
	}
}

