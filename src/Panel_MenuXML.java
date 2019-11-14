import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_MenuXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	public Panel_MenuXML(JFrame fenetre, ArrayList<Menu> lesMenus, int nbMenus){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Menu");
		boutonRetour.addActionListener(new ActionAnnulerAjout(nbMenus, fenetre, lesMenus, boutonRetour));
		
		String xml = "";
		for(Menu menu : lesMenus){
			xml = xml + menu.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
