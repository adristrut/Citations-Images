package observer;

public interface Observable{
	//Permet d'ajouter des observateurs (et dc de g�rer une collection d'observateurs) 
	public void addObserver(Observer obs);
	//Permet de notifier (mettre � jour) les observateurs
	public void notifyObserver();
	//Permet de supprimer les observateurs
	public void deleteObserver();
	public void restartObserver();
	//public void scoreObserver();
	public void accueilObserver();
	public void reset();
}
