package Strings;

//Given a string, does "xyz" appear in the middle of the string? 
//		To define middle, we'll say that the number of chars to the left and 
//		right of the "xyz" must differ by at most one. 
//		This problem is harder than it looks.
public class xyzMiddleCodingBat {

	public static void main(String[] args) {

		xyzMiddleCodingBat test = new xyzMiddleCodingBat();

		String test1 = "AxyzBB";
		String test2 = "AxyzBBBB";
		String test3 = "1x345xyz1234";
		String test4 = "xyzxyzxyzBxyzxyz";

//		System.out.println(test.xyzMiddle(test4));

		
	}

	public boolean xyzMiddle(String str) {
		if (str.length() < 5) {
			return false;
		}
		char[] arr = str.toCharArray();
		int front = 0;
		int back = 0;

		for (int i = 0; i < str.length() - 3; i++) {
			if (arr[i] == 'x' && arr[i + 1] == 'y' && arr[i + 2] == 'z') {
				front = i;
//				 System.out.println(front);
				back = arr.length - (i + 3);
//				 System.out.println(back);
			}
			if (back > 0 && front > 0 && Math.abs(back - front) <= 1) {
				return true;
			}
		}
		return false;
	}
}
