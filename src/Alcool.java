/**
 * Classe fille de Boisson
 * @author azimmermann
 *
 */
public class Alcool extends Boisson{

	private float degreAlcool;
	
	/**
	 * Constructeur de l'alcool
	 * @param id
	 * @param nom
	 * @param prix
	 * @param qte
	 * @param degre
	 */
	public Alcool(int id, String nom, float prix, String qte, float degre){
		super(id, nom, prix, qte);
		this.degreAlcool = degre;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return degré d'alcool
	 */
	public float getDegreAlcool() {
		return degreAlcool;
	}

	@Override
	/**
	 * Fonction de récupération de données au format XML
	 * @return une chaine répondant au format XML des données de l'alcool
	 */
	public String toXML(){
		String chaine = "<Alcool>\n\t<idAlcool>" + this.idBoisson + "</idAlcool>";
		chaine += "\n\t<nomAlcool>" + this.nomB + "</nomAlcool>";
		chaine += "\n\t<prixAlcool>" + this.prixB + "</prixAlcool>";
		chaine += "\n\t<qteAlcool>" + this.qteB + "</qteAlcool>";
		chaine += "\n\t<degreAlcool>" + this.degreAlcool + "</degreAlcool>";
		chaine += "\n</Alcool>";
		return chaine;
	}
}
