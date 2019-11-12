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
	private int nbC;
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

	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, JTextField jtfNb, JLabel lblErreur, int i) {
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
		this.jtfNb = jtfNb;
		this.lblErreur = lblErreur;
		this.i = i;
	}

	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, int nbC, JLabel lblErreur, JComboBox plat, JComboBox dessert, JComboBox boisson, int i){
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
			if(bouton.getName().equals("Boisson")){
				//fenetre.setContentPane(new Panel_AjouterBoisson(nb, lesDesserts, fenetre));
				fenetre.revalidate();
			}
			else{
				if(bouton.getName().equals("Dessert")){
					//fenetre.setContentPane(new Panel_AjouterDessert(nb, lesDesserts, fenetre));
					fenetre.revalidate();
				}
				else{
					if(bouton.getName().equals("Commande")){
						if(jtfNb.getText().trim().equals("")){
							lblErreur.setText("Veuillez remplir le champ");
						}
						else{
							lblErreur.setText("");
							float nbr = 0;
							nbC = 0;
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
								ArrayList<Plat> lesPlats = Modele.getLesPlats();
								ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
								ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
								fenetre.setContentPane(new Panel_AjouterCommande2(lesCommandes, fenetre, nb, nbC, i, lesPlats, lesDesserts, lesBoissons));
								fenetre.revalidate();
							}
						}
					}
					else{
						if(bouton.getName().equals("Commande2")){
							if(i < nbC){
								if(i > 0){
									String valeur = (String) plat.getSelectedItem();
									float nb;
									int idDessert = -1;
									int idPlat = -1;
									int idSoft = -1;
									int idAlcool = -1;
									//récupération de l'id du plat
									if(valeur.charAt(1) == '.'){
										try{
											String c = valeur.charAt(0) + "";
											nb = Float.parseFloat(c);
											idPlat = (int) nb;
										}
										catch(Exception exception){
											lblErreur.setText("Erreur de type");
										}
									}
									else{
										if(valeur.charAt(2) == '.'){
											try{
												String c = valeur.substring(0,2);
												nb = Float.parseFloat(c);
												idPlat = (int) nb;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
										else{
											try{
												String c = valeur.substring(0,3);
												nb = Float.parseFloat(c);
												idPlat = (int) nb;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
									}
									//récupération de l'id du dessert
									valeur = (String) dessert.getSelectedItem();
									if(valeur.charAt(1) == '.'){
										try{
											String c = valeur.charAt(0) + "";
											nb = Float.parseFloat(c);
											idDessert = (int) nb;
										}
										catch(Exception exception){
											lblErreur.setText("Erreur de type");
										}
									}
									else{
										if(valeur.charAt(2) == '.'){
											try{
												String c = valeur.substring(0,2);
												nb = Float.parseFloat(c);
												idDessert = (int) nb;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
										else{
											try{
												String c = valeur.substring(0,3);
												nb = Float.parseFloat(c);
												idDessert = (int) nb;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
									}
									//récupération de l'id de la boisson
									valeur = (String) boisson.getSelectedItem();
									if(valeur.substring(0,4).equals("Soft")){
										//si c'est un soft
										if(valeur.charAt(8) == '.'){
											try{
												String c = valeur.charAt(7) + "";
												nb = Float.parseFloat(c);
												idSoft = (int) nb;
												idAlcool = 0;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
										else{
											if(valeur.charAt(9) == '.'){
												try{
													String c = valeur.substring(7,9);
													nb = Float.parseFloat(c);
													idSoft = (int) nb;
													idAlcool = 0;
												}
												catch(Exception exception){
													lblErreur.setText("Erreur de type");
												}
											}
											else{
												try{
													String c = valeur.substring(7,10);
													nb = Float.parseFloat(c);
													idSoft = (int) nb;
													idAlcool = 0;
												}
												catch(Exception exception){
													lblErreur.setText("Erreur de type");
												}
											}
										}
									}
									else{
										//si c'est un alcool
										if(valeur.charAt(10) == '.'){
											try{
												String c = valeur.charAt(9) + "";
												nb = Float.parseFloat(c);
												idAlcool = (int) nb;
												idSoft = 0;
											}
											catch(Exception exception){
												lblErreur.setText("Erreur de type");
											}
										}
										else{
											if(valeur.charAt(11) == '.'){
												try{
													String c = valeur.substring(9,11);
													nb = Float.parseFloat(c);
													idAlcool = (int) nb;
													idSoft = 0;
												}
												catch(Exception exception){
													lblErreur.setText("Erreur de type");
												}
											}
											else{
												try{
													String c = valeur.substring(9,12);
													nb = Float.parseFloat(c);
													idAlcool = (int) nb;
													idSoft = 0;
												}
												catch(Exception exception){
													lblErreur.setText("Erreur de type");
												}
											}
										}
									}
									Modele.ajouterMenu(idDessert, idPlat, idSoft, idAlcool);
								}
								ArrayList<Plat> lesPlats = Modele.getLesPlats();
								ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
								ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
								fenetre.setContentPane(new Panel_AjouterCommande2(lesCommandes, fenetre, nb, nbC, i, lesPlats, lesDesserts, lesBoissons));
								fenetre.revalidate();
							}
							else{
								Modele.ajouterCommande(nbC, lesCommandes);
								fenetre.setContentPane(new Panel_Commandes(fenetre, lesCommandes, nb));
								fenetre.revalidate();
							}
						}
					}
				}
			}
		}
	}

}
