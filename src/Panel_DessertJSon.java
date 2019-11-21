import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_DessertJSon extends JPanel {

	private JLabel lblCSV;
	private JButton boutonRetour;
	
	/**
	 * Constructeur du panel des desserts en JSon
	 * @param fenetre
	 * @param lesDesserts
	 * @param nbDessert
	 */
	public Panel_DessertJSon(JFrame fenetre, ArrayList<Dessert> lesDesserts, int nbDessert){
		
		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Dessert");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, lesDesserts, nbDessert, fenetre));
		
		//définition de la chaine XML
		String xml = "<HTML>";
		for(Dessert dessert : lesDesserts){
			xml = xml + dessert.toJSon() + "<br/>";
		}
		xml = xml + "</HTML>";
		lblCSV = new JLabel(xml);
		
		//ajout des éléments au panel
		this.add(lblCSV, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
