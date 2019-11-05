import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AlcoolTest {

	private Alcool unAlcool;

	@Before
	public void setUp() throws Exception {
		unAlcool = new Alcool(1, "passoa", (float) 4.5, "20cl", (float) 15.0);
	}

	@Test
	public void testToXML() {
		Assert.assertNotNull(unAlcool.toXML());
	}

}
