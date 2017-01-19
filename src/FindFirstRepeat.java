import java.util.*;
/*
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
测试样例：
"qywyer23tdd",11
返回：y
 */
public class FindFirstRepeat {
	public char findFirstRepeat(String A, int n) {
        // write code here
		HashSet hs = new HashSet();
		char[] a = A.toCharArray();
		for (int i = 0; i < n; i++) {
			boolean b = hs.add(a[i]);
			if (b == false) {
				return a[i];
			}
		}
		return '0';
		
    }
	public char findFirstRepeat(String A, int n) {
		char [] a = A.toCharArray();
		boolean [] hash = new boolean[500];
		for (int i = 0; i < n; i++) {
			if (!hash[a[i]]) {
				hash[a[i]] = true;
			} else {
				return a[i];
			}
		}
		return '0';
	}
}
