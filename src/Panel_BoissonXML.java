import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_BoissonXML extends JPanel {

	private JLabel lblXML;
	private JButton boutonRetour;
	
	/**
	 * Constructeur du panel des boissons en XML
	 * @param fenetre
	 * @param lesBoissons
	 * @param nbBoisson
	 */
	public Panel_BoissonXML(JFrame fenetre, ArrayList<Boisson> lesBoissons, int nbBoisson){
		
		this.setLayout(new BorderLayout());

		//d�finition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Boisson");
		boutonRetour.addActionListener(new ActionAnnulerAjout(fenetre, boutonRetour, lesBoissons, nbBoisson));
		
		//cr�ation de la chaine d'XML
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
		
		//ajout des �l�ments au panel
		this.add(lblXML, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
