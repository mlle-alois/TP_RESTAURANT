import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionAnnulerAjout implements ActionListener{

	private JButton bouton;
	private JFrame fenetre;
	private ArrayList<Plat> lesPlats;
	private ArrayList<Dessert> lesDesserts;
	private ArrayList<Boisson> lesBoissons;
	private ArrayList<Commande> lesCommandes;
	private int nb;

	public ActionAnnulerAjout(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
	}

	public ActionAnnulerAjout(JButton bouton, ArrayList<Dessert> lesDesserts, int nb, JFrame fenetre){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nb = nb;
	}

	public ActionAnnulerAjout(JFrame fenetre, JButton bouton, ArrayList<Boisson> lesBoissons, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesBoissons = lesBoissons;
		this.nb = nb;
	}

	public ActionAnnulerAjout(JFrame fenetre, ArrayList<Commande> lesCommandes, JButton bouton, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(bouton.getName().equals("Plat")){
			fenetre.setContentPane(new Panel_Plat(nb, lesPlats, fenetre));
			fenetre.revalidate();
		}
		else{
			if(bouton.getName().equals("Dessert")){
				fenetre.setContentPane(new Panel_Dessert(nb, lesDesserts, fenetre));
				fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Boisson")){
					fenetre.setContentPane(new Panel_Boisson(nb, lesBoissons, fenetre));
					fenetre.revalidate();
				}
				else{
					if(bouton.getName().equals("Commande")){
						fenetre.setContentPane(new Panel_Commandes(fenetre, lesCommandes, nb));
						fenetre.revalidate();
					}
					else{
						if(bouton.getName().equals("Commande2")){
							fenetre.setContentPane(new Panel_AjouterCommande(lesCommandes, fenetre, nb));
							fenetre.revalidate();
						}
					}
				}
			}
		}
	}
}
