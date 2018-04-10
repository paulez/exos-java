package exos;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaulHashMapTest {

	@Test
	public void testPut() {
		PaulHashMap<Integer, String> hash = new PaulHashMap<Integer, String>();
		hash.put(1, "un");
		assertEquals("un", hash.get(1));
	}

	@Test
	public void testGet() {
		PaulHashMap<String, String> hash = new PaulHashMap<String, String>();
		hash.put("deux", "three");
		hash.put("deux", "two");
		assertEquals(null, hash.get("trois"));
		assertEquals("two", hash.get("deux"));
	}

}
