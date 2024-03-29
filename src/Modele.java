import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 * 
 * @author azimmermann
 *
 */
public class Modele {

	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSet rs2;
	private static PreparedStatement ps;

	/**
	 * Connexion � la bdd 2020zimmermann
	 */
	public static void connexion(){
		try {
			//r�cup�ration du driver
			Class.forName("com.mysql.jdbc.Driver");
			//connexion � la bdd
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2020zimmermann", "azimmermann", "123456");
			//cr�ation du statement
			st = connexion.createStatement();
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non charg� !" + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
	}

	/**
	 * d�connexion de la bdd
	 */
	public static void deconnexion(){
		try {
			//cl�ture de la connexion
			connexion.close();
		} catch (SQLException erreur) {
			System.out.println("La d�connexion � la base de donn�es a �chou�e ou Erreur SQL�" + erreur);
		}
	}

	/**
	 * Connection de l'utilisateur
	 * @param mail
	 * @param mdp
	 * @return bool�en de la r�ussite ou de l'�chec de la connexion
	 */
	public static boolean connecterUser(String mail, String mdp){
		boolean bool = false;
		try {
			//on r�cup�re le nombre d'utilisateurs correspondant aux identifiants
			ps = connexion.prepareStatement("SELECT count(*) as nb FROM utilisateur WHERE mailUser = ? AND mdpUser = ?");
			ps.setString(1, mail);
			ps.setString(2, mdp);
			
			rs = ps.executeQuery();
			
			rs.next();
			//si il y en a un la connexion est r�ussie
			if(rs.getInt("nb") == 1){
				bool = true;
			}

			rs.close();
		}
		catch (SQLException erreur) {
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		
		return bool;
	}
	
	/**
	 * r�cup�ration des plats de la bdd
	 * @return liste des plats de la bdd
	 */
	public static ArrayList<Plat> getLesPlats(){
		ArrayList<Plat> lesPlats = new ArrayList<Plat>();
		try{
			//r�cup�ration des plats de la bdd
			String sql = "SELECT * FROM Plat";
			rs = st.executeQuery(sql);
			
			int idP;
			String nomP;
			float prixP;
			
			while(rs.next()){
				idP = rs.getInt("idPlat");
				nomP = rs.getString("nomP");
				prixP = rs.getFloat("prixP");
				
				//ajout du plat � la liste
				lesPlats.add(new Plat(idP, nomP, prixP));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lesPlats;
	}
	
	/**
	 * r�cup�ration du nombre de plats de la bdd
	 * @return nombre de plats dans la bdd
	 */
	public static int getNbPlats(){
		int nb = 0;
		try{
			//compte du nombre des plats de la bdd
			String sql = "SELECT count(*) as nb from PLAT";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		return nb;
	}
	
	/**
	 * r�cup�ration des desserts de la bdd
	 * @return liste des desserts de la bdd
	 */
	public static ArrayList<Dessert> getLesDesserts(){
		ArrayList<Dessert> lesDesserts = new ArrayList<Dessert>();
		try{
			//r�cup�ration des desserts de la bdd
			String sql = "SELECT * FROM Dessert";
			rs = st.executeQuery(sql);
			
			int idD;
			String nomD;
			float prixD;
			
			while(rs.next()){
				idD = rs.getInt("idDessert");
				nomD = rs.getString("nomD");
				prixD = rs.getFloat("prixD");
				
				//ajout des desserts � la liste
				lesDesserts.add(new Dessert(idD, nomD, prixD));
			}
			rs.close();
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL dessert");
		}
		return lesDesserts;
	}
	
	/**
	 * r�cup�ration du nombre de desserts dans la bdd
	 * @return nombre de desserts dans la bdd
	 */
	public static int getNbDesserts(){
		int nb = 0;
		try{
			//compte du nombre de desserts de la bdd
			String sql = "SELECT count(*) as nb from DESSERT";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		return nb;
	}

	/**
	 * r�cup�ration des boissons de la bdd
	 * @return liste des boissons de la bdd
	 */
	public static ArrayList<Boisson> getLesBoissons(){
		ArrayList<Boisson> lesBoissons = new ArrayList<Boisson>();
		try{
			//r�cup�ration des softs
			String sql = "SELECT * FROM Soft";
			rs = st.executeQuery(sql);
			
			int idS;
			String nomS;
			float prixS;
			String qteS;
			float tauxS;
			
			while(rs.next()){
				idS = rs.getInt("idSoft");
				nomS = rs.getString("nomSoft");
				prixS = rs.getFloat("prixSoft");
				qteS = rs.getString("qteSoft");
				tauxS = rs.getFloat("tauxSucre");
				
				//ajout des softs � la liste
				lesBoissons.add(new Soft(idS, nomS, prixS, qteS, tauxS));
			}
			
			//r�cup�ration des alcools
			sql = "SELECT * FROM Alcool";
			rs = st.executeQuery(sql);
			
			int idA;
			String nomA;
			float prixA;
			String qteA;
			float degreA;
			
			while(rs.next()){
				idA = rs.getInt("idAlcool");
				nomA = rs.getString("nomAlcool");
				prixA = rs.getFloat("prixAlcool");
				qteA = rs.getString("qteAlcool");
				degreA = rs.getFloat("degreAlcool");
				
				//ajout des alcools � la liste
				lesBoissons.add(new Alcool(idA, nomA, prixA, qteA, degreA));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL get boisson");
		}
		return lesBoissons;
	}
	
	/**
	 * r�cup�ration du nombre de boissons dans la bdd
	 * @return nombre de boissons dans la bdd
	 */
	public static int getNbBoissons(){
		int nb = 0;
		try{
			//compte des boissons de la bdd
			String sql = "SELECT count(*) as nb from BOISSONS";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		return nb;
	}

	/**
	 * r�cup�ration des menus de la bdd
	 * @return liste des menus de la bdd
	 */
	public static ArrayList<Menu> getLesMenus(){
		ArrayList<Menu> lesMenus = new ArrayList<Menu>();
		try{
			//r�cup�ration des menus de la bdd
			String sql = "select * from menu";
			rs = st.executeQuery(sql);

			int idM;
			int idD;
			int idP;
			int idB;
			
			Dessert dessert;
			Plat plat;
			Soft soft = new Soft(1, "Coca", (float) 3.50, "33cl", 35);
			Alcool alcool = null;
			
			while(rs.next()){
				idM = rs.getInt("idMenu");
				idD = rs.getInt("idDessert");
				idP = rs.getInt("idPlat");
				idB = rs.getInt("idBoisson");

				dessert = Modele.rechercherDessert(idD);
				plat = Modele.rechercherPlat(idP);
				/*if(Modele.rechercherBoisson(idB) instanceof Soft){
					soft = (Soft) Modele.rechercherBoisson(idB);
					alcool = null;
				}
				else{
					alcool = (Alcool) Modele.rechercherBoisson(idB);
					soft = null;
				}*/
				
				//ajout des menus � la liste
				lesMenus.add(new Menu(idM, dessert, plat, soft, alcool));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL get Menu");
		}
		return lesMenus;
	}
	
	/**
	 * r�cup�ration du nombre de menus dans la bdd
	 * @return nombre de menus dans la bdd
	 */
	public static int getNbMenus(){
		int nb = 0;
		try{
			//compte des menus de la bdd
			String sql = "SELECT count(*) as nb from Menu";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		return nb;
	}

	/**
	 * r�cup�ration des commandes de la bdd
	 * @return liste des commandes de la bdd
	 */
	public static ArrayList<Commande> getLesCommandes(){
		ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
		try{
			//r�cup�ration des commandes de la bdd
			String sql = "SELECT * FROM Commande";
			rs = st.executeQuery(sql);
			
			int numC;
			int nbC;
			String date;
			
			while(rs.next()){
				numC = rs.getInt("numCommande");
				nbC = rs.getInt("nbrCouverts");
				date = rs.getString("dateCommande");
				
				//conversion de la date en fran�ais en date en anglais
				date = date.substring(6,10) + "-" + date.substring(3,5) + "-" + date.substring(0,2);
				Date d = new Date(LocalDate.parse(date));
				
				//ajout des commandes � la liste
				lesCommandes.add(new Commande(numC, nbC, d));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL commande");
		}
		return lesCommandes;
	}
	
	/**
	 * r�cup�ration du nombre de commandes dans la bdd
	 * @return nombre de commandes dans la bdd 
	 */
	public static int getNbCommandes(){
		int nb = 0;
		try{
			//compte des commandes de la bdd
			String sql = "SELECT count(*) as nb from Commande";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);
		}
		return nb;
	}
	
	/**
	 * rechercher un dessert selon un id
	 * @param unId
	 * @return le dessert correspondant � l'id
	 */
	public static Dessert rechercherDessert(int unId) {
		Dessert leDessert = null;
		try{
			//recherche d'un dessert pour un id
			ps = connexion.prepareStatement("SELECT * FROM Dessert WHERE idDessert = ?");
			ps.setInt(1, unId);
			rs2 = ps.executeQuery();
			
			int idD;
			String nomD;
			float prixD;
			
			rs2.next();
			idD = rs2.getInt("idDessert");
			nomD = rs2.getString("nomD");
			prixD = rs2.getFloat("prixD");
			
			leDessert = new Dessert(idD, nomD, prixD);
			rs2.close();
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL dessert");
		}
		return leDessert;
	}
	
	/**
	 * rechercher un plat selon un id
	 * @param unId
	 * @return un plat correspondant � l'id
	 */
	public static Plat rechercherPlat(int unId) {
		Plat lePlat = null;
		try{
			//recherche d'un plat pour un id
			ps = connexion.prepareStatement("SELECT * FROM Plat WHERE idPlat = ?");
			ps.setInt(1, unId);
			rs2 = ps.executeQuery();

			int idD;
			String nomD;
			float prixD;
			
			rs2.next();
			idD = rs2.getInt("idPlat");
			nomD = rs2.getString("nomP");
			prixD = rs2.getFloat("prixP");
			
			lePlat = new Plat(idD, nomD, prixD);
			rs2.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL plat");
		}
		return lePlat;
	}
	
	/**
	 * rechercher une boisson selon un id
	 * @param unId
	 * @return la boisson correspondant � l'id
	 */
	public static Boisson rechercherBoisson(int unId) {
		Boisson laBoisson = null;
		try{
			//recherche d'une boisson pour un id
			ps = connexion.prepareStatement("SELECT * FROM Boissons WHERE idBoisson = ?");
			ps.setInt(1, unId);
			rs2 = ps.executeQuery();
			
			int idB;
			
			rs2.next();
			idB = rs2.getInt("idBoisson");
			
			ArrayList<Boisson> lesBoissons = Modele.getLesBoissons();
			int nbBoissons = Modele.getNbBoissons();
			int i = 0;
			while(i < nbBoissons && lesBoissons.get(i).getIdBoisson() != idB) {
				i = i + 1;
			}
			if(i < nbBoissons) {
				laBoisson = lesBoissons.get(i);
			}

			rs2.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL boisson");
		}
		return laBoisson;
	}
	
	/**
	 * r�cup�ration de l'id maximal + 1 dans la base de donn�es (pour ajouter une valeur)
	 * @return id maximal + 1
	 */
	public static int getMaxIdPlat(){
		int id = 0;
		
		try{
			//r�cup�ration de l'id max + 1 des plats dans la bdd
			String sql = "SELECT MAX(idPlat) AS id FROM Plat";
			rs = st.executeQuery(sql);
			
			rs.next();
			id = rs.getInt("id") + 1;
			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL id plat");
		}
		return id;
	}
	
	/**
	 * ajouter un plat dans la bdd
	 * @param nom
	 * @param prix
	 * @param lesPlats
	 */
	public static void ajouterPlat(String nom, float prix, ArrayList<Plat> lesPlats){
		try{
			int id = Modele.getMaxIdPlat();
			//ajout d'un plat dans la bdd
			ps = connexion.prepareStatement("INSERT INTO Plat VALUES(?,?,?);");
			ps.setInt(1, id);
			ps.setString(2, nom);
			ps.setFloat(3, prix);
			ps.executeUpdate();
			
			//on ajoute le plat �galement � la liste
			lesPlats.add(new Plat(id, nom, prix));

		}
		catch(SQLException e){
			System.out.println("Erreur SQL plat");
		}
	}
	
	/**
	 * supprimer le plat ayant l'id �gal de la bdd
	 * @param id
	 */
	public static void supprimerPlat(int id){
		try{
			//suppression d'un plat selon un id
			ps = connexion.prepareStatement("DELETE FROM PLAT WHERE idPlat = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();

		}
		catch(SQLException e){
			System.out.println("Erreur SQL supprimer plat");
		}
	}

	
	/**
	 * r�cup�ration de l'id maximal + 1 dans la base de donn�es (pour ajouter une valeur)
	 * @return id maximal + 1
	 */
	public static int getMaxIdMenu(){
		int id = 0;
		
		try{
			//r�cup�ration de l'id max des menus de la bdd + 1
			String sql = "SELECT MAX(idMenu) AS id FROM Menu";
			rs = st.executeQuery(sql);
			
			rs.next();
			id = rs.getInt("id") + 1;
			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL id menu");
		}
		return id;
	}
	
	/**
	 * ajouter un menu dans la bdd
	 * @param idDessert
	 * @param idPlat
	 * @param idSoft
	 * @param idAlcool
	 * @param numCommande
	 */
	public static void ajouterMenu(int idDessert, int idPlat, int idSoft, int idAlcool, int numCommande){
		try{
			int id = Modele.getMaxIdMenu();
			//ajout d'un menu � la bdd
			ps = connexion.prepareStatement("INSERT INTO Menu VALUES(?,?,?,?);");
			ps.setInt(1, id);
			ps.setInt(2, idDessert);
			ps.setInt(3, idPlat);
			if(idSoft != 0){
				ps.setInt(4, idSoft);
			}
			else{
				ps.setInt(4, idAlcool);
			}
			ps.executeUpdate();

			//ajout du lien avec sa commande
			Modele.ajouterPasser(id, numCommande);
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Menu");
		}
	}
	
	/**
	 * ajouter un lien entre la commande et le menu dans la bdd
	 * @param id du menu
	 * @param numCommande
	 */
	public static void ajouterPasser(int id, int numCommande){
		try{
			//ajout du lien entre un menu et une commande
			ps = connexion.prepareStatement("INSERT INTO Passer VALUES(?,?);");
			ps.setInt(1, id);
			ps.setInt(2, numCommande);
			ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Passer");
		}
	}

	
	/**
	 * r�cup�ration de l'id maximal + 1 dans la base de donn�es (pour ajouter une valeur)
	 * @return id maximal + 1
	 */
	public static int getMaxIdCommande(){
		int id = 0;
		
		try{
			//r�cup�ration de l'id maximal d'une commande  + 1 dans la bdd
			String sql = "SELECT MAX(numCommande) AS id FROM Commande";
			rs = st.executeQuery(sql);
			
			rs.next();
			id = rs.getInt("id") + 1;
			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL id commande");
		}
		return id;
	}
	
	/**
	 * ajouter une commande dans la bdd
	 * @param nbCouverts
	 * @param lesCommandes
	 * @return
	 */
	public static int ajouterCommande(int nbCouverts, ArrayList<Commande> lesCommandes){
		int id = 0;
		try{
			id = Modele.getMaxIdCommande();
			Date date = new Date (LocalDate.now());
			String d = date.getDateFrancais();
			
			//ajout d'une commande dans la bdd
			ps = connexion.prepareStatement("INSERT INTO Commande VALUES(?,?,?);");
			ps.setInt(1, id);
			ps.setInt(2, nbCouverts);
			ps.setString(3, d);
			ps.executeUpdate();
			
			//ajout de la commande  � la liste
			lesCommandes.add(new Commande(id, nbCouverts, date));
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Commande");
		}
		return id;
	}
	
	/**
	 * r�cup�rer le nombre de menus command�s � une date donn�e
	 * @param date
	 * @return nombre de menus command�s � la date donn�e
	 */
	public static int getNbMenus(Date date) {
		int nb = 0;
		try{
			String d = date.getDateFrancais();
			
			//r�cup�ration du nombre de menus command�s � une date
			ps = connexion.prepareStatement("SELECT count(M.idMenu) as nb FROM Menu M, Commande C, Passer P WHERE M.idMenu = P.idMenu And C.numCommande = p.numCommande AND dateCommande = ?");
			ps.setString(1, d);
			rs = ps.executeQuery();
			
			rs.next();
			nb = rs.getInt("nb");
			
			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL nb menus date");
		}
		return nb;
	}
}
