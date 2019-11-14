import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_DessertJSon extends JPanel {

	private JLabel lblCSV;
	private JButton boutonRetour;
	
	public Panel_DessertJSon(JFrame fenetre, ArrayList<Dessert> lesDesserts, int nbDessert){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Dessert");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, lesDesserts, nbDessert, fenetre));
		
		String xml = "<HTML>";
		for(Dessert dessert : lesDesserts){
			xml = xml + dessert.toJSon() + "<br/>";
		}
		xml = xml + "</HTML>";
		lblCSV = new JLabel(xml);
		this.add(lblCSV, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
