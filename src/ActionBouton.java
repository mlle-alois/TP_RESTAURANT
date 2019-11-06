import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionBouton implements ActionListener{

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
	
	public ActionBouton(JMenuBar menu, JFrame fenetre, JTextField jtfMail, JPasswordField jpfMdp, JButton bouton, JLabel lblErreur) {
		this.menu = menu;
		this.fenetre = fenetre;
		this.jtfMail = jtfMail;
		this.jpfMdp = jpfMdp;
		this.bouton = bouton;
		this.lblErreur = lblErreur;
	}
	
	public ActionBouton(JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
		this.bouton = bouton;
	}
	
	public ActionBouton(ArrayList<Commande> lesCommandes, JFrame fenetre, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nbCommandes = nb;
		this.bouton = bouton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(bouton.getName().equals("Connexion")){
			char[] c = jpfMdp.getPassword();
			String mdp = new String(c).trim();
			String mail = jtfMail.getText().trim();
			if(mail.equals("") || mdp.equals("")){
				this.lblErreur.setText("Veuillez saisir tous les champs");
			}
			else{
				this.lblErreur.setText("");
				boolean bool = Modele.connecterUser(mail, mdp);
				if(bool == true){
					fenetre.setContentPane(new Panel_Restaurant(menu, fenetre));
					fenetre.revalidate();
				}
				else{
					this.lblErreur.setText("Identifiants incorrects");
				}
			}
		}
		else{
			if(bouton.getName().equals("Plat")){
				this.fenetre.setContentPane(new Panel_AjouterPlat(fenetre, lesPlats, nbPlat));
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

}
