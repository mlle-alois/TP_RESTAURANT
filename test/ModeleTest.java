import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ModeleTest {

	private Utilisateur user;
	
	@Before
	public void setUp() throws Exception {
		user = new Utilisateur(1, "Zimmermann", "Aloïs", "alois.zimmermann45@gmail.com", "4 la motte", "45300", "courcy aux loges", "123456");
		//Modele = static -> on y accède sans l'instancier par le nom de la classe !
		Modele.connexion();
	}

	@After
	public void tearDown() throws Exception {
		Modele.deconnexion();
	}

	@Test
	public void testConnecterUser() {
		Assert.assertTrue("Mauvais identifiants", Modele.connecterUser(user.getMailUser(), user.getMdpUser()));
		Assert.assertFalse("Identifiants corrects ??", Modele.connecterUser(user.getMailUser() + "x", user.getMdpUser()));
	}
	
	@Test
	public void testGetNbDesserts() {
		Assert.assertEquals("Nombre de desserts incorrect", 3, Modele.getNbDesserts());
	}
	
	@Test
	public void testLesDesserts(){
		Assert.assertEquals("Nombre de desserts dans la liste incorrect", 3, Modele.getLesDesserts().size());
	}
	
	@Test
	public void testGetNbPlats() {
		Assert.assertEquals("Nombre de plats incorrect", 3, Modele.getNbPlats());
	}
	
	@Test
	public void testLesPlats(){
		Assert.assertEquals("Nombre de plats dans la liste incorrect", 3, Modele.getLesPlats().size());
	}
	
	@Test
	public void testGetNbBoissons() {
		Assert.assertEquals("Nombre de boissons incorrect", 6, Modele.getNbBoissons());
	}
	
	@Test
	public void testLesBoissons(){
		Assert.assertEquals("Nombre de boissons dans la liste incorrect", 6, Modele.getLesBoissons().size());
	}
	
	@Test
	public void testGetNbMenus() {
		Assert.assertEquals("Nombre de menus incorrect", 3, Modele.getNbMenus());
	}
	
	@Test
	public void testLesMenus(){
		Assert.assertEquals("Nombre de menus dans la liste incorrect", 1, Modele.getLesMenus().size());
	}
	
	@Test
	public void testGetNbCommandes() {
		Assert.assertEquals("Nombre de commandes incorrect", 0, Modele.getNbCommandes());
	}
	
	@Test
	public void testLesCommandes(){
		Assert.assertEquals("Nombre de commandes dans la liste incorrect", 0, Modele.getLesCommandes().size());
	}
	
	@Test
	public void testIdMaxPlat(){
		Assert.assertEquals("Id maximum incorrect", 3, Modele.getMaxIdPlat());
	}
	
	@Test
	public void testGetNbMenusDate(){
		Assert.assertEquals("Nb menus commandés incorrect", 8, Modele.getNbMenus(new Date(LocalDate.parse("2019-11-12"))));
	}
	

}
