import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionSupprimer implements ActionListener{

	private JButton bouton;
	private JFrame fenetre;
	private ArrayList<Plat> lesPlats;
	private ArrayList<Dessert> lesDesserts;
	private ArrayList<Boisson> lesBoissons;
	private ArrayList<Commande> lesCommandes;
	private int nb;
	private int nbC;
	private int i;
	private JTextField jtfId;
	private JTextField jtfNb;
	private JTextField jtfPrix;
	private JTextField jtfQte;
	private JTextField jtfTaux;
	private JLabel lblErreur;
	private JComboBox plat;
	private JComboBox boisson;
	private JComboBox dessert;

	public ActionSupprimer(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JTextField jtf, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
		this.jtfId = jtf;
		this.lblErreur = lblErreur;
	}

	public ActionSupprimer(JFrame fenetre, JButton bouton, ArrayList<Dessert> lesDesserts, int nb, JTextField jtfNom, JTextField jtfPrix, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nb = nb;
		this.jtfId = jtfNom;
		this.jtfPrix = jtfPrix;
		this.lblErreur = lblErreur;
	}

	public ActionSupprimer(JButton bouton, JFrame fenetre, ArrayList<Boisson> lesBoissons, int nb, JTextField jtfNom, JTextField jtfPrix, JTextField jtfQte, JTextField jtfTaux, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesBoissons = lesBoissons;
		this.nb = nb;
		this.jtfId = jtfNom;
		this.jtfPrix = jtfPrix;
		this.jtfQte = jtfQte;
		this.jtfTaux = jtfTaux;
		this.lblErreur = lblErreur;
	}

	public ActionSupprimer(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, JTextField jtfNb, JLabel lblErreur, int i) {
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
		this.jtfNb = jtfNb;
		this.lblErreur = lblErreur;
		this.i = i;
	}

	public ActionSupprimer(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, int nbC, JLabel lblErreur, JComboBox plat, JComboBox dessert, JComboBox boisson, int i){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
		this.nbC = nbC;
		this.lblErreur = lblErreur;
		this.plat = plat;
		this.dessert = dessert;
		this.boisson = boisson;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(bouton.getName().equals("Plat")){
			if(jtfId.getText().trim().equals("")){
				lblErreur.setText("Veuillez remplir le champ");
			}
			else{
				lblErreur.setText("");
				float num = -1;
				int id = -1;
				try{
					num = Float.parseFloat(jtfId.getText());
					id = (int) num;
				}
				catch(Exception exception){
					lblErreur.setText("Veuillez saisir un numéro valide");
				}
				int nb = Modele.getMaxIdPlat();
				if(id <= 0 || id > nb){
					lblErreur.setText("Numero non existant");
				}
				else{
					try{
						Modele.supprimerPlat(id);
						lesPlats = Modele.getLesPlats();
					}
					catch(Exception exception){
						System.out.println("NON");
					}
				}
				fenetre.setContentPane(new Panel_Plat(nb, lesPlats, fenetre));
				fenetre.revalidate();

			}
		}
		else{
			if(bouton.getName().equals("Boisson")){
				//fenetre.setContentPane(new Panel_AjouterBoisson(nb, lesDesserts, fenetre));
				fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Dessert")){
					//fenetre.setContentPane(new Panel_AjouterDessert(nb, lesDesserts, fenetre));
					fenetre.revalidate();
				}
			}
		}
	}

}
