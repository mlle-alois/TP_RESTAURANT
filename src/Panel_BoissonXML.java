import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Panel_BoissonXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	public Panel_BoissonXML(JFrame fenetre, ArrayList<Boisson> lesBoissons, int nbBoisson){
		
		this.setLayout(new BorderLayout());
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Boisson");
		boutonRetour.addActionListener(new ActionAnnulerAjout(fenetre, boutonRetour, lesBoissons, nbBoisson));
		
		String xml = "";
		Soft s;
		Alcool a;
		for(Boisson boisson : lesBoissons){
			if(boisson instanceof Soft){
				s = (Soft) boisson;
				xml = xml + s.toXML();
			}
			else{
				a = (Alcool) boisson;
				xml = xml + a.toXML();
			}
		}
		xml = xml + "";
		lblXML = new JLabel(xml);
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
