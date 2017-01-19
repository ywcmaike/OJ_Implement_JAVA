import java.util.*;
/*
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
测试样例：
[1,3,5,2,2],5,3
返回：2
 */
public class FindKth {
	public int findKth(int[] a, int n, int k) {
        // write code here
		return findKthNumber(a, n, 0, n - 1, k);
		
    }
	public int findKthNumber(int [] a, int n, int low, int high, int k) {
		int part = partition(a, low, high);
		if (part == n - k) {
			return a[part];
		} 
		if (part >  n - k) {
			high = part - 1;
			return findKthNumber(a, n, low, high, k);
		} else {
			low = part + 1;
			return findKthNumber(a, n, low, high, k);
		}
	}
	
	int partition(int[] a, int low, int high) {
		int key = a[low];
		while (low < high) {
			while (low < high && a[high] >= key) {
				high--;
			}
			a[low] = a[high];
			while (low < high && a[low] <= key) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;
		return low;
			
	}
}
