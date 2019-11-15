/**
 * 
 * @author azimmermann
 *
 */
public class Dessert {

	private int idDessert;
	private String nomD;
	private float prixD;
	
	/**
	 * Constructeur du dessert
	 * @param id
	 * @param nom
	 * @param prix
	 */
	public Dessert(int id, String nom, float prix){
		this.idDessert = id;
		this.nomD = nom;
		this.prixD = prix;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return id dessert
	 */
	public int getIdDessert() {
		return idDessert;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return nom dessert
	 */
	public String getNomD() {
		return nomD;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return prix dessert
	 */
	public float getPrixD() {
		return prixD;
	}

	/**
	 * Fonction de r�cup�ration de donn�es au format XML
	 * @return une chaine r�pondant au format XML des donn�es du dessert
	 */
	public String toXML(){
		String chaine = "<Dessert>\n\t<idDessert>" + this.idDessert + "</idDessert>";
		chaine += "\n\t<nomDessert>" + this.nomD + "</nomDessert>";
		chaine += "\n\t<prixDessert>" + this.prixD + "</prixDessert>";
		chaine += "\n</Dessert>";
		return chaine;
	}

	/**
	 * Fonction de r�cup�ration de donn�es au format JSon
	 * @return une chaine r�pondant au format JSon des donn�es du dessert
	 */
	public String toJSon(){
		String chaine = "{<br/>\"idDessert\" : " + this.idDessert + ",";
		chaine += "<br/>\"nomDessert\" : \"" + this.nomD + "\",";
		chaine += "<br/>\"prixDessert\" : " + this.prixD + ",<br/>}";
		return chaine;
	}
	
}
