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
	 * accesseur de récupération de donnée
	 * @return id boisson
	 */
	public int getIdBoisson() {
		return idBoisson;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return nom boisson
	 */
	public String getNomB() {
		return nomB;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return prix boisson
	 */
	public float getPrixB() {
		return prixB;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return quantité boisson
	 */
	public String getQteB() {
		return qteB;
	}

	/**
	 * Fonction abstraite de récupération de données au format XML
	 * @return une chaine répondant au format XML des données de la classe fille
	 */
	public abstract String toXML();
	
}
