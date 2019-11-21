/**
 * 
 * @author azimmermann
 *
 */
public class Utilisateur {

	private int idUser;
	private String nomUser;
	private String prenomUser;
	private String mailUser;
	private String adrUser;
	private String cpUser;
	private String villeUser;
	private String mdpUser;
	
	/**
	 * Constructeur de l'utilisateur
	 * @param idUser
	 * @param nomUser
	 * @param prenomUser
	 * @param mailUser
	 * @param adrUser
	 * @param cpUser
	 * @param villeUser
	 * @param mdpUser
	 */
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

	/**
	 * accesseur de récupération de donnée
	 * @return id de l'user
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return nom de l'user
	 */
	public String getNomUser() {
		return nomUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return prenom de l'user
	 */
	public String getPrenomUser() {
		return prenomUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return mail de l'user
	 */
	public String getMailUser() {
		return mailUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return adresse de l'user
	 */
	public String getAdrUser() {
		return adrUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return code postal de l'user
	 */
	public String getCpUser() {
		return cpUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return ville de l'user
	 */
	public String getVilleUser() {
		return villeUser;
	}

	/**
	 * accesseur de récupération de donnée
	 * @return mot de passe de l'user
	 */
	public String getMdpUser() {
		return mdpUser;
	}
}
