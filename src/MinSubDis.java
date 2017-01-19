import java.util.*;
public class MinSubDis {
/*给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？

输入描述:
第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int [] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
			}
			int max = Integer.MIN_VALUE;
			int [] dis = new int[n - 1];
		
			for (int i = 1; i < n; i++) {
				dis[i - 1] = a[i] - a[i-1];
				max = Math.max(max, dis[i - 1]);
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < dis.length; i++) {
				int temp = Math.max(max, dis[i] + dis[i-1]);
				min = Math.min(min, temp);
			}
			System.out.println(min);
		}
		scan.close();
	}

}
