package Palindrome;

public class LargestPalindrome {

	public static void main(String[] args) {
		LargestPalindrome pd = new LargestPalindrome();
		String s1 = "tacocat";
		String s2 = "annaasdsdstacocat";
		String s3 = "waffle";

		System.out.println(pd.longestPalindrome(s1));
		System.out.println(pd.longestPalindrome(s2));
//		System.out.println(pd.palindrome(s3));
		

	}

	// Function that takes in a string and outputs the longest contiguous palidrome
	// "annalimousineenisuomilanna"
	// "anna" > potential palindrome
	// null check, same check, size 1 check

	// annatacocatanna

	// break statement is
	// compare a result string that is being built to result.subString(0,
	// result.length()/2);
	public String longestPalindrome(String str) {
		char[] charArray = str.toCharArray();
		
		return "";
	}

	public boolean isPalindrome(String str) {
		StringBuffer buf = new StringBuffer(str);
		return str.equals(buf.reverse().toString()) ? true : false;
	}
}
