import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class ActionAnnulerAjout implements ActionListener{

	private JButton bouton;
	private JFrame fenetre;
	private ArrayList<Plat> lesPlats;
	private ArrayList<Dessert> lesDesserts;
	private ArrayList<Boisson> lesBoissons;
	private ArrayList<Commande> lesCommandes;
	private ArrayList<Menu> lesMenus;
	private int nb;

	/**
	 * Constructeur pour les plats
	 * @param bouton
	 * @param fenetre
	 * @param lesPlats
	 * @param nb
	 */
	public ActionAnnulerAjout(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
	}

	/**
	 * Constructeur pour les desserts
	 * @param bouton
	 * @param lesDesserts
	 * @param nb
	 * @param fenetre
	 */
	public ActionAnnulerAjout(JButton bouton, ArrayList<Dessert> lesDesserts, int nb, JFrame fenetre){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nb = nb;
	}

	/**
	 * Constructeur pour les boissons
	 * @param fenetre
	 * @param bouton
	 * @param lesBoissons
	 * @param nb
	 */
	public ActionAnnulerAjout(JFrame fenetre, JButton bouton, ArrayList<Boisson> lesBoissons, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesBoissons = lesBoissons;
		this.nb = nb;
	}

	/**
	 * Constructeur pour les commandes
	 * @param fenetre
	 * @param lesCommandes
	 * @param bouton
	 * @param nb
	 */
	public ActionAnnulerAjout(JFrame fenetre, ArrayList<Commande> lesCommandes, JButton bouton, int nb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
	}

	/**
	 * Constructeur pour les menus
	 * @param nb
	 * @param fenetre
	 * @param lesMenus
	 * @param bouton
	 */
	public ActionAnnulerAjout(int nb, JFrame fenetre, ArrayList<Menu> lesMenus, JButton bouton){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesMenus = lesMenus;
		this.nb = nb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//génération du panel correspondant au sujet concerné
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
						else{
							if(bouton.getName().equals("Menu")){
								fenetre.setContentPane(new Panel_Menus(nb, lesMenus, fenetre));
								fenetre.revalidate();
							}
						}
					}
				}
			}
		}
	}
}
