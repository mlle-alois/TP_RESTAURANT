import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel_AjouterCommande2 extends JPanel {

	private JLabel lblErreur, lblNb;
	private JTextField jtfNb;
	private JButton boutonAjouterCommande, boutonAnnulerCommande;
	
	public Panel_AjouterCommande2(ArrayList<Commande> lesCommandes, JFrame fenetre, int nbCommandes, int nbCouverts, int i){
		
		this.setLayout(new GridBagLayout());
		
		lblErreur = new JLabel();
		lblNb = new JLabel("Couvert N°" + (i + 1));
		
		jtfNb = new JTextField();
		
		jtfNb.setPreferredSize(new Dimension(150,30));
		
		boutonAjouterCommande = new JButton("Passer la commande");
		boutonAjouterCommande.setName("Commande");
		this.boutonAjouterCommande.addActionListener(new ActionAjouter(fenetre, boutonAjouterCommande, lesCommandes, nbCommandes, jtfNb, lblErreur, i+1));
		
		this.boutonAnnulerCommande = new JButton("Annuler");
		this.boutonAnnulerCommande.setName("Commande2");
		this.boutonAnnulerCommande.addActionListener(new ActionAnnulerAjout(fenetre, lesCommandes, boutonAnnulerCommande, nbCommandes));
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lblNb, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(jtfNb, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(boutonAnnulerCommande, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(boutonAjouterCommande, c);
		c.gridx = 2;
		c.gridy = 3;
		this.add(lblErreur, c);
		
	}

}
