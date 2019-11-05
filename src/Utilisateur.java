
public class Utilisateur {

	private int idUser;
	private String nomUser;
	private String prenomUser;
	private String mailUser;
	private String adrUser;
	private String cpUser;
	private String villeUser;
	private String mdpUser;
	
	public Utilisateur(int idUser, String nomUser, String prenomUser, String mailUser, String adrUser, String cpUser, String villeUser, String mdpUser){
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.mailUser = mailUser;
		this.adrUser = adrUser;
		this.cpUser = cpUser;
		this.villeUser = villeUser;
		this.mdpUser = mdpUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public String getMailUser() {
		return mailUser;
	}

	public String getAdrUser() {
		return adrUser;
	}

	public String getCpUser() {
		return cpUser;
	}

	public String getVilleUser() {
		return villeUser;
	}

	public String getMdpUser() {
		return mdpUser;
	}
}
