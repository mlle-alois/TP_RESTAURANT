/**
 * Classe fille de Boisson
 * @author azimmermann
 *
 */
public class Soft extends Boisson{

	private float tauxSucre;
	
	/**
	 * Constructeur du soft
	 * @param id
	 * @param nom
	 * @param prix
	 * @param qte
	 * @param taux
	 */
	public Soft(int id, String nom, float prix, String qte, float taux){
		super(id, nom, prix, qte);
		this.tauxSucre = taux;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return taux de sucre
	 */
	public float getTauxSucre() {
		return tauxSucre;
	}

	@Override
	/**
	 * Fonction de récupération de données au format XML
	 * @return une chaine répondant au format XML des données du soft
	 */
	public String toXML(){
		String chaine = "<Soft>\n\t<idSoft>" + this.idBoisson + "</idSoft>";
		chaine += "\n\t<nomSoft>" + this.nomB + "</nomSoft>";
		chaine += "\n\t<prixSoft>" + this.prixB + "</prixSoft>";
		chaine += "\n\t<qteSoft>" + this.qteB + "</qteSoft>";
		chaine += "\n\t<tauxSucre>" + this.tauxSucre + "</tauxSucre>";
		chaine += "\n</Soft>";
		return chaine;
	}
}
