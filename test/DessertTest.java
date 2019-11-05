import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DessertTest {

	private Dessert unDessert;

	@Before
	public void setUp() throws Exception {
		unDessert = new Dessert(1, "gateau", (float) 2.5);
	}

	@Test
	public void testToXML() {
		Assert.assertNotNull(unDessert.toXML());
	}

}
