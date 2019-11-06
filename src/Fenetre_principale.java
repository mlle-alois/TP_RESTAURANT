import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	
	public Fenetre_principale(){
		
		this.setTitle("Restaurant");
		this.setLocation(3, 3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);

		JMenuBar menu= new JMenuBar();

		menuPlat = new JMenu("Plats");
		plat = new JMenuItem("Plats");
	    menuPlat.add(plat);
	    plat.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

	    menuDessert = new JMenu("Desserts");
	    dessert = new JMenuItem("Desserts");
	    menuDessert.add(dessert);
	    dessert.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

	    menuBoisson = new JMenu("Boissons");
	    boisson = new JMenuItem("Boissons");
	    menuBoisson.add(boisson);
	    boisson.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

	    menuMenu = new JMenu("Menus");
	    menus = new JMenuItem("Menus");
	    menuMenu.add(menus);
	    menus.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

	    menuCommande = new JMenu("Commandes");
	    commande = new JMenuItem("Commandes");
	    menuCommande.add(commande);
	    commande.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));
	    
	    menuQuitter = new JMenu("Quitter");
	    quitter = new JMenuItem("Quitter");
	    menuQuitter.add(quitter);
	    quitter.addActionListener(new ActionMenu(plat, dessert, boisson, menus, commande, quitter, this));

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
