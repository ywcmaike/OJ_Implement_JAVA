import java.util.Scanner;

/*
 * A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],这里t为B的起床时间。这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任意时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？

输入描述:
第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di


输出描述:
输出答案个数

输入例子:
2 3 0 20
15 17
23 26
1 4
7 11
15 17

输出例子:
20
 */

public class DPGettup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			int l = scan.nextInt();
			int r = scan.nextInt();
			int [][] a = new int[p][2];
			int [][] b = new int[q][2];
			for (int i = 0; i < p; i++) {
				a[i][0] = scan.nextInt();
				a[i][1] = scan.nextInt();
			}
			for (int j = 0; j < q; j++) {
				a[j][0] = scan.nextInt();
				a[j][1] = scan.nextInt();
			}
			System.out.println(getUpTime(p, q, l, r, a, b));		
		}
		
	}
	public static int getUpTime(int p, int q, int l, int r, int[][]a, int[][]b) {
		int count = 0;
		for (int i = 1; i <= r; i++) {
			if (isProperTime(a, b, i)) {
				count++;
			}
		}
		return count;
	}
	public static boolean isProperTime(int[][] A, int[][] B, int d) {
		for (int i = 0; i < A.length; i++) {
			int a1 = A[i][0];
			int a2 = A[i][1];
			for (int j = 0; j < B.length; j++) {
				int b1 = B[j][0] + d;
				int b2 = B[j][1] + d;
				if (b1 <= a2 && b2 >= a1) {
					return true;
				}
			}
		}
		return false;
	}
}
