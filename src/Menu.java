
public class Menu {

	private int idMenu;
	private String nomM;
	private float prixM;
	private Dessert dessertM;
	private Plat platM;
	private Soft softM;
	private Alcool alcoolM;
	
	public Menu(int id, String nom, float prix, Dessert dessert, Plat plat, Soft soft, Alcool alcool) {
		this.idMenu = id;
		this.nomM = nom;
		this.prixM = prix;
		this.dessertM = dessert;
		this.platM = plat;
		this.softM = soft;
		this.alcoolM = alcool;
	}
	
	public String toXML() {
		
		return null;
	}
}
