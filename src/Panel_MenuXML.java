import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_MenuXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	/**
	 * Constructeur du panel des menus en XML
	 * @param fenetre
	 * @param lesMenus
	 * @param nbMenus
	 */
	public Panel_MenuXML(JFrame fenetre, ArrayList<Menu> lesMenus, int nbMenus){
		
		this.setLayout(new BorderLayout());

		//définition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Menu");
		boutonRetour.addActionListener(new ActionAnnulerAjout(nbMenus, fenetre, lesMenus, boutonRetour));

		//définition de la chaine XML
		String xml = "";
		for(Menu menu : lesMenus){
			xml = xml + menu.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		
		//ajout des éléments aux panels
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
