import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_RechercherMenu extends JPanel {

	private JLabel lblErreur, lbl, lblNb;
	private JTextField jtf;
	private JButton boutonRechercher, boutonAnnuler;
	
	/**
	 * Constructeur du panel de recherche d'un menu
	 * @param nbMenus
	 * @param lesMenus
	 * @param fenetre
	 * @param nbMenuJour
	 */
	public Panel_RechercherMenu(int nbMenus, ArrayList<Menu> lesMenus, JFrame fenetre, int nbMenuJour){

		this.setLayout(new GridBagLayout());
		
		//définition des labels
		lblErreur = new JLabel();
		String n = Integer.toString(nbMenuJour);
		lblNb = new JLabel(n);
		lbl = new JLabel("Menus du jour (aaaa-mm-jj) : ");
		
		//définition de la zone de texte
		jtf = new JTextField();
		
		//dimension de la zone de texte
		jtf.setPreferredSize(new Dimension(150,30));
		
		//définition, nommage et action des boutons
		boutonRechercher = new JButton("Rechercher");
		boutonRechercher.setName("Menu");
		this.boutonRechercher.addActionListener(new ActionRechercher(boutonRechercher, fenetre, lesMenus, nbMenus, jtf, lblErreur, lblNb));
		
		this.boutonAnnuler = new JButton("Annuler");
		this.boutonAnnuler.setName("Menu");
		this.boutonAnnuler.addActionListener(new ActionAnnulerAjout(nbMenus, fenetre, lesMenus, boutonAnnuler));
		
		
		//ajout des éléments au panel
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(lbl, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(jtf, c);
		c.gridx = 2;
		c.gridy = 0;
		if(nbMenuJour >= 0){
			this.add(lblNb, c);
		}
		c.gridx = 0;
		c.gridy = 1;
		this.add(boutonAnnuler, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(boutonRechercher, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(lblErreur, c);
	}
}
