package directOffer;
/*
 * 统计一个数字在排序数组中出现的次数。
 */
public class NumberOfK {
	
	public int GetFirstOfK(int[] array, int k, int length, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midData = array[mid];
		if (midData == k) {
			if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				right = mid - 1;
			} 
		} else if (midData < k) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
		return GetFirstOfK(array, k, length, left, right);
	}
	
	public int GetLastOfK(int[] array, int k, int length, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midData = array[mid];
		if (midData == k) {
			if ((mid < length - 1 && array[mid + 1] != k) || mid == length -1) {
				return mid;
			} else {
				left = mid + 1;
			}
		} else if (midData < k) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
		return GetLastOfK(array, k, length, left, right);
	}
	public int GetNumberOfK(int [] array , int k) {
		int number = 0;
		int length = array.length;
		if (length > 0 && array != null) {
			int left = GetFirstOfK(array, k, length, 0, length - 1);
			int right = GetLastOfK(array, k, length, 0, length - 1);
			if (left > - 1 && right > -1) {
				number = right - left + 1;
			}
		}
		
		return number;
    }
}		
