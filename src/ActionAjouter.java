import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class ActionAjouter implements ActionListener{

	private JButton bouton;
	private JFrame fenetre;
	private ArrayList<Plat> lesPlats;
	private ArrayList<Dessert> lesDesserts;
	private ArrayList<Boisson> lesBoissons;
	private ArrayList<Commande> lesCommandes;
	private int nb;
	private int i;
	private JTextField jtfNom;
	private JTextField jtfNb;
	private JTextField jtfPrix;
	private JTextField jtfQte;
	private JTextField jtfTaux;
	private JLabel lblErreur;
	private JComboBox plat;
	private JComboBox boisson;
	private JComboBox dessert;
	
	public ActionAjouter(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JTextField jtfNom, JTextField jtfPrix, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
		this.jtfNom = jtfNom;
		this.jtfPrix = jtfPrix;
		this.lblErreur = lblErreur;
	}
	
	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Dessert> lesDesserts, int nb, JTextField jtfNom, JTextField jtfPrix, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nb = nb;
		this.jtfNom = jtfNom;
		this.jtfPrix = jtfPrix;
		this.lblErreur = lblErreur;
	}
	
	public ActionAjouter(JButton bouton, JFrame fenetre, ArrayList<Boisson> lesBoissons, int nb, JTextField jtfNom, JTextField jtfPrix, JTextField jtfQte, JTextField jtfTaux, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesBoissons = lesBoissons;
		this.nb = nb;
		this.jtfNom = jtfNom;
		this.jtfPrix = jtfPrix;
		this.jtfQte = jtfQte;
		this.jtfTaux = jtfTaux;
		this.lblErreur = lblErreur;
	}
	
	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, JLabel lblErreur, JComboBox plat, JComboBox dessert, JComboBox boisson, int i){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
		this.lblErreur = lblErreur;
		this.plat = plat;
		this.dessert = dessert;
		this.boisson = boisson;
		this.i = i;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(bouton.getName().equals("Plat")){
			if(jtfNom.getText().trim().equals("") || jtfPrix.getText().trim().equals("")){
				lblErreur.setText("Veuillez remplir tous les champs");
			}
			else{
				lblErreur.setText("");
				float prix = -1;
				try{
					prix = Float.parseFloat(jtfPrix.getText());
				}
				catch(Exception exception){
					lblErreur.setText("Veuillez saisir un prix valide");
				}
				if(prix == -1){
					lblErreur.setText("<HTML>Veuillez saisir prix valide<br/>(Un point en guise de virgule)</HTML>");
				}
				else{
					try{
						Modele.ajouterPlat(jtfNom.getText(), prix, lesPlats);
					}
					catch(Exception exception){
						System.out.println("NON");
					}
					fenetre.setContentPane(new Panel_Plat(nb, lesPlats, fenetre));
					fenetre.revalidate();
				}
			}
		}
		else{
			/*if(bouton.getName().equals("Boisson")){
				fenetre.setContentPane(new Panel_AjouterBoisson(nb, lesDesserts, fenetre));
				fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Dessert")){
					fenetre.setContentPane(new Panel_AjouterDessert(nb, lesDesserts, fenetre));
					fenetre.revalidate();
				}
				else{*/
					if(bouton.getName().equals("Commande")){
						if(jtfNb.getText().trim().equals("")){
							lblErreur.setText("Veuillez remplir le champ");
						}
						else{
							lblErreur.setText("");
							float nbr = 0;
							int nbC = 0;
							try{
								nbr = Float.parseFloat(jtfNb.getText());
								nbC = (int) nbr;
							}
							catch(Exception exception){
								lblErreur.setText("<HTML>Veuillez saisir un nombre de<br/>couverts valide</HTML>");
							}
							if(nbC == 0){
								lblErreur.setText("<HTML>Veuillez saisir un nombre de<br/>couverts valide</HTML>");
							}
							else{
								if(i < nbC){
									if(i > 0){
										//Modele.ajouterMenu(idMenu, idDessert, idPlat, idSoft, idAlcool);
									}
									ArrayList<Plat> lesPlats = Modele.getLesPlats();
									ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
									ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
									fenetre.setContentPane(new Panel_AjouterCommande2(lesCommandes, fenetre, nb, nbC, i, lesPlats, lesDesserts, lesBoissons));
									fenetre.revalidate();
								}
								else{
									try{
										//Modele.ajouterCommande(jtfNb.getText());
									}
									catch(Exception exception){
										System.out.println("NON");
									}
									fenetre.setContentPane(new Panel_Commandes(fenetre, lesCommandes, nb));
									fenetre.revalidate();
								}
							}
						}
					}
				/*}
			}*/
		}
	}

}
