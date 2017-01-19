package zhenti2016;

public class MaxSubSum {

	static int maxSubSum(int [] array, int begin, int end) {
		
		int currentSum = 0;
		int maxSum = 0;
		int length = array.length;
		int newBegin = 0;
		for (int i = 0; i < length; i++) {
			currentSum += array[i];
			
			if (currentSum > maxSum) {
				maxSum = currentSum;
				begin = newBegin;
				end = i;
			}
			if (currentSum < 0) {
				currentSum = 0;
				newBegin = i + 1;
			}
		}
		System.out.println("begin:" + begin + ";end:" + end);
		return maxSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {5, -3, 4, 2};
		int max = maxSubSum(a, 0, 0);
		System.out.println(max);
	}

}
