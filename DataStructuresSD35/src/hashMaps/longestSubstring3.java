package hashMaps;

import java.util.HashMap;

public class longestSubstring3 {

	public static void main(String[] args) {
		longestSubstring3 test = new longestSubstring3();
		System.out.println(test.lengthOfLongestSubstring("au"));
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> visitedCharacters = new HashMap<>();
		int maxLength = 0;		
		for (int right = 0, left = 0; right < s.length(); right++) {
			char currentCharacter = s.charAt(right);
			if(visitedCharacters.containsKey(currentCharacter) && visitedCharacters.get(currentCharacter) >= left) {
				left = visitedCharacters.get(currentCharacter) + 1;
		}
			maxLength = Math.max(maxLength, right - left + 1);
			visitedCharacters.put(currentCharacter, right);
		}
		return maxLength;
	}
}