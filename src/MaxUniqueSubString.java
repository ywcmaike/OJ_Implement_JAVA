/*
 * 求字符串中最长无重复字符的子串
 */
public class MaxUniqueSubString {
	
	//O(n^2)
	public int maxUniqueSub(char[] str) {
		int i, j;
		int length = str.length;
		int maxlen = 0;
		int begin = 0;
		char[] hash = new char[256];
		for (i = 0; i < length; i++) {
			hash[str[i]] = 1;
			for (j = i + 1; j < length; j++) {
				if (hash[str[j]] == 0) {
					hash[str[j]] = 1;
				} else {
					break;
				}
			}
			if (j - i + 1 > maxlen) {
				maxlen = j - i + 1;
				begin = i;
			}
		}
		return maxlen;
	}
	//O(n)
	/*对字符串“axbdebpqawuva”构造下表：
表中，字符串有3个‘a’，有2个‘b’，其余为单一字符。next[]记录了下一个与之重复的字符的位置，如str[0]=str[8]=str[12]=‘a’，这时next[0]=8，next[8]=12，next[12]=13，其余同理。值得注意的是，对于没有重复字符的，next[]存储字符结束符‘\0’的下标，即13。
这里，first[i]表示i之后，第一次出现重复字符的那个位置。例如，str[0]之后，第一次出现的重复字符是str[5]=‘b’，当然，从str[1]，str[2]开始也是一样。而从str[3]开始，要到str[12]才出现重复字符‘a’。可以证明，从str[i]起的最长符合要求的长度为first[i]-i，区间为[i,first[i]-1]由此得解。上述最长串是当i=3时，first[i]-i=12-3=9。结果最长无重复子串为“debpqawuv”。
*/
	public int maxUniqueSub(char[] str) {
		int maxlen = 0;
		int begin = 0;
		int n = str.length;
		char[] next = new char[n]; //next[i]记录下一个与str[i]重复的字符位置
		char[] first = new char[n + 1];//first[i]记录str[i]后面最近的一个重复点
		int[] hash = new int[256];
		first[n] = (char) n;
		int i;
		for (i = n-1; i >=0; i--) {
			next[i] = (char) hash[str[i]];
			hash[str[i]] = i;
			if (next[i] < first[i + 1]) {
				first[i] = next[i];
			} else {
				first[i] = first[i + 1];
			}
		}
		for (i = 0; i < n; i++) {
			if (first[i] - i > maxlen) {
				maxlen = first[i] - i;
				begin = i;
			}
		}
		return maxlen;
	}
	public static void main(String[] args) {
		
	}
}
