
public class Commande {

	private int idCommande;
	private int nbCouverts;
	private Date dateCommande;
	
	public Commande(int id, int nb, Date date){
		this.idCommande = id;
		this.nbCouverts = nb;
		this.dateCommande = date;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public int getNbCouverts() {
		return nbCouverts;
	}

	public Date getDateCommande() {
		return dateCommande;
	}
	
}
