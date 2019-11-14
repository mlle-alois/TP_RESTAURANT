import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_PlatCSV extends JPanel {

	private JLabel lblCSV;
	private JButton boutonRetour;
	
	public Panel_PlatCSV(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Plat");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, fenetre, lesPlats, nbPlat));
		
		String xml = "<HTML>";
		for(Plat plat : lesPlats){
			xml = xml + plat.toCSV() + "<br/>";
		}
		xml = xml + "</HTML>";
		lblCSV = new JLabel(xml);
		this.add(lblCSV, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
