package directOffer;

//给定一个整数sum,从有N个有序元素的数组中寻找元素a、b,使得a+b的结果最接近sum,最快的品均时间复杂度是：
public class NearSum {
	public static void findAB(int array[], int sum) {
		int length = array.length;
		
		if (length == 0) {
			return;
		}
		int left = 0;
		int right = length - 1;
		int a = array[left];
		int b = array[right];
		int gap = 0;
		int sumgap = Math.abs(array[left] + array[right] - sum);
		
		while (left < right) {
			gap = Math.abs(array[left] + array[right] - sum);
			if (sumgap > gap) {
				sumgap = gap;
				a = array[left]; 
				b = array[right];
			} 
			if (array[left] + array[right] == sum) {
				a = array[left];
				b = array[right];
				break;
			} else if (array[left] + array[right] > sum) {
				right--;
			} else {
				left++;	
			}
		}
		System.out.println("a=" + a + ", b=" + b);
		
	}
	public static void main(String[] args) {
		int array[] = {1, 2 ,3 ,6, 7, 9, 10};
		findAB(array, 14);
		
	}
}
