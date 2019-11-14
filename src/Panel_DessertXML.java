import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_DessertXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	public Panel_DessertXML(JFrame fenetre, ArrayList<Dessert> lesDesserts, int nbDessert){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Dessert");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, lesDesserts, nbDessert, fenetre));
		
		String xml = "";
		for(Dessert dessert : lesDesserts){
			xml = xml + dessert.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
