import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_AjouterCommande2 extends JPanel {

	private JLabel lblErreur, lblNum, lblPlat, lblDessert, lblBoisson;
	private JComboBox plat, dessert, boisson;
	private JButton boutonAjouterCommande, boutonAnnulerCommande;
	
	public Panel_AjouterCommande2(ArrayList<Commande> lesCommandes, JFrame fenetre, int nbCommandes, int nbCouverts, int i, ArrayList<Plat> lesPlats, ArrayList<Dessert> lesDesserts, ArrayList<Boisson> lesBoissons){
		
		this.setLayout(new GridBagLayout());
		
		lblErreur = new JLabel();
		lblNum = new JLabel("Couvert N°" + (i + 1));
		lblPlat = new JLabel("Plat : ");
		lblDessert = new JLabel("Dessert : ");
		lblBoisson = new JLabel("Boisson : ");
		
		plat = new JComboBox();
		dessert = new JComboBox();
		boisson = new JComboBox();
		
		for(Plat unPlat : lesPlats) {
			plat.addItem(unPlat.getIdPlat() + ". " + unPlat.getNomP() + " " + unPlat.getPrixP() + "€");
		}
		for(Dessert unDessert : lesDesserts) {
			plat.addItem(unDessert.getIdDessert() + ". " + unDessert.getNomD() + " " + unDessert.getPrixD() + "€");
		}
		for(Boisson uneBoisson : lesBoissons) {
			String type;
			if(uneBoisson instanceof Soft) {
				type = "Soft";
			}
			else {
				type = "Alcool";
			}
			plat.addItem(uneBoisson.getIdBoisson() + ". " + type + " : " + uneBoisson.getNomB() + " " + uneBoisson.getPrixB() + "€");
		}
		
		boutonAjouterCommande = new JButton("Passer la commande");
		boutonAjouterCommande.setName("Commande");
		this.boutonAjouterCommande.addActionListener(new ActionAjouter(fenetre, boutonAjouterCommande, lesCommandes, nbCommandes, lblErreur, plat, dessert, boisson, i+1));
		
		if(i == 0) {
			this.boutonAnnulerCommande = new JButton("Annuler");
			this.boutonAnnulerCommande.setName("Commande2");
			this.boutonAnnulerCommande.addActionListener(new ActionAnnulerAjout(fenetre, lesCommandes, boutonAnnulerCommande, nbCommandes));
		}
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lblNum, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(lblPlat, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(plat, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(lblDessert, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(dessert, c);
		c.gridx = 0;
		c.gridy = 3;
		this.add(lblBoisson, c);
		c.gridx = 1;
		c.gridy = 3;
		this.add(boisson, c);
		if(i == 0) {
			c.gridx = 0;
			c.gridy = 4;
			this.add(boutonAnnulerCommande, c);
		}
		c.gridx = 1;
		c.gridy = 4;
		this.add(boutonAjouterCommande, c);
		c.gridx = 2;
		c.gridy = 5;
		this.add(lblErreur, c);
		
	}

}
