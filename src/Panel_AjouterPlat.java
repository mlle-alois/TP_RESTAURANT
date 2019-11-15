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
public class Panel_AjouterPlat extends JPanel{
	
	private JLabel lblErreur, lblNom, lblPrix;
	private JTextField jtfNom, jtfPrix;
	private JButton boutonAjouterPlat, boutonAnnulerPlat;

	/**
	 * Constructeur du panel d'ajout d'un plat
	 * @param fenetre
	 * @param lesPlats
	 * @param nbPlat
	 */
	public Panel_AjouterPlat(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new GridBagLayout());
		
		//définition des labels
		lblErreur = new JLabel();
		lblNom = new JLabel("Nom du plat : ");
		lblPrix = new JLabel("Prix du plat (€) : ");
		
		//définition des zones de texte
		jtfNom = new JTextField();
		jtfPrix = new JTextField();
		
		//dimension des zones de texte
		jtfNom.setPreferredSize(new Dimension(150,30));
		jtfPrix.setPreferredSize(new Dimension(150,30));
		
		//définition, nommage et action des boutons
		boutonAjouterPlat = new JButton("Ajouter");
		boutonAjouterPlat.setName("Plat");
		this.boutonAjouterPlat.addActionListener(new ActionAjouter(boutonAjouterPlat, fenetre, lesPlats, nbPlat, jtfNom, jtfPrix, lblErreur));
		
		this.boutonAnnulerPlat = new JButton("Annuler");
		this.boutonAnnulerPlat.setName("Plat");
		this.boutonAnnulerPlat.addActionListener(new ActionAnnulerAjout(boutonAnnulerPlat, fenetre, lesPlats, nbPlat));
		
		//ajout des éléments au panel
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lblNom, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(jtfNom, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(lblPrix, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(jtfPrix, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(boutonAnnulerPlat, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(boutonAjouterPlat, c);
		c.gridx = 1;
		c.gridy = 3;
		this.add(lblErreur, c);
	}
	
}
