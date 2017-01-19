package directOffer;


public class MinNumberInRotateArray {
	/*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 *输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
	 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 */
	public int minNumberInRotateArray(int [] array) {
		int min = 0, index1, index2, length;
		index1 = 0;
		length = array.length;
		index2 = length -1;
		if (length == 0) {
			min = 0;
		}
		
		while (array[index1] >= array[index2]) {
			if (index2 - index1 == 1) {
				min = index2;
				break;
			}
			min = (index1 + index2) / 2;
			if (array[index1] == array[index2] && array[index2] == array[min]) {
				return minInOrder(array, index1, index2);
			}
			if (array[index1] <= array[min]) {
				index1 = min;
			} else if (array[index2] >= array[min]) {
				index2 = min;
			}
		}
	    
	    return array[min];
    }
	public int minInOrder(int [] array, int index1, int index2) {
		int result = array[index1];
		for (int i = index1 + 1; i <= index2; i++) {
			if (result > array[i]) {
				result = array[i];
			}
		}
		return result;
	}
	
	/*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 *输入一个非递减排序的数组的一个旋转，输出旋转数组的指定的元素的位置。
	 *例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，4的位置是第1个。
	 *NOTE：给出的所有元素都大于0，若数组大小为0，请返回-1, 找不到返回-1。
	 */
	public static int numberInRotateArray(int [] array, int number) {
		int length = array.length;
		if (length == 0) {
			return -1;
		}
		int low = 0;
		int high = length - 1;
		int mid = 0;
		while (low != high) {
			mid = (low + high) / 2;
			if (array[mid] == number) {
				return mid;
			}
			if (array[low] < array[mid]) {
				if (array[low] <= number && number < array[mid]) {
					high = mid;
				} else {
					low = mid;
				}
			} else if (array[low] > array[mid]) {
				if (array[mid] < number && number <= array[high]) {
					low = mid;
				} else {
					high = mid;
				}
			} else {
				low++;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		int a[] = {4, 5, 6, 6, 8, 1,2,3};
		int mid = numberInRotateArray(a, 6);
		System.out.println(mid);
	}
}
