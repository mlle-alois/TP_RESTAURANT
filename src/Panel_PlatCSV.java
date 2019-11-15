import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class Panel_PlatCSV extends JPanel {

	private JLabel lblCSV;
	private JButton boutonRetour;
	 /**
	  * Constructeur du panel de plats en CSV
	  * @param fenetre
	  * @param lesPlats
	  * @param nbPlat
	  */
	public Panel_PlatCSV(JFrame fenetre, ArrayList<Plat> lesPlats, int nbPlat){
		
		this.setLayout(new BorderLayout());

		//d�finition, nommage et action des boutons
		boutonRetour = new JButton("Retour");
		boutonRetour.setName("Plat");
		boutonRetour.addActionListener(new ActionAnnulerAjout(boutonRetour, fenetre, lesPlats, nbPlat));

		//d�finition de la chaine CSV
		String xml = "<HTML>";
		for(Plat plat : lesPlats){
			xml = xml + plat.toCSV() + "<br/><br/>";
		}
		xml = xml + "</HTML>";
		lblCSV = new JLabel(xml);
		
		//ajout des �lements au panel
		this.add(lblCSV, BorderLayout.NORTH);
		this.add(boutonRetour, BorderLayout.SOUTH);
	}
}
