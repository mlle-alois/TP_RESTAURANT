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
	 * Accesseur de r�cup�ration de donn�e
	 * @return id commande
	 */
	public int getIdCommande() {
		return idCommande;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return nombre de couverts
	 */
	public int getNbCouverts() {
		return nbCouverts;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return date de la commande (jj/mm/aaaa)
	 */
	public String getDateCommande() {
		return dateCommande.getDateFrancais();
	}
	
}
