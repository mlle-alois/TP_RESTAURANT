/**
 * 
 * @author azimmermann
 *
 */
public class Menu {

	private int idMenu;
	private Dessert dessertM;
	private Plat platM;
	private Soft softM;
	private Alcool alcoolM;
	
	/**
	 * Constructeur du menu
	 * @param id
	 * @param dessert
	 * @param plat
	 * @param soft
	 * @param alcool
	 */
	public Menu(int id, Dessert dessert, Plat plat, Soft soft, Alcool alcool) {
		this.idMenu = id;
		this.dessertM = dessert;
		this.platM = plat;
		this.softM = soft;
		this.alcoolM = alcool;
	}
	
	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return id menu
	 */
	public int getIdMenu() {
		return idMenu;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return dessert du menu
	 */
	public Dessert getDessertM() {
		return dessertM;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return plat du menu
	 */
	public Plat getPlatM() {
		return platM;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return soft du menu (null si alcool non null)
	 */
	public Soft getSoftM() {
		return softM;
	}

	/**
	 * Accesseur de r�cup�ration de donn�e
	 * @return alcool du menu (null si soft non null)
	 */
	public Alcool getAlcoolM() {
		return alcoolM;
	}

	/**
	 * Fonction de r�cup�ration de donn�es au format XML
	 * @return une chaine r�pondant au format XML des donn�es du menu
	 */
	public String toXML() {
		String chaine = "<Menu>\n\t<idMenu>" + this.idMenu + "</idMenu>";
		chaine += "\n\t<Plat>\n\t" + this.platM.toXML() + "</Plat>";
		chaine += "\n\t<Dessert>\n\t" + this.dessertM.toXML() + "</Dessert>";
		chaine += "\n</Menu>";
		return chaine;
	}
}
