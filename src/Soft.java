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
	 * accesseur de r�cup�ration de donn�e
	 * @return taux de sucre
	 */
	public float getTauxSucre() {
		return tauxSucre;
	}

	@Override
	/**
	 * Fonction de r�cup�ration de donn�es au format XML
	 * @return une chaine r�pondant au format XML des donn�es du soft
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
