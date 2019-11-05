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
	
	public Fenetre_principale(){
		
		this.setTitle("Restaurant");
		this.setLocation(3, 3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setResizable(false);

		JMenuBar menu= new JMenuBar();

		menuPlat = new JMenu("Plat");
		plat = new JMenuItem("Plat");
	    menuPlat.add(plat);
	    plat.addActionListener(new ActionMenu(plat, dessert, boisson, quitter, this));

	    menuDessert = new JMenu("Dessert");
	    dessert = new JMenuItem("Dessert");
	    menuDessert.add(dessert);
	    dessert.addActionListener(new ActionMenu(plat, dessert, boisson, quitter, this));

	    menuBoisson = new JMenu("Boisson");
	    boisson = new JMenuItem("Boisson");
	    menuBoisson.add(boisson);
	    boisson.addActionListener(new ActionMenu(plat, dessert, boisson, quitter, this));
	    
	    menuQuitter = new JMenu("Quitter");
	    quitter = new JMenuItem("Quitter");
	    menuQuitter.add(quitter);
	    quitter.addActionListener(new ActionMenu(plat, dessert, boisson, quitter, this));

	    menu.add(menuPlat);
	    menu.add(menuDessert);
	    menu.add(menuBoisson);
	    menu.add(menuQuitter);
	    
	    this.setContentPane(new Panel_connexion(menu, this));
	    
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
