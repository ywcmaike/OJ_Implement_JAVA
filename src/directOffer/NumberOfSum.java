package directOffer;
import java.util.ArrayList;
/*
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
public class NumberOfSum {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int length = array.length;
        if (length < 3) {
        	return arrayList;
        }
        int low = 0;
        int high = length - 1;
        while (low < high) {
        	if (array[low] + array[high] == sum) {
        		arrayList.add(array[low]);
        		arrayList.add(array[high]);
        		break;
        	} else if (array[low] + array[high] < sum) {
        		low++;
        	} else {
        		high--;
        	}
        }
        return arrayList;
    }
}
