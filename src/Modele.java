
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

public class Modele {

	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement ps;

	public static void connexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/restaurant", "root", "");
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
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
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
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}
	
	public static ArrayList<Alcool> getLesAlcools(){
		ArrayList<Alcool> lesAlcools = new ArrayList<Alcool>();
		try{
			String sql = "SELECT * FROM Alcool";
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
				
				lesAlcools.add(new Alcool(idA, nomA, prixA, qteA, degreA));
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lesAlcools;
	}
	
	public static int getNbAlcools(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from Alcool";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}

	
	public static ArrayList<Soft> getLesSofts(){
		ArrayList<Soft> lesSofts = new ArrayList<Soft>();
		try{
			String sql = "SELECT * FROM Soft";
			rs = st.executeQuery(sql);
			
			int idS;
			String nomS;
			float prixS;
			String qteS;
			float degreS;
			
			while(rs.next()){
				idS = rs.getInt("idSoft");
				nomS = rs.getString("nomSoft");
				prixS = rs.getFloat("prixSoft");
				qteS = rs.getString("qteSoft");
				degreS = rs.getFloat("tauxSucre");
				
				lesSofts.add(new Soft(idS, nomS, prixS, qteS, degreS));
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lesSofts;
	}
	
	public static int getNbSofts(){
		int nb = 0;
		try{
			String sql = "SELECT count(*) as nb from Soft";
			rs = st.executeQuery(sql);
			
			rs.next();
			nb = rs.getInt("nb");
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
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
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
		}
		catch(SQLException erreur){
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
		}
		return nb;
	}

	public static ArrayList<Menu> getLesMenus(){
		ArrayList<Menu> lesMenus = new ArrayList<Menu>();
		try{
			String sql = "SELECT * FROM Menu";
			rs = st.executeQuery(sql);
			
			int idM;
			String nomM;
			float prixM;
			int idD;
			int idP;
			int idS;
			int idA;
			
			Dessert dessert;
			Plat plat;
			Soft soft;
			Alcool alcool;
			
			while(rs.next()){
				idM = rs.getInt("idMenu");
				idD = rs.getInt("idDessert");
				idP = rs.getInt("idPlat");
				idS = rs.getInt("idSoft");
				idA = rs.getInt("idAlcool");
				
				dessert = Modele.rechercherDessert(idD);
				plat = Modele.rechercherPlat(idP);
				soft = Modele.rechercherSoft(idS);
				alcool = Modele.rechercherAlcool(idA);
				
				lesMenus.add(new Menu(idM, dessert, plat, soft, alcool));
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
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
			Date date;
			
			while(rs.next()){
				numC = rs.getInt("numCommande");
				nbC = rs.getInt("nbrCouverts");
				date = (Date) rs.getObject("dateCommande");
				
				lesCommandes.add(new Commande(numC, nbC, date));
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
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
			rs = ps.executeQuery();
			
			int idD;
			String nomD;
			float prixD;
			
			rs.next();
			idD = rs.getInt("idDessert");
			nomD = rs.getString("nomD");
			prixD = rs.getFloat("prixD");
			
			ArrayList<Dessert> lesDesserts = Modele.getLesDesserts();
			int nbDesserts = Modele.getNbDesserts();
			int i = 0;
			while(i < nbDesserts && lesDesserts.get(i).getIdDessert() != idD) {
				i = i + 1;
			}
			if(i < nbDesserts) {
				leDessert = lesDesserts.get(i);
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return leDessert;
	}
	
	public static Plat rechercherPlat(int unId) {
		Plat lePlat = null;
		try{
			ps = connexion.prepareStatement("SELECT * FROM Plat WHERE idPlat = ?");
			ps.setInt(1, unId);
			rs = ps.executeQuery();
			
			int idP;
			String nomP;
			float prixP;
			
			rs.next();
			idP = rs.getInt("idPlat");
			nomP = rs.getString("nomP");
			prixP = rs.getFloat("prixP");
			
			ArrayList<Plat> lesPlats = Modele.getLesPlats();
			int nbPlats = Modele.getNbPlats();
			int i = 0;
			while(i < nbPlats && lesPlats.get(i).getIdPlat() != idP) {
				i = i + 1;
			}
			if(i < nbPlats) {
				lePlat = lesPlats.get(i);
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lePlat;
	}
	
	public static Alcool rechercherAlcool(int unId) {
		Alcool lAlcool = null;
		try{
			ps = connexion.prepareStatement("SELECT * FROM Alcool WHERE idAlcool = ?");
			ps.setInt(1, unId);
			rs = ps.executeQuery();
			
			int idA;
			String nomA;
			float prixA;
			String qteA;
			float degreA;
			
			rs.next();
			idA = rs.getInt("idAlcool");
			nomA = rs.getString("nomAlcool");
			prixA = rs.getFloat("prixAlcool");
			qteA = rs.getString("qteAlcool");
			degreA = rs.getFloat("degreAlcool");
			
			ArrayList<Alcool> lesAlcools = Modele.getLesAlcools();
			int nbAlcools = Modele.getNbAlcools();
			int i = 0;
			while(i < nbAlcools && lesAlcools.get(i).getIdBoisson() != idA) {
				i = i + 1;
			}
			if(i < nbAlcools) {
				lAlcool = lesAlcools.get(i);
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return lAlcool;
	}
	
	public static Soft rechercherSoft(int unId) {
		Soft leSoft = null;
		try{
			ps = connexion.prepareStatement("SELECT * FROM Soft WHERE idSoft = ?");
			ps.setInt(1, unId);
			rs = ps.executeQuery();
			
			int idS;
			String nomS;
			float prixS;
			String qteS;
			float tauxS;
			
			rs.next();
			idS = rs.getInt("idSoft");
			nomS = rs.getString("nomSoft");
			prixS = rs.getFloat("prixSoft");
			qteS = rs.getString("qteSoft");
			tauxS = rs.getFloat("tauxSucre");
			
			ArrayList<Soft> lesSofts = Modele.getLesSofts();
			int nbSofts = Modele.getNbSofts();
			int i = 0;
			while(i < nbSofts && lesSofts.get(i).getIdBoisson() != idS) {
				i = i + 1;
			}
			if(i < nbSofts) {
				leSoft = lesSofts.get(i);
			}
			
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
		}
		return leSoft;
	}
	
	public static int getMaxIdPlat(){
		int id = 0;
		
		try{
			String sql = "SELECT MAX(idPlat) AS id FROM Plat";
			rs = st.executeQuery(sql);
			
			rs.next();
			id = rs.getInt("id") + 1;
		}
		catch(SQLException e){
			System.out.println("Erreur SQL");
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
			System.out.println("Erreur SQL Plat");
		}
	}
}
