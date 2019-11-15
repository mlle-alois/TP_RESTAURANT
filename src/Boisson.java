/**
 * Classe abstraite
 * @author azimmermann
 *
 */
public abstract class Boisson {

	protected int idBoisson;
	protected String nomB;
	protected float prixB;
	protected String qteB;
	
	/**
	 * Constructeur de la boisson
	 * @param id
	 * @param nom
	 * @param prix
	 * @param qte
	 */
	public Boisson(int id, String nom, float prix, String qte){
		this.idBoisson = id;
		this.nomB = nom;
		this.prixB = prix;
		this.qteB = qte;
	}
	
	/**
	 * accesseur de r�cup�ration de donn�e
	 * @return id boisson
	 */
	public int getIdBoisson() {
		return idBoisson;
	}

	/**
	 * accesseur de r�cup�ration de donn�e
	 * @return nom boisson
	 */
	public String getNomB() {
		return nomB;
	}

	/**
	 * accesseur de r�cup�ration de donn�e
	 * @return prix boisson
	 */
	public float getPrixB() {
		return prixB;
	}

	/**
	 * accesseur de r�cup�ration de donn�e
	 * @return quantit� boisson
	 */
	public String getQteB() {
		return qteB;
	}

	/**
	 * Fonction abstraite de r�cup�ration de donn�es au format XML
	 * @return une chaine r�pondant au format XML des donn�es de la classe fille
	 */
	public abstract String toXML();
	
}
