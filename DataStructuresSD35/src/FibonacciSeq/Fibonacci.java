package FibonacciSeq;


// Given fibonacci sequence, determine first fib number which is > 4000000

public class Fibonacci {

	public static void main(String[] args) {
		
	}
	
	public static int Fib(int N) {
		int num1 = 0, num2 = 1, num3 = 0;
		int count = 0; 
		
		while (count < N) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			count++;
		}
		return num3;
	}
	

}
