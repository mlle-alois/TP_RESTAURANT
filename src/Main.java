import java.util.ArrayList;
/**
 * 
 * @author azimmermann
 *
 */
public class Main {

	public static void main(String[] args) {

		//connexion à la bdd
		Modele.connexion();
		
		//affichage de la fenetre
		Fenetre_principale uneFenetre = new Fenetre_principale();
		
	}
}
