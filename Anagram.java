/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String preProStr1 = removeSpaces(preProcess(str1));
		String preProStr2 = removeSpaces(preProcess(str2));
		boolean isAnagram = true;
		for (int i = 0; i < preProStr2.length() && isAnagram; i++) {
			char ch = preProStr2.charAt(i);
			if (preProStr1.indexOf(ch) == -1) isAnagram = false;
		}

		return isAnagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "what no way"
	public static String preProcess(String str) {
		String finishStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') finishStr += (char) (str.charAt(i) + 32);
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') finishStr += (str.charAt(i));
			else if (str.charAt(i) == ' ') finishStr += str.charAt(i);
		}
		return finishStr;
	} 
	   
	public static String removeSpaces(String str) {
		String finishStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') finishStr += str.charAt(i);
		}
		return finishStr;
	} 
	
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String randomAnagram = "";
		String preProcressStr = removeSpaces(preProcess(str));

		while (preProcressStr.length() > 0) {
			int randomNum = (int) (preProcressStr.length() * Math.random());
			randomAnagram += preProcressStr.charAt(randomNum);
			preProcressStr = preProcressStr.substring(0, randomNum) + preProcressStr.substring(randomNum + 1);
		}
		return randomAnagram;
	}
}
