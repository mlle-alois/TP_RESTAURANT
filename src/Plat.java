
public class Plat {

	private int idPlat;
	private String nomP;
	private float prixP;
	
	public Plat(int id, String nom, float prix){
		this.idPlat = id;
		this.nomP = nom;
		this.prixP = prix;
	}

	public int getIdPlat() {
		return idPlat;
	}

	public String getNomP() {
		return nomP;
	}

	public float getPrixP() {
		return prixP;
	}
	
	public String toXML(){
		String chaine = "<Plat>\n\t<idPlat>" + this.idPlat + "</idPlat>";
		chaine += "\n\t<nomPlat>" + this.nomP + "</nomPlat>";
		chaine += "\n\t<prixPlat>" + this.prixP + "</prixPlat>";
		chaine += "\n</Plat>";
		return chaine;
	}
	
	public String toCSV(){
		String chaine = "idPlat;nomPlat;prixPlat\n";
		chaine += this.idPlat + ";" + this.nomP + ";" + this.prixP;
		return chaine;
	}
		
}
