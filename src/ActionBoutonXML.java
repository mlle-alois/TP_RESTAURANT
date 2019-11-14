import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ActionBoutonXML implements ActionListener {

	private JMenuBar menu;
	private JFrame fenetre;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton bouton;
	private JLabel lblErreur;
	private ArrayList<Plat> lesPlats;
	private int nbPlat;
	private ArrayList<Commande> lesCommandes;
	private ArrayList<Menu> lesMenus;
	private ArrayList<Boisson> lesBoissons;
	private int nbCommandes;
	private int nbMenus;
	private int nbDesserts;
	private int nbBoissons;
	private ArrayList<Dessert> lesDesserts;

	public ActionBoutonXML(JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
		this.bouton = bouton;
	}
	public ActionBoutonXML(JFrame fenetre, int nb, ArrayList<Menu> lesMenus, JButton bouton){
		this.fenetre = fenetre;
		this.lesMenus = lesMenus;
		this.nbMenus = nb;
		this.bouton = bouton;
	}
	public ActionBoutonXML(JFrame fenetre, ArrayList<Dessert> lesDesserts, JButton bouton, int nb){
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nbDesserts = nb;
		this.bouton = bouton;
	}
	public ActionBoutonXML(ArrayList<Boisson> lesBoissons, JButton bouton, int nb, JFrame fenetre){
		this.fenetre = fenetre;
		this.lesBoissons = lesBoissons;
		this.nbBoissons = nb;
		this.bouton = bouton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(bouton.getName().equals("Plat")){
			this.fenetre.setContentPane(new Panel_PlatXML(fenetre, lesPlats, nbPlat));
			this.fenetre.revalidate();
		}
		else{
			if(bouton.getName().equals("Menu")){
				this.fenetre.setContentPane(new Panel_MenuXML(fenetre, lesMenus, nbMenus));
				this.fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Dessert")){
					this.fenetre.setContentPane(new Panel_DessertXML(fenetre, lesDesserts, nbDesserts));
					this.fenetre.revalidate();
				}
				else{
					if(bouton.getName().equals("Boisson")){
						this.fenetre.setContentPane(new Panel_BoissonXML(fenetre, lesBoissons, nbBoissons));
						this.fenetre.revalidate();
					}
				}
			}
		}

	}

}
