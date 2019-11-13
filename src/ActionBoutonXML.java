import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ActionBoutonXML implements ActionListener {

	private JMenuBar menu;
	private JFrame fenetre;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton bouton;
	private JLabel lblErreur;
	private ArrayList<Plat> lesPlats;
	private int nbPlat;
	private ArrayList<Commande> lesCommandes;
	private int nbCommandes;

	public ActionBoutonXML(JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
		this.bouton = bouton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(bouton.getName().equals("Plat")){
			this.fenetre.setContentPane(new Panel_PlatXML(fenetre, lesPlats, nbPlat));
			this.fenetre.revalidate();
		}
		else{
			if(bouton.getName().equals("Commande")){
				this.fenetre.setContentPane(new Panel_AjouterCommande(lesCommandes, fenetre, nbCommandes));
				this.fenetre.revalidate();
			}
		}

	}

}
