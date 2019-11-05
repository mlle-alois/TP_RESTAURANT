import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionMenu implements ActionListener{

	private JMenuItem plat;
	private JMenuItem dessert;
	private JMenuItem boisson;
	private JMenuItem quitter;
	private JFrame fenetre;
	
	public ActionMenu(JMenuItem plat, JMenuItem dessert, JMenuItem boisson, JMenuItem quitter, JFrame fenetre) {
		this.plat = plat;
		this.dessert = dessert;
		this.boisson = boisson;
		this.quitter = quitter;
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == plat){
			int nbPlats = Modele.getNbPlats();
			ArrayList<Plat> lesPlats = Modele.getLesPlats();
			fenetre.setContentPane(new Panel_Plat(nbPlats, lesPlats));
			fenetre.revalidate();
		}
		else{
			if(e.getSource() == dessert){
				int nbDesserts = Modele.getNbDesserts();
				ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
				fenetre.setContentPane(new Panel_Dessert(nbDesserts, lesDesserts));
				fenetre.revalidate();
			}
			else{
				if(e.getSource() == boisson){
					int nbBoissons = Modele.getNbBoissons();
					ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
					fenetre.setContentPane(new Panel_Boisson(nbBoissons, lesBoissons));
					fenetre.revalidate();
				}
				else{
					if(e.getSource() == quitter){
						Modele.deconnexion();
						System.exit(0);
					}
				}
			}
		}
	}

}
