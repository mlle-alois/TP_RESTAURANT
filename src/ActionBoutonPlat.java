import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionBoutonPlat implements ActionListener{

	private JFrame fenetre;
	private ArrayList<Plat> lesPlats;
	private int nbPlat;
	
	public ActionBoutonPlat(JFrame fenetre, ArrayList<Plat> lesPlats, int nb){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.fenetre.setContentPane(new Panel_AjouterPlat(fenetre, lesPlats, nbPlat));
		this.fenetre.revalidate();
	}

}
