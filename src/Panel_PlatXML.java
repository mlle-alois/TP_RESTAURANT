import java.util.ArrayList;

import javax.swing.*;


public class Panel_PlatXML extends JPanel {

	private JLabel lblXML;
	
	public Panel_PlatXML(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		String xml = "";
		for(Plat plat : lesPlats){
			xml = xml + plat.toXML();
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		this.add(lblXML);
	}
}
