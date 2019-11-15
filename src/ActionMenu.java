import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class ActionMenu implements ActionListener{

	private JMenuItem plat;
	private JMenuItem dessert;
	private JMenuItem boisson;
	private JMenuItem menu;
	private JMenuItem commande;
	private JMenuItem quitter;
	private JFrame fenetre;
	
	/**
	 * Constructeur pour récupérer les items
	 * @param plat
	 * @param dessert
	 * @param boisson
	 * @param menu
	 * @param commande
	 * @param quitter
	 * @param fenetre
	 */
	public ActionMenu(JMenuItem plat, JMenuItem dessert, JMenuItem boisson, JMenuItem menu, JMenuItem commande, JMenuItem quitter, JFrame fenetre) {
		this.plat = plat;
		this.dessert = dessert;
		this.boisson = boisson;
		this.menu = menu;
		this.commande = commande;
		this.quitter = quitter;
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//récupération de la bonne liste et affichage du panel en fonction du sujet concerné
		if(e.getSource() == plat){
			int nbPlats = Modele.getNbPlats();
			ArrayList<Plat> lesPlats = Modele.getLesPlats();
			fenetre.setContentPane(new Panel_Plat(nbPlats, lesPlats, fenetre));
			fenetre.revalidate();
		}
		else{
			if(e.getSource() == dessert){
				int nbDesserts = Modele.getNbDesserts();
				ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
				fenetre.setContentPane(new Panel_Dessert(nbDesserts, lesDesserts, fenetre));
				fenetre.revalidate();
			}
			else{
				if(e.getSource() == boisson){
					int nbBoissons = Modele.getNbBoissons();
					ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
					fenetre.setContentPane(new Panel_Boisson(nbBoissons, lesBoissons, fenetre));
					fenetre.revalidate();
				}
				else{
					if(e.getSource() == menu){
						int nbMenus = Modele.getNbMenus();
						ArrayList<Menu> lesMenus = Modele.getLesMenus();
						fenetre.setContentPane(new Panel_Menus(nbMenus, lesMenus, fenetre));
						fenetre.revalidate();
					}
					else{
						if(e.getSource() == commande){
							int nbCommandes = Modele.getNbCommandes();
							ArrayList<Commande> lesCommandes = Modele.getLesCommandes();
							fenetre.setContentPane(new Panel_Commandes(fenetre, lesCommandes, nbCommandes));
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
	}

}
