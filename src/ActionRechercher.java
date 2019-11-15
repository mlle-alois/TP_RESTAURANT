import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;

/**
 * 
 * @author azimmermann
 *
 */
public class ActionRechercher implements ActionListener{

	private JButton bouton;
	private JFrame fenetre;
	private ArrayList<Menu> lesMenus;
	private int nb;
	private JTextField jtfDate;
	private JLabel lblErreur;
	private JLabel lblNb;

	/**
	 * Constructeur pour les menus
	 * @param bouton
	 * @param fenetre
	 * @param lesMenus
	 * @param nb
	 * @param jtfDate
	 * @param lblErreur
	 * @param lblNb
	 */
	public ActionRechercher(JButton bouton, JFrame fenetre, ArrayList<Menu> lesMenus, int nb, JTextField jtfDate, JLabel lblErreur, JLabel lblNb){
		this.bouton = bouton;
		this.fenetre = fenetre;
		this.lesMenus = lesMenus;
		this.nb = nb;
		this.jtfDate = jtfDate;
		this.lblErreur = lblErreur;
		this.lblNb = lblNb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = null;
		//vérification que le champ n'est pas vide
		if(jtfDate.getText().trim().equals("")){
			lblErreur.setText("Veuillez remplir tous les champs");
		}
		else{
			//vérification de la validité de la date
			lblErreur.setText("");
			String d = "";
			String extrait = "";
			float extraitFloat = 0;
			int extraitEntier = 0;
			try{
				//validité de l'année
				d = jtfDate.getText();
				extrait = d.substring(0,4);
				extraitFloat = Float.parseFloat(extrait);
				extraitEntier = (int) extraitFloat;
				if(extraitEntier < 2000 || extraitEntier > 2050){
					lblErreur.setText("Veuillez saisir une année valide (aaaa-mm-jj)");
					lblNb.setText("");
				}
				else{
					//validité du mois
					lblErreur.setText("");
					extrait = d.substring(5,7);
					extraitFloat = Float.parseFloat(extrait);
					extraitEntier = (int) extraitFloat;
					if(extraitEntier < 1 || extraitEntier > 12){
						lblErreur.setText("Veuillez saisir un mois valide (aaaa-mm-jj)");
						lblNb.setText("");
					}
					else{
						//validité du jour
						lblErreur.setText("");
						extrait = d.substring(8,10);
						extraitFloat = Float.parseFloat(extrait);
						extraitEntier = (int) extraitFloat;
						if(extraitEntier < 1 || extraitEntier > 31){
							lblErreur.setText("Veuillez saisir un jour valide (aaaa-mm-jj)");
							lblNb.setText("");
						}
						//si tout est valide on fait la recherche
						else{
							lblErreur.setText("");
							date = new Date(LocalDate.parse(d));
							int nbMenuJour = -1;
							try{
								nbMenuJour = Modele.getNbMenus(date);
							}
							catch(Exception exception){
								System.out.println("NON");
							}
							fenetre.setContentPane(new Panel_RechercherMenu(nb, lesMenus, fenetre, nbMenuJour));
							fenetre.revalidate();
						}
					}
				}
			}
			catch(Exception exception){
				lblErreur.setText("Veuillez saisir une date valide (aaaa-mm-jj)");
				lblNb.setText("");
			}
		}
	}
}
