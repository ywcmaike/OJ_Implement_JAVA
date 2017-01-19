package directOffer;

public class Fibonacci {
	public int fibonacciNFirst(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		} else {
			return fibonacciNFirst(n - 1) + fibonacciNFirst(n - 2);
		}
		 
    }
	public int fibonacciNSecond(int n) {
		int fibOne = 0;
		int fibTwo = 1;
		if (n <= 0) {
			return fibOne;
		}
		if (n == 1) {
			return fibTwo;
		} 
		int i = 2;
		int fibN = 0;
		while (i <= n) {
			fibN = fibOne + fibTwo;
			fibTwo = fibOne;
			fibOne = fibN;
			i++;
		}
		return fibN;
		
		
    }
//	public int fibonacciNThird(int n) {
//		
//    }
}
