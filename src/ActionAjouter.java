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
	private int nb;
	private JTextField jtfNom;
	private JTextField jtfPrix;
	private JTextField jtfQte;
	private JTextField jtfTaux;
	private JLabel lblErreur;
	
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
				fenetre.setContentPane(new Panel_Dessert(nb, lesDesserts, fenetre));
				fenetre.revalidate();
			}
		}
	}

}
