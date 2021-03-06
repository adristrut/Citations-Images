package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImageLabel extends JLabel{

	private String imagePath = "Images/visage-inconnu.jpg";
	public ImageLabel(){}
	public ImageLabel(String path){
		this.imagePath = path;
		
		/*
		int width=200, height= 200;
		int[] pixels= new int[width * height] ;
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Image img = tk.createImage((ImageProducer) new MemoryImageSource(width,height,pixels,0,width));
		img = tk.getImage("Images/visage-inconnu.jpg");
		*/
		
	}
	
	public void paint(Graphics g){
			//g.setColor(Color.black);
			//g.drawRect(0, 0, this.getWidth(), this.getHeight());
			g.drawRect(this.CENTER, this.CENTER, 350, 350);
						
			try {
 
				Image img = ImageIO.read(new File(this.imagePath));
				
				g.drawImage(img, 0, 0, this);
				this.setText(this.imagePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void setImagePath(String path){
		this.imagePath = path;
		repaint();
	}

}
