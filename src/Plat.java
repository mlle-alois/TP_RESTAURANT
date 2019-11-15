/**
 * 
 * @author azimmermann
 *
 */
public class Plat {

	private int idPlat;
	private String nomP;
	private float prixP;
	
	/**
	 * Constructeur du plat
	 * @param id
	 * @param nom
	 * @param prix
	 */
	public Plat(int id, String nom, float prix){
		this.idPlat = id;
		this.nomP = nom;
		this.prixP = prix;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return id plat
	 */
	public int getIdPlat() {
		return idPlat;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return nom plat
	 */
	public String getNomP() {
		return nomP;
	}

	/**
	 * Accesseur de récupération de donnée
	 * @return prix plat
	 */
	public float getPrixP() {
		return prixP;
	}
	
	/**
	 * Fonction de récupération de données au format XML
	 * @return une chaine répondant au format XML des données du plat
	 */
	public String toXML(){
		String chaine = "<Plat>\n\t<idPlat>" + this.idPlat + "</idPlat>";
		chaine += "\n\t<nomPlat>" + this.nomP + "</nomPlat>";
		chaine += "\n\t<prixPlat>" + this.prixP + "</prixPlat>";
		chaine += "\n</Plat>";
		return chaine;
	}

	/**
	 * Fonction de récupération de données au format CSV
	 * @return une chaine répondant au format CSV des données du plat
	 */
	public String toCSV(){
		String chaine = "idPlat;nomPlat;prixPlat<br/>";
		chaine += this.idPlat + ";" + this.nomP + ";" + this.prixP;
		return chaine;
	}
		
}
