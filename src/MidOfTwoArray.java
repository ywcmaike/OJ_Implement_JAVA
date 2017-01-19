import java.util.Arrays;

/*
 * 给定两个已经排序的数组，找出两者所有元素中的中间值
 */
//O(min(log(m), log(n));
	/*解题思路：假设A 和B 的元素个数都大于k/2，我们将A 的第k/2 个元素（即A[k/2-1]）和B 的第k/2个元素（即B[k/2-1]）进行比较，有以下三种情况（为了简化这里先假设k 为偶数，所得到的结论对于k 是奇数也是成立的）：
• A[k/2-1] == B[k/2-1] 
• A[k/2-1] > B[k/2-1] 
• A[k/2-1] < B[k/2-1] 
如果A[k/2-1] < B[k/2-1]，意味着A[0] 到A[k/2-1 的肯定在A U B 的top k 元素的范围内，换句话说，A[k/2-1]不可能大于A U B 的第k 大元素。留给读者证明。 
因此，我们可以放心的删除A 数组的这k/2 个元素。同理，当A[k/2-1] > B[k/2-1] 时，可以删除B 数组的k/2 个元素。 
当A[k/2-1] == B[k/2-1] 时，说明找到了第k 大的元素，直接返回A[k/2-1] 或B[k/2-1]即可。 
因此，我们可以写一个递归函数。那么函数什么时候应该终止呢？ 
• 当A 或B 是空时，直接返回B[k-1] 或A[k-1]； 
• 当k=1 是，返回min(A[0], B[0])； 
• 当A[k/2-1] == B[k/2-1] 时，返回A[k/2-1] 或B[k/2-1]
时间复杂度O（min(log(m), log(n)）
*/
public class MidOfTwoArray {
	public static int findKthNum(int[] arr1, int[] arr2) {
	    int length1 = arr1.length;
	    int length2 = arr2.length;
	    int mid = ((length1 + length2) % 2 == 1) ? ((length1 + length2) / 2 + 1) : (length1 + length2) / 2;
	    return findKth(arr1, length1, arr2, length2, mid);
	}
	public static int findKth(int[] A, int m, int[] B, int n, int k ) {
		if (m > n) {
			return findKth(B, n, A, m, k);
		}
		if (m == 0) {
			return B[k - 1];
		}
		if (k == 1) {
			return Math.min(A[0], B[0]);
		}
		int ia = Math.min(k/2, m), ib = k - ia;
		if (A[ia - 1] < B[ib - 1]) {
			int [] newA = Arrays.copyOfRange(A, ia, m);
			return findKth(newA, m - ia, B, n, k - ia);
		} else if (A[ia - 1] > B[ib - 1]) {
			int [] newB = Arrays.copyOfRange(B, ib, n);
			return findKth(A, m, newB, n - ib, k -ib);
		} else {
			return A[ia - 1];
		}
		
	}
	public static void main(String[] args) {
		int [] a = {0, 1, 2};
		int [] b = {3, 4, 5};
		System.out.println(findKthNum(a, b));
	}
}
