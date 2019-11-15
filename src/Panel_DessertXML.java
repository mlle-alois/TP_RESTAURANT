import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_DessertXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	/**
	 * Constructeur du panel des desserts en XML
	 * @param fenetre
	 * @param lesDesserts
	 * @param nbDessert
	 */
	public Panel_DessertXML(JFrame fenetre, ArrayList<Dessert> lesDesserts, int nbDessert){
		
		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Dessert");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, lesDesserts, nbDessert, fenetre));

		//création de la chaine d'XML
		String xml = "";
		for(Dessert dessert : lesDesserts){
			xml = xml + dessert.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		
		//ajout des éléments au panel
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
