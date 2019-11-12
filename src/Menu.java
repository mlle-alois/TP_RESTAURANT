
public class Menu {

	private int idMenu;
	private float prixM;
	private Dessert dessertM;
	private Plat platM;
	private Boisson boissonM;
	
	public Menu(int id, Dessert dessert, Plat plat, Boisson boisson) {
		this.idMenu = id;
		this.dessertM = dessert;
		this.platM = plat;
		this.boissonM = boisson;
	}
	
	public int getIdMenu() {
		return idMenu;
	}

	public Dessert getDessertM() {
		return dessertM;
	}

	public Plat getPlatM() {
		return platM;
	}

	
	public Boisson getBoissonM(){
		return boissonM;
	}


	public String toXML() {
		
		return null;
	}
}
