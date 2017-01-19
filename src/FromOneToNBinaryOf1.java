
public class FromOneToNBinaryOf1 {

	public int sumOfBinaryOf1(int n) {
		int count = 0;
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		for (int i = 1; i <= n; i++) {
			while (i != 0) {
				++count;
				i =  (i - 1) & i; //把一个整数减去1，在于运算能得到最右边的1；
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
