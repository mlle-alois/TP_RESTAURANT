import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
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
	private int idCommande;

	/**
	 * Constructeur pour les plats
	 * @param bouton
	 * @param fenetre
	 * @param lesPlats
	 * @param nb
	 * @param jtfNom
	 * @param jtfPrix
	 * @param lblErreur
	 */
	public ActionAjouter(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JTextField jtfNom, JTextField jtfPrix, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
		this.jtfNom = jtfNom;
		this.jtfPrix = jtfPrix;
		this.lblErreur = lblErreur;
	}

	/**
	 * Constructeur pour les desserts
	 * @param fenetre
	 * @param bouton
	 * @param lesDesserts
	 * @param nb
	 * @param jtfNom
	 * @param jtfPrix
	 * @param lblErreur
	 */
	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Dessert> lesDesserts, int nb, JTextField jtfNom, JTextField jtfPrix, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesDesserts = lesDesserts;
		this.nb = nb;
		this.jtfNom = jtfNom;
		this.jtfPrix = jtfPrix;
		this.lblErreur = lblErreur;
	}

	/**
	 * Constructeur pour les boissons
	 * @param bouton
	 * @param fenetre
	 * @param lesBoissons
	 * @param nb
	 * @param jtfNom
	 * @param jtfPrix
	 * @param jtfQte
	 * @param jtfTaux
	 * @param lblErreur
	 */
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

	/**
	 * Constructeur pour les commandes
	 * @param fenetre
	 * @param bouton
	 * @param lesCommandes
	 * @param nb
	 * @param jtfNb
	 * @param lblErreur
	 * @param i
	 */
	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, JTextField jtfNb, JLabel lblErreur, int i) {
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesCommandes = lesCommandes;
		this.nb = nb;
		this.jtfNb = jtfNb;
		this.lblErreur = lblErreur;
		this.i = i;
		this.idCommande = 0;
	}

	/**
	 * Constructeur pour les commandes2
	 * @param fenetre
	 * @param bouton
	 * @param lesCommandes
	 * @param nb
	 * @param nbC
	 * @param lblErreur
	 * @param plat
	 * @param dessert
	 * @param boisson
	 * @param i
	 * @param idCommande
	 */
	public ActionAjouter(JFrame fenetre, JButton bouton, ArrayList<Commande> lesCommandes, int nb, int nbC, JLabel lblErreur, JComboBox plat, JComboBox dessert, JComboBox boisson, int i, int idCommande){
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
		this.idCommande = idCommande;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//si cela concerne les plats
		if(bouton.getName().equals("Plat")){
			//si une zonne de texte est vide
			if(jtfNom.getText().trim().equals("") || jtfPrix.getText().trim().equals("")){
				//erreur
				lblErreur.setText("Veuillez remplir tous les champs");
			}
			else{
				//sinon on vérifie que le prix est correct
				lblErreur.setText("");
				float prix = -1;
				try{
					prix = Float.parseFloat(jtfPrix.getText());
				}
				catch(Exception exception){
					lblErreur.setText("Veuillez saisir un prix valide");
				}
				//s'il est incorrect : erreur
				if(prix == -1){
					lblErreur.setText("<HTML>Veuillez saisir prix valide<br/>(Un point en guise de virgule)</HTML>");
				}
				else{
					//sinon on ajoute le plat
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
			//si cela concerne une commande
			if(bouton.getName().equals("Commande")){
				//si le nbr est vide
				if(jtfNb.getText().trim().equals("")){
					//erreur
					lblErreur.setText("Veuillez remplir le champ");
				}
				else{
					//sinon on vérifie que c'est bien un entier qui a été saisi
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
					//si c'est un entier on passe à l'étape 2 de la commande
					else{
						ArrayList<Plat> lesPlats = Modele.getLesPlats();
						ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
						ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
						fenetre.setContentPane(new Panel_AjouterCommande2(lesCommandes, fenetre, nb, nbC, i, lesPlats, lesDesserts, lesBoissons, idCommande));
						fenetre.revalidate();
					}
				}
			}
			else{
				//si cela concerne la commande à l'étape 2
				if(bouton.getName().equals("Commande2")){
					//tant que tous les couverts n'ont pas été saisis
					if(i <= nbC){
						//si au moins un couvert à été saisi on vérifie les informations
						if(i > 0){
							String valeur = (String) plat.getSelectedItem();
							float n;
							int idDessert = -1;
							int idPlat = -1;
							int idSoft = -1;
							int idAlcool = -1;
							//récupération de l'id du plat pour les différentes longueurs d'id
							if(valeur.charAt(1) == '.'){
								//longueur 1
								try{
									String c = valeur.charAt(0) + "";
									n = Float.parseFloat(c);
									idPlat = (int) n;
								}
								catch(Exception exception){
									lblErreur.setText("Erreur de type");
								}
							}
							else{
								//longueur 2
								if(valeur.charAt(2) == '.'){
									try{
										String c = valeur.substring(0,2);
										n = Float.parseFloat(c);
										idPlat = (int) n;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
								else{
									//longueur 3
									try{
										String c = valeur.substring(0,3);
										n = Float.parseFloat(c);
										idPlat = (int) n;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
							}
							//récupération de l'id du dessert  pour les différentes longueurs d'id
							valeur = (String) dessert.getSelectedItem();
							if(valeur.charAt(1) == '.'){
								//longueur 1
								try{
									String c = valeur.charAt(0) + "";
									n = Float.parseFloat(c);
									idDessert = (int) n;
								}
								catch(Exception exception){
									lblErreur.setText("Erreur de type");
								}
							}
							else{
								//longueur 2
								if(valeur.charAt(2) == '.'){
									try{
										String c = valeur.substring(0,2);
										n = Float.parseFloat(c);
										idDessert = (int) n;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
								else{
									//longueur 3
									try{
										String c = valeur.substring(0,3);
										n = Float.parseFloat(c);
										idDessert = (int) n;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
							}
							//récupération de l'id de la boisson  pour les différentes longueurs d'id
							valeur = (String) boisson.getSelectedItem();
							if(valeur.substring(0,4).equals("Soft")){
								//si c'est un soft
								if(valeur.charAt(8) == '.'){
									//longueur 1
									try{
										String c = valeur.charAt(7) + "";
										n = Float.parseFloat(c);
										idSoft = (int) n;
										idAlcool = 0;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
								else{
									//longueur 2
									if(valeur.charAt(9) == '.'){
										try{
											String c = valeur.substring(7,9);
											n = Float.parseFloat(c);
											idSoft = (int) n;
											idAlcool = 0;
										}
										catch(Exception exception){
											lblErreur.setText("Erreur de type");
										}
									}
									else{
										//longueur 3
										try{
											String c = valeur.substring(7,10);
											n = Float.parseFloat(c);
											idSoft = (int) n;
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
									//longueur 1
									try{
										String c = valeur.charAt(9) + "";
										n = Float.parseFloat(c);
										idAlcool = (int) n;
										idSoft = 0;
									}
									catch(Exception exception){
										lblErreur.setText("Erreur de type");
									}
								}
								else{
									//longueur 2
									if(valeur.charAt(11) == '.'){
										try{
											String c = valeur.substring(9,11);
											n = Float.parseFloat(c);
											idAlcool = (int) n;
											idSoft = 0;
										}
										catch(Exception exception){
											lblErreur.setText("Erreur de type");
										}
									}
									else{
										//longueur 3
										try{
											String c = valeur.substring(9,12);
											n = Float.parseFloat(c);
											idAlcool = (int) n;
											idSoft = 0;
										}
										catch(Exception exception){
											lblErreur.setText("Erreur de type");
										}
									}
								}
							}
							//si c'est le premier couvert on ajoute la commande
							if(i == 1){
								idCommande  = Modele.ajouterCommande(nbC, lesCommandes);
							}
							//on ajoute le menu du couvert n°i
							Modele.ajouterMenu(idDessert, idPlat, idSoft, idAlcool, idCommande);
						}
						ArrayList<Plat> lesPlats = Modele.getLesPlats();
						ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
						ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
						//si on a pas saisi tous les couverts, on saisi le suivant
						if(i < nbC){
							fenetre.setContentPane(new Panel_AjouterCommande2(lesCommandes, fenetre, nb, nbC, i, lesPlats, lesDesserts, lesBoissons, idCommande));
							fenetre.revalidate();
						}
						//si on a saisi le dernier, on revient aux commandes
						if(i == nbC){
							nb ++;
							fenetre.setContentPane(new Panel_Commandes(fenetre, lesCommandes, nb));
							fenetre.revalidate();
						}
					}
				}
			}
		}
	}
}
