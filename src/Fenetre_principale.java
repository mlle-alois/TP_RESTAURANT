import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * 
 * @author azimmermann
 *
 */
//Fenetre = controleur principal
public class Fenetre_principale extends JFrame implements ActionListener{
	
	private JMenu menuPlat;
	private JMenuItem plat;
	private JMenu menuDessert;
	private JMenuItem dessert;
	private JMenu menuBoisson;
	private JMenuItem boisson;
	private JMenu menuQuitter;
	private JMenuItem quitter;
	private JMenu menuMenu;
	private JMenuItem menus;
	private JMenu menuCommande;
	private JMenuItem commande;
	
	/**
	 * Contenu de la fenetre principale
	 */
	public Fenetre_principale(){
		
		//titre de la fenetre
		this.setTitle("Restaurant");
		//positionnement de la fenetre dans le coin en haut à gauche
		this.setLocation(3, 3);
		//finir le programme à la fermeture de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//taille de la fenetre
		this.setSize(500, 500);
		//fenetre non redimentionnable
		this.setResizable(false);

		//création du menu
		JMenuBar menu= new JMenuBar();

		//ajout du menu des plats
		menuPlat = new JMenu("Plats");
		plat = new JMenuItem("Plats");
	    menuPlat.add(plat);
	    plat.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

		//ajout du menu des desserts
	    menuDessert = new JMenu("Desserts");
	    dessert = new JMenuItem("Desserts");
	    menuDessert.add(dessert);
	    dessert.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

		//ajout du menu des boissons
	    menuBoisson = new JMenu("Boissons");
	    boisson = new JMenuItem("Boissons");
	    menuBoisson.add(boisson);
	    boisson.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

		//ajout du menu des menus
	    menuMenu = new JMenu("Menus");
	    menus = new JMenuItem("Menus");
	    menuMenu.add(menus);
	    menus.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

		//ajout du menu des commandes
	    menuCommande = new JMenu("Commandes");
	    commande = new JMenuItem("Commandes");
	    menuCommande.add(commande);
	    commande.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

		//ajout du menu quitter
	    menuQuitter = new JMenu("Quitter");
	    quitter = new JMenuItem("Quitter");
	    menuQuitter.add(quitter);
	    quitter.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

	    //ajout des différents menus au menu général
	    menu.add(menuPlat);
	    menu.add(menuDessert);
	    menu.add(menuBoisson);
	    menu.add(menuMenu);
	    menu.add(menuCommande);
	    menu.add(menuQuitter);
	    
	    this.setContentPane(new Panel_connexion(menu, this));
	    
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
