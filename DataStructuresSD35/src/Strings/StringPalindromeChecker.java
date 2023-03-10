package Strings;

// is string a palindrome
// empty string returns true
// return boolean isAPalindrome

public class StringPalindromeChecker {
	
	public static void main(String[] args) {
		
		StringPalindromeChecker checker = new StringPalindromeChecker();
		
		String string1 = "apple";
		String string2 = "anna";
		String string3 = "tacocat";
		
//		System.out.println(checker.isPalindrome(string1));
//		System.out.println(checker.isPalindrome(string2));
//		System.out.println(checker.isPalindrome(string3));
		
		System.out.println(checker.isPalindromeIterative(string1));
		System.out.println(checker.isPalindromeIterative(string2));
		System.out.println(checker.isPalindromeIterative(string3));
	}
	
	public boolean isPalindrome(String string) {
		StringBuffer buffer = new StringBuffer(string);
		if(string.equals(buffer.reverse().toString())) {
			return true;
		}
		return false;
	}
	
	public boolean isPalindromeIterative(String string) {
		String result = "";
		for (int i = string.length()-1; i >= 0; i--) {
			result += string.charAt(i);
		}
		return string.equals(result) ? true : false;
	}

}
