package Strings;

import java.util.HashSet;
import java.util.Set;

public class longestPalindrome409 {

	public static void main(String[] args) {
		String test = "abccccdd";
		longestPalindrome409 tester = new longestPalindrome409();
		System.out.println("Expected: 7");
		System.out.println("Longest palindrome length: " + tester.longestPalindrome(test));
	}

	public int longestPalindrome(String s) {

		Set<Character> hs = new HashSet<>();

		int count = 0;

		for (char ltr : s.toCharArray()) {
			if (hs.contains(ltr)) {
				count++;
				hs.remove(ltr);
			} else {
				hs.add(ltr);
			}
		}
		return hs.isEmpty() ? count * 2 : count * 2 + 1;
	}
}
