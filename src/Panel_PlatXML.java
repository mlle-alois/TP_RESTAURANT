import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_PlatXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	/**
	 * Constructeur du panel de plats en XML
	 * @param fenetre
	 * @param lesPlats
	 * @param nbPlat
	 */
	public Panel_PlatXML(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Plat");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, fenetre, lesPlats, nbPlat));

		//définition de la chaine XML
		String xml = "";
		for(Plat plat : lesPlats){
			xml = xml + plat.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		
		//ajout des éléments au panel
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
