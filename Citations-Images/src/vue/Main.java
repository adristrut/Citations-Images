package vue;

import model.Model;
import observer.Observable;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable model = new Model();
		Fenetre fen = new Fenetre(model);
		fen.setVisible(true);
	}
}

