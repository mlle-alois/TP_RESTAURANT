import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SoftTest {

	private Soft unSoft;

	@Before
	public void setUp() throws Exception {
		unSoft = new Soft(1, "coca", (float) 3.5, "33cl", (float) 35.0);
	}

	@Test
	void testToXML() {
		Assert.assertNotNull(unSoft.toXML());
	}

}
