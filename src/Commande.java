/**
 * 
 * @author azimmermann
 *
 */
public class Commande {

	private int idCommande;
	private int nbCouverts;
	private Date dateCommande;
	
	/**
	 * Constructeur de la commande
	 * @param id
	 * @param nb
	 * @param date
	 */
	public Commande(int id, int nb, Date date){
		this.idCommande = id;
		this.nbCouverts = nb;
		this.dateCommande = date;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return id commande
	 */
	public int getIdCommande() {
		return idCommande;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return nombre de couverts
	 */
	public int getNbCouverts() {
		return nbCouverts;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return date de la commande (jj/mm/aaaa)
	 */
	public String getDateCommande() {
		return dateCommande.getDateFrancais();
	}
	
}
