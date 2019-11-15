import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
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

	/**
	 * Constructeur pour les plats
	 * @param bouton
	 * @param fenetre
	 * @param lesPlats
	 * @param nb
	 * @param jtf
	 * @param lblErreur
	 */
	public ActionSupprimer(JButton bouton, JFrame fenetre, ArrayList<Plat> lesPlats, int nb, JTextField jtf, JLabel lblErreur){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesPlats = lesPlats;
		this.nb = nb;
		this.jtfId = jtf;
		this.lblErreur = lblErreur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//on vérifie que le champ n'est pas vide
		if(jtfId.getText().trim().equals("")){
			lblErreur.setText("Veuillez remplir le champ");
		}
		else{
			//et on vérifie si un entier a été saisi
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
			//et si l'id existe
			if(id <= 0 || id > nb){
				lblErreur.setText("Numero non existant");
			}
			else{
				//puis on supprime le plat
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
}
