
public class Alcool extends Boisson{

	private float degreAlcool;
	
	public Alcool(int id, String nom, float prix, String qte, float degre){
		super(id, nom, prix, qte);
		this.degreAlcool = degre;
	}

	public float getDegreAlcool() {
		return degreAlcool;
	}

	@Override
	public String toXML(){
		String chaine = "<Alcool>\n\t<idAlcool>" + this.idBoisson + "</idAlcool>";
		chaine += "\n\t<nomAlcool>" + this.nomB + "</nomAlcool>";
		chaine += "\n\t<prixAlcool>" + this.prixB + "</prixAlcool>";
		chaine += "\n\t<qteAlcool>" + this.qteB + "</qteAlcool>";
		chaine += "\n\t<degreAlcool>" + this.degreAlcool + "</degreAlcool>";
		chaine += "\n</Alcool>";
		return chaine;
	}
}
