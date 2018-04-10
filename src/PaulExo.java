import java.util.ArrayList;

import exos.PaulHashMap;

public class PaulExo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bonjour !");
		PaulHashMap<String, String> hash = new PaulHashMap<String, String>();
		String toto = "toto";
		String titi = "titi";
		
		hash.put("gros", toto);
		hash.put("petit", titi);
		
		String result = (String) hash.get("gros");
		System.out.format("Ceci est gros: %s", result);
	}
	
	public Boolean allUniqueCharacters(String input) {
		ArrayList<Character> characters = new ArrayList<Character>();
		for (Character element: input.toCharArray()) {
			if (characters.contains(element)) {
				return false;
			} else {
				characters.add(element);
			}
		}
		return true;
	}

}
