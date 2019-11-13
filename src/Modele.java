
/**
 * @author azimmermann
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class Modele {

	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static ResultSet rs2;
	private static PreparedStatement ps;

	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2020zimmermann", "azimmermann", "123456");
			st = connexion.createStatement();
		}
		catch(ClassNotFoundException erreur) {
			System.out.println("Driver non chargé !" + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
	}

	public static void deconnexion(){
		try {
			connexion.close();
		} catch (SQLException erreur) {
			System.out.println("La déconnexion à la base de données a échouée ou Erreur SQL…" + erreur);
		}
	}


	public static boolean connecterUser(String mail, String mdp){
		boolean bool = false;
		try {
			ps = connexion.prepareStatement("SELECT count(*) as nb FROM utilisateur WHERE mailUser = ? AND mdpUser = ?");
			ps.setString(1, mail);
			ps.setString(2, mdp);
			
			rs = ps.executeQuery();
			
			rs.next();
			if(rs.getInt("nb") == 1){
				bool = true;
			}

			rs.close();
		}
		catch (SQLException erreur) {
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		
		return bool;
	}
	
	public static ArrayList<Plat> getLesPlats(){
		ArrayList<Plat> lesPlats = new ArrayList<Plat>();
		try{
			String sql = "SELECT * FROM Plat";
			rs = st.executeQuery(sql);
			
			int idP;
			String nomP;
			float prixP;
			
			while(rs.next()){
				idP = rs.getInt("idPlat");
				nomP = rs.getString("nomP");
				prixP = rs.getFloat("prixP");
				
				lesPlats.add(new Plat(idP, nomP, prixP));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lesPlats;
	}
	
	public static int getNbPlats(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from PLAT";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}
	
	public static ArrayList<Dessert> getLesDesserts(){
		ArrayList<Dessert> lesDesserts = new ArrayList<Dessert>();
		try{
			String sql = "SELECT * FROM Dessert";
			rs = st.executeQuery(sql);
			
			int idD;
			String nomD;
			float prixD;
			
			while(rs.next()){
				idD = rs.getInt("idDessert");
				nomD = rs.getString("nomD");
				prixD = rs.getFloat("prixD");
				
				lesDesserts.add(new Dessert(idD, nomD, prixD));
			}
			rs.close();
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL dessert");
		}
		return lesDesserts;
	}
	
	public static int getNbDesserts(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from DESSERT";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}


	public static ArrayList<Boisson> getLesBoissons(){
		ArrayList<Boisson> lesBoissons = new ArrayList<Boisson>();
		try{
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
				
				lesBoissons.add(new Soft(idS, nomS, prixS, qteS, tauxS));
			}
			
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
				
				lesBoissons.add(new Alcool(idA, nomA, prixA, qteA, degreA));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL get boisson");
		}
		return lesBoissons;
	}
	
	public static int getNbBoissons(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from BOISSONS";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}

	public static ArrayList<Menu> getLesMenus(){
		ArrayList<Menu> lesMenus = new ArrayList<Menu>();
		try{
			String sql = "select * from menu";
			rs = st.executeQuery(sql);

			int idM;
			int idD;
			int idP;
			int idB;
			
			Dessert dessert;
			Plat plat;
			Soft soft = new Soft(1, "x", (float) 1, "15", 12);
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
				lesMenus.add(new Menu(idM, dessert, plat, soft, alcool));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL get Menu");
		}
		return lesMenus;
	}
	
	public static int getNbMenus(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from Menu";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}

	public static ArrayList<Commande> getLesCommandes(){
		ArrayList<Commande> lesCommandes = new ArrayList<Commande>();
		try{
			String sql = "SELECT * FROM Commande";
			rs = st.executeQuery(sql);
			
			int numC;
			int nbC;
			String date;
			
			while(rs.next()){
				numC = rs.getInt("numCommande");
				nbC = rs.getInt("nbrCouverts");
				date = rs.getString("dateCommande");
				
				date = date.substring(6,10) + "-" + date.substring(3,5) + "-" + date.substring(0,2);

				Date d = new Date(LocalDate.parse(date));
				lesCommandes.add(new Commande(numC, nbC, d));
			}

			rs.close();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL commande");
		}
		return lesCommandes;
	}
	
	public static int getNbCommandes(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from Commande";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
			rs.close();
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}
	
	public static Dessert rechercherDessert(int unId) {
		Dessert leDessert = null;
		try{
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
	
	public static Plat rechercherPlat(int unId) {
		Plat lePlat = null;
		try{
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
	
	public static Boisson rechercherBoisson(int unId) {
		Boisson laBoisson = null;
		try{
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
	
	public static int getMaxIdPlat(){
		int id = 0;
		
		try{
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
	
	public static void ajouterPlat(String nom, float prix, ArrayList<Plat> lesPlats){
		try{
			int id = Modele.getMaxIdPlat();
			
			ps = connexion.prepareStatement("INSERT INTO Plat VALUES(?,?,?);");
			ps.setInt(1, id);
			ps.setString(2, nom);
			ps.setFloat(3, prix);
			ps.executeUpdate();
			
			lesPlats.add(new Plat(id, nom, prix));

		}
		catch(SQLException e){
			System.out.println("Erreur SQL plat");
		}
	}
	
	public static void supprimerPlat(int id){
		try{
			
			ps = connexion.prepareStatement("DELETE FROM PLAT WHERE idPlat = ?;");
			ps.setInt(1, id);
			ps.executeUpdate();

		}
		catch(SQLException e){
			System.out.println("Erreur SQL supprimer plat");
		}
	}
	
	public static int getMaxIdMenu(){
		int id = 0;
		
		try{
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
	
	public static void ajouterMenu(int idDessert, int idPlat, int idSoft, int idAlcool, int numCommande){
		try{
			int id = Modele.getMaxIdMenu();
			
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

			Modele.ajouterPasser(id, numCommande);
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Menu");
		}
	}
	
	public static void ajouterPasser(int id, int numCommande){
		try{
			
			ps = connexion.prepareStatement("INSERT INTO Passer VALUES(?,?);");
			ps.setInt(1, id);
			ps.setInt(2, numCommande);
			ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Passer");
		}
	}
	
	public static int getMaxIdCommande(){
		int id = 0;
		
		try{
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
	
	public static int ajouterCommande(int nbCouverts, ArrayList<Commande> lesCommandes){
		int id = 0;
		try{
			id = Modele.getMaxIdCommande();
			Date date = new Date (LocalDate.now());
			String d = date.getDateFrancais();
			
			ps = connexion.prepareStatement("INSERT INTO Commande VALUES(?,?,?);");
			ps.setInt(1, id);
			ps.setInt(2, nbCouverts);
			ps.setString(3, d);
			ps.executeUpdate();
			
			lesCommandes.add(new Commande(id, nbCouverts, date));
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL Commande");
		}
		return id;
	}
	
	public static int getNbMenus(Date date) {
		int nb = 0;
		try{
			String d = date.getDateFrancais();
			
			ps = connexion.prepareStatement("SELECT count(idMenu) as nb FROM Menu M, Commande C, Passer P WHERE M.idMenu = P.idMenu And C.numCommande = p.numCommande AND dateCommande = ?");
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
