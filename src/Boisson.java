
public abstract class Boisson {

	protected int idBoisson;
	protected String nomB;
	protected float prixB;
	protected String qteB;
	
	public Boisson(int id, String nom, float prix, String qte){
		this.idBoisson = id;
		this.nomB = nom;
		this.prixB = prix;
		this.qteB = qte;
	}
	
	public int getIdBoisson() {
		return idBoisson;
	}

	public String getNomB() {
		return nomB;
	}

	public float getPrixB() {
		return prixB;
	}

	public String getQteB() {
		return qteB;
	}

	public abstract String toXML();
	
}
