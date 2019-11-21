import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_AjouterCommande2 extends JPanel {

	private JLabel lblErreur, lblNum, lblPlat, lblDessert, lblBoisson;
	private JComboBox plat, dessert, boisson;
	private JButton boutonAjouterCommande, boutonAnnulerCommande;
	
	/**
	 * Constructeur du panel de l'ajout de commande à l'étape 2
	 * @param lesCommandes
	 * @param fenetre
	 * @param nbCommandes
	 * @param nbCouverts
	 * @param i
	 * @param lesPlats
	 * @param lesDesserts
	 * @param lesBoissons
	 * @param idCommande
	 */
	public Panel_AjouterCommande2(ArrayList<Commande> lesCommandes, JFrame fenetre, int nbCommandes, int nbCouverts, int i, ArrayList<Plat> lesPlats, ArrayList<Dessert> lesDesserts, ArrayList<Boisson> lesBoissons, int idCommande){
		
		//mise en place du layout
		this.setLayout(new GridBagLayout());
		
		//définition des labels
		lblErreur = new JLabel();
		lblNum = new JLabel("Couvert N°" + (i + 1));
		lblPlat = new JLabel("Plat : ");
		lblDessert = new JLabel("Dessert : ");
		lblBoisson = new JLabel("Boisson : ");
		
		//définition des listes déroulantes
		plat = new JComboBox();
		dessert = new JComboBox();
		boisson = new JComboBox();
		
		//ajout des éléments aux listes déroulantes depuis les listes d'élements
		for(Plat unPlat : lesPlats) {
			plat.addItem(unPlat.getIdPlat() + ". " + unPlat.getNomP() + " " + unPlat.getPrixP() + "€");
		}
		for(Dessert unDessert : lesDesserts) {
			dessert.addItem(unDessert.getIdDessert() + ". " + unDessert.getNomD() + " " + unDessert.getPrixD() + "€");
		}
		for(Boisson uneBoisson : lesBoissons) {
			String type;
			if(uneBoisson instanceof Soft) {
				type = "Soft";
			}
			else {
				type = "Alcool";
			}
			boisson.addItem(type + " : " + uneBoisson.getIdBoisson() + ". " + uneBoisson.getNomB() + " " + uneBoisson.getPrixB() + "€");
		}
		
		//définiton, nommage et action des boutons
		boutonAjouterCommande = new JButton("Passer la commande");
		boutonAjouterCommande.setName("Commande2");
		this.boutonAjouterCommande.addActionListener(new ActionAjouter(fenetre, boutonAjouterCommande, lesCommandes, nbCommandes, nbCouverts, lblErreur, plat, dessert, boisson, i+1, idCommande));
		
		//possibilité d'annuler la commande seulement tant qu'aucun menu n'a été saisi
		if(i == 0) {
			this.boutonAnnulerCommande = new JButton("Annuler");
			this.boutonAnnulerCommande.setName("Commande2");
			this.boutonAnnulerCommande.addActionListener(new ActionAnnulerAjout(fenetre, lesCommandes, boutonAnnulerCommande, nbCommandes));
		}
		
		//ajout des éléments au panel
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
