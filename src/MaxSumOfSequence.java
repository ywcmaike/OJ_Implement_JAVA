import java.util.*;
/*
 * 对于一个有正有负的整数数组，请找出总和最大的连续数列。
给定一个int数组A和数组大小n，请返回最大的连续数列的和。保证n的大小小于等于3000。
测试样例：
[1,2,3,-6,1]
返回：6
 */
public class MaxSumOfSequence {
	public int getMaxSum(int[] A, int n) {
        // write code here
		if (A == null || n <= 0) {
			return 0;
		}
		int cursum = A[0], tempsum = A[0];
		for (int i = 1; i < n; i++) {
			tempsum = (tempsum < 0) ? A[i] : tempsum + A[i];
			cursum = (tempsum >= cursum) ? tempsum : cursum;
		}
		return cursum;
    }
}
