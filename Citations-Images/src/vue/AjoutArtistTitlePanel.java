package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import observer.Observer;

public class AjoutArtistTitlePanel extends SContainer implements Observer {

	private AudioPlayer player;
	private JFileChooser chooser;
	private AbstractAction stop;
	private String nomArtiste;
	private AbstractAction play;
	private AbstractAction load;
	private JPanel centerContent;
	private JLabel title;

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
		// TODO Auto-generated method stub
		final JPanel foot = new JPanel(new BorderLayout());
		foot.setPreferredSize(new Dimension(400, 100));
//		foot.setBackground(Color.orange);
		
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
				stop.putValue(Action.SMALL_ICON, new ImageIcon("Images/Stop-Button.png"));		
				
				this.nomArtiste = "";
				play= new AbstractAction() {
					private File audioFile;
					private Thread audioPlayerThread;

					public void actionPerformed(ActionEvent arg0) {
						//Pour aller chercher automatiquement le son dans le dossier "Wave/"
						//chooser.setSelectedFile(new File("Wave/"+nomArtiste+".wav"));
						//audioFile=chooser.getSelectedFile();
						//player.setFile(audioFile);	
						//player.init();
	                   title.setText("Fichier en cours de lecture: "+ audioFile.getName());
	                   foot.paintAll(foot.getGraphics());
						//	player.init();
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
		                   //title.setText("Fichier en cours de lecture: "+ audioFile.getName());
		                   foot.paintAll(foot.getGraphics());							
						}
					}
				};
				load.putValue(Action.SMALL_ICON, new ImageIcon("Images/Load-Button.jpg"));
				//load.putValue(Action.SMALL_ICON, new ImageIcon("Images/load.png"));	
				
				JToolBar toolbar = new JToolBar();
				title=new JLabel("Aucun titre en cours de lecture");
				
				toolbar.setSize(200, 50);
				toolbar.add(load);
				toolbar.add(play);
				toolbar.add(stop);
				
				title.setText("Fichier en cours de lecture");
				toolbar.add(title);
				
				toolbar.setBackground(Color.white);
				toolbar.setFloatable(false);
		
				foot.add(toolbar, BorderLayout.NORTH);
		        
				centerContent.add(foot,BorderLayout.SOUTH);
				centerContent.setBackground(Color.white);

				this.panel.add(centerContent);
	}

}
