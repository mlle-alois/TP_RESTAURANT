import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionBoutonJSon implements ActionListener {

	private JFrame fenetre;
	private JButton bouton;
	private ArrayList<Dessert> lesDesserts;
	private int nbDessert;

	public ActionBoutonJSon(JFrame fenetre, ArrayList<Dessert> lesDesserts, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nbDessert = nb;
		this.bouton = bouton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.fenetre.setContentPane(new Panel_DessertJSon(fenetre, lesDesserts, nbDessert));
		this.fenetre.revalidate();

	}

}
