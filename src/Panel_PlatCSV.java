import java.util.ArrayList;

import javax.swing.*;


public class Panel_PlatCSV extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	public Panel_PlatCSV(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		boutonRetour = new JButton();
		boutonRetour.setName("Plat");
		//boutonRetour.addActionListener(new ActionAnnulerAjout(fenetre, lesPlats, boutonRetour, nbPlat));
		
		String xml = "<HTML>";
		for(Plat plat : lesPlats){
			xml = xml + plat.toCSV() + "<br/>";
		}
		xml = xml + "</HTML>";
		lblXML = new JLabel(xml);
		this.add(lblXML);
	}
}
