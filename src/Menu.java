
public class Menu {

	private int idMenu;
	private Dessert dessertM;
	private Plat platM;
	private Soft softM;
	private Alcool alcoolM;
	
	public Menu(int id, Dessert dessert, Plat plat, Soft soft, Alcool alcool) {
		this.idMenu = id;
		this.dessertM = dessert;
		this.platM = plat;
		this.softM = soft;
		this.alcoolM = alcool;
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


	public Soft getSoftM() {
		return softM;
	}

	public Alcool getAlcoolM() {
		return alcoolM;
	}

	public String toXML() {
		String chaine = "<Menu>\n\t<idMenu>" + this.idMenu + "</idMenu>";
		chaine += "\n\t<Plat>\n\t" + this.platM.toXML() + "</Plat>";
		chaine += "\n\t<Dessert>\n\t" + this.dessertM.toXML() + "</Dessert>";
		chaine += "\n</Menu>";
		return chaine;
	}
}
