
public class Soft extends Boisson{

	private float tauxSucre;
	
	public Soft(int id, String nom, float prix, String qte, float taux){
		super(id, nom, prix, qte);
		this.tauxSucre = taux;
	}

	public float getTauxSucre() {
		return tauxSucre;
	}

	@Override
	public String toXML(){
		String chaine = "<Soft>\n\t<idSoft>" + this.idBoisson + "</idSoft>";
		chaine += "\n\t<nomSoft>" + this.nomB + "</nomSoft>";
		chaine += "\n\t<prixSoft>" + this.prixB + "</prixSoft>";
		chaine += "\n\t<qteSoft>" + this.qteB + "</qteSoft>";
		chaine += "\n\t<tauxSucre>" + this.tauxSucre + "</tauxSucre>";
		chaine += "\n</Soft>";
		return chaine;
	}
}
