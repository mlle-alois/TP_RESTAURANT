import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlatTest {

	private Plat unPlat;

	@Before
	public void setUp() throws Exception {
		unPlat = new Plat(1, "pâtes", (float) 8.5);
	}

	@Test
	public void testToXML() {
		Assert.assertNotNull(unPlat.toXML());
	}

}
