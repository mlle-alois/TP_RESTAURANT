import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class ActionBouton implements ActionListener{

	private JMenuBar menu;
	private JFrame fenetre;
	private JTextField jtfMail;
	private JPasswordField jpfMdp;
	private JButton bouton;
	private JLabel lblErreur;
	private ArrayList<Plat> lesPlats;
	private int nbPlat;
	private int nbMenus;
	private ArrayList<Commande> lesCommandes;
	private ArrayList<Menu> lesMenus;
	private int nbCommandes;
	private int nbMenuJour;

	/**
	 * Constructeur pour la connexion
	 * @param menu
	 * @param fenetre
	 * @param jtfMail
	 * @param jpfMdp
	 * @param bouton
	 * @param lblErreur
	 */
	public ActionBouton(JMenuBar menu, JFrame fenetre, JTextField jtfMail, JPasswordField jpfMdp, JButton bouton, JLabel lblErreur) {
		this.menu = menu;
		this.fenetre = fenetre;
		this.jtfMail = jtfMail;
		this.jpfMdp = jpfMdp;
		this.bouton = bouton;
		this.lblErreur = lblErreur;
	}

	/**
	 * Constructeur pour les plats
	 * @param fenetre
	 * @param lesPlats
	 * @param nb
	 * @param bouton
	 */
	public ActionBouton(JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nbPlat = nb;
		this.bouton = bouton;
	}

	/**
	 * Constructeur pour les commandes
	 * @param lesCommandes
	 * @param fenetre
	 * @param nb
	 * @param bouton
	 */
	public ActionBouton(ArrayList<Commande> lesCommandes, JFrame fenetre, int nb, JButton bouton){
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nbCommandes = nb;
		this.bouton = bouton;
	}

	/**
	 * Constructeur pour les menus
	 * @param bouton
	 * @param lesMenus
	 * @param fenetre
	 * @param nb
	 * @param nbMenu
	 */
	public ActionBouton(JButton bouton, ArrayList<Menu> lesMenus, JFrame fenetre, int nb, int nbMenu){
		this.fenetre = fenetre;
		this.lesMenus = lesMenus;
		this.nbMenus = nb;
		this.bouton = bouton;
		this.nbMenuJour = nbMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//si cela concerne la connexion
		if(bouton.getName().equals("Connexion")){
			//on récupère le mot de passe
			char[] c = jpfMdp.getPassword();
			String mdp = new String(c).trim();
			//et le mail
			String mail = jtfMail.getText().trim();
			//on vérifie que les champs sont remplis
			if(mail.equals("") || mdp.equals("")){
				this.lblErreur.setText("Veuillez saisir tous les champs");
			}
			else{
				//on tente de connecter l'utilisateur
				this.lblErreur.setText("");
				boolean bool = Modele.connecterUser(mail, mdp);
				//si les id sont corrects on accède à l'application
				if(bool == true){
					fenetre.setContentPane(new Panel_Restaurant(menu, fenetre));
					fenetre.revalidate();
				}
				//sinon erreur
				else{
					this.lblErreur.setText("Identifiants incorrects");
				}
			}
		}
		else{
			//on génère le panel correspondant au sujet concerné
			if(bouton.getName().equals("Plat")){
				this.fenetre.setContentPane(new Panel_AjouterPlat(fenetre, lesPlats, nbPlat));
				this.fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Commande")){
					this.fenetre.setContentPane(new Panel_AjouterCommande(lesCommandes, fenetre, nbCommandes));
					this.fenetre.revalidate();
				}
				else{
					if(bouton.getName().equals("PlatS")){
						this.fenetre.setContentPane(new Panel_SupprimerPlat(fenetre, lesPlats, nbPlat));
						this.fenetre.revalidate();
					}
					else{
						if(bouton.getName().equals("Menu")){
							this.fenetre.setContentPane(new Panel_RechercherMenu(nbMenus, lesMenus, fenetre, nbMenuJour));
							this.fenetre.revalidate();
						}
					}
				}
			}
		}
	}

}
