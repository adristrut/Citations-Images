package observer;

import javax.swing.ImageIcon;


public interface Observer{
	public void update(String nomChanson, String img1Path, String img2Path, String img3Path);
	//public void update(String mot, int pts, String imgPath, int nbreMot);
	public void restart(String word);
	public void accueil();
	public void update(String nomChanson, ImageIcon imageIcon, ImageIcon imageIcon2, ImageIcon imageIcon3);
	void update(String nomChanson, String img1Path, String img2Path, String img3Path, int pts, int nbArtist);
}
