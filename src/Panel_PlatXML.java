import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_PlatXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	public Panel_PlatXML(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Plat");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, fenetre, lesPlats, nbPlat));
		
		String xml = "";
		for(Plat plat : lesPlats){
			xml = xml + plat.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
