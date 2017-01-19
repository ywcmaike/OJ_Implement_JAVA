import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigNumSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			String [] str = new String[n];
			for (int i = 0; i < n; ++i) {
				str[i] = scan.next();
			}
			Arrays.sort(str, new cmp());
			for (String s : str) {
				System.out.println(s);
			}
		}
	}

}
class cmp implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return s1.compareTo(s2);
		} else {
			return s1.length() - s2.length();
		}
	}
}
