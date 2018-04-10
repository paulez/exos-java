import static org.junit.Assert.*;

import org.junit.Test;


public class PaulExoTest {

	@Test
	public void testUnique() {
		PaulExo exo = new PaulExo();
		assertEquals(false, exo.allUniqueCharacters("toto"));
		assertEquals(true, exo.allUniqueCharacters("caniro"));
	}

}
