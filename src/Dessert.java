
public class Dessert {

	private int idDessert;
	private String nomD;
	private float prixD;
	
	public Dessert(int id, String nom, float prix){
		this.idDessert = id;
		this.nomD = nom;
		this.prixD = prix;
	}

	public int getIdDessert() {
		return idDessert;
	}

	public String getNomD() {
		return nomD;
	}

	public float getPrixD() {
		return prixD;
	}
	
	public String toXML(){
		String chaine = "<Dessert>\n\t<idDessert>" + this.idDessert + "</idDessert>";
		chaine += "\n\t<nomDessert>" + this.nomD + "</nomDessert>";
		chaine += "\n\t<prixDessert>" + this.prixD + "</prixDessert>";
		chaine += "\n</Dessert>";
		return chaine;
	}
	
	public String toJSon(){
		String chaine = "{<br/>\"idDessert\" : " + this.idDessert + ",";
		chaine += "<br/>\"nomDessert\" : \"" + this.nomD + "\",";
		chaine += "<br/>\"prixDessert\" : " + this.prixD + ",<br/>}";
		return chaine;
	}
	
}
