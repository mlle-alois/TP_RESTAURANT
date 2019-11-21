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
	 * Accesseur de récupération de donnée
	 * @return id dessert
	 */
	public int getIdDessert() {
		return idDessert;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return nom dessert
	 */
	public String getNomD() {
		return nomD;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return prix dessert
	 */
	public float getPrixD() {
		return prixD;
	}

	/**
	 * Fonction de récupération de données au format XML
	 * @return une chaine répondant au format XML des données du dessert
	 */
	public String toXML(){
		String chaine = "<Dessert>\n\t<idDessert>" + this.idDessert + "</idDessert>";
		chaine += "\n\t<nomDessert>" + this.nomD + "</nomDessert>";
		chaine += "\n\t<prixDessert>" + this.prixD + "</prixDessert>";
		chaine += "\n</Dessert>";
		return chaine;
	}

	/**
	 * Fonction de récupération de données au format JSon
	 * @return une chaine répondant au format JSon des données du dessert
	 */
	public String toJSon(){
		String chaine = "{<br/>\"idDessert\" : " + this.idDessert + ",";
		chaine += "<br/>\"nomDessert\" : \"" + this.nomD + "\",";
		chaine += "<br/>\"prixDessert\" : " + this.prixD + ",<br/>}";
		return chaine;
	}
	
}
