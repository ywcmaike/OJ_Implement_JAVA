package directOffer;

/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 */
public class MoreThanHalfNum {
	//利用快速排序的思想，找中位数
	public int MoreThanHalfNum_Solution(int [] array) {
		int length = array.length;
		if (length == 0) {
			return 0;
		}
		int start = 0;
		int end = length - 1;
		int mid = length >> 1;
		int index = partition(array, length, start, end);
		while (mid != index) {
			if (mid > index) {
				start = index + 1;
				index = partition(array, length, start, end);
			} else {
				end = index - 1;
				index = partition(array, length, start, end);
			}
		}
		
		if (!CheckMoreThanHalf(array, length, array[mid])) {
        	return 0;
        }
		return array[mid];
    }
	int partition(int[] array, int length, int left, int right) {
		
		int temp = array[left];
		while (left < right) {
			while (left < right && array[right] >= temp) {
				right--;
			}
			array[left] = array[right];
			while (left < right && array[right] <= temp) {
				left++;
			}
			array[right] = array[left];
		}
		array[left] = temp;
		return left;
	}
	
	//利用数组的特点，计数
	public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if (array == null || length == 0) {
        	return 0;
        }
        
        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
        	if (times == 0) {
        		result = array[i];
        		times = 1;
        	} else if (result == array[i]) {
        		times++;
        	} else {
        		times--;
        	}
        }
        if (!CheckMoreThanHalf(array, length, result)) {
        	result = 0;
        }
        return result;
    }
	public boolean CheckMoreThanHalf(int a[], int length, int result) {
		int times = 0;
		for (int i = 0; i < length; i++) {
			if (a[i] == result) {
				times++;
			}
		}
		if (times <= length/2) {
			return false;
		}
		return true;
	}
}
