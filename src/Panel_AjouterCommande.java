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
public class Panel_AjouterCommande extends JPanel {

	private JLabel lblErreur, lblNb;
	private JTextField jtfNb;
	private JButton boutonAjouterCommande, boutonAnnulerCommande;
	
	/**
	 * Controleur du panel d'ajout d'une commande
	 * @param lesCommandes
	 * @param fenetre
	 * @param nbCommandes
	 */
	public Panel_AjouterCommande(ArrayList<Commande> lesCommandes, JFrame fenetre, int nbCommandes){
		
		this.setLayout(new GridBagLayout());
		
		//définition des labels
		lblErreur = new JLabel();
		lblNb = new JLabel("Nombre de couverts : ");
		
		//définition de la zone de texte
		jtfNb = new JTextField();
		
		//dimension de la zone de texte
		jtfNb.setPreferredSize(new Dimension(150,30));
		
		//définition des boutons, nommage et ajout de l'action
		boutonAjouterCommande = new JButton("Passer la commande");
		boutonAjouterCommande.setName("Commande");
		this.boutonAjouterCommande.addActionListener(new ActionAjouter(fenetre, boutonAjouterCommande, lesCommandes, nbCommandes, jtfNb, lblErreur, 0));
		
		this.boutonAnnulerCommande = new JButton("Annuler");
		this.boutonAnnulerCommande.setName("Commande");
		this.boutonAnnulerCommande.addActionListener(new ActionAnnulerAjout(fenetre, lesCommandes, boutonAnnulerCommande, nbCommandes));
		
		//ajout des éléments au panel
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lblNb, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(jtfNb, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(boutonAnnulerCommande, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(boutonAjouterCommande, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(lblErreur, c);
		
	}
}
