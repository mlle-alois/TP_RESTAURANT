import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author azimmermann
 *
 */
public class ActionBoutonCSV implements ActionListener {

	private JFrame fenetre;
	private JButton bouton;
	private ArrayList<Plat> lesPlats;
	private int nbPlat;

	/**
	 * Constructeur pour les plats
	 * @param fenetre
	 * @param lesPlats
	 * @param nb
	 * @param bouton
	 */
	public ActionBoutonCSV(JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
		this.bouton = bouton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//appel du panel
		this.fenetre.setContentPane(new Panel_PlatCSV(fenetre, lesPlats, nbPlat));
		this.fenetre.revalidate();

	}

}
