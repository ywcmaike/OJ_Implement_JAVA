package directOffer;
import java.util.ArrayList;


/*
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class ContinueSequence {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return arrayList;
		}
		
		int small = 1;
		int big = 2;
		int cursum = small + big;
		int mid = (1 + sum) / 2;
		while (small < mid) {
			
			if (cursum == sum) {
				ArrayList<Integer> array = new ArrayList<Integer>();
				for (int i = small; i <= big; i++) {
					array.add(i);
				}
				arrayList.add(array);
			} 
			while (cursum > sum && small < mid) {
				cursum -= small;
				small++;
				if (cursum == sum) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for (int i = small; i <= big; i++) {
						array.add(i);
					}
					arrayList.add(array);
				}
			}
			big++;
			cursum += big;
		}
		
		return arrayList;
    }
	
	
}
