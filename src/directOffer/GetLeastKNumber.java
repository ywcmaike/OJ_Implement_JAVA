package directOffer;

import java.util.ArrayList;
import java.util.Iterator;

/*输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 */

public class GetLeastKNumber {
	
	//快排思想
//	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        int length = input.length;
//        if (length == 0 || k > length || k <= 0) {
//        	return list;
//        }
//        int start = 0;
//        int end = length - 1;
//        int index = partition(input, length, start, end);
//        while (index != k - 1) {
//        	if (index > k - 1) {
//        		end = index - 1;
//        		index = partition(input, length, start, end);
//        	} else {
//        		start = index + 1;
//        		index = partition(input, length, start, end);
//        	}
//        	
//        }
//        for (int i = 0; i < k; i++) {
//        	list.add(input[i]);
//        }
//        return list;
//    }
//	//找位置
//	int partition(int[] input, int length, int start, int end) {
//		int temp = input[start];
//		while (start < end) {
//			while (start < end && input[end] >= temp) {
//				end--;
//			}
//			input[start] = input[end];
//			while (start < end && input[start] <= temp) {
//				start++;
//			}
//			input[end] = input[start];
//		}
//		input[start] = temp;
//		return start;
//	}
	
	
	/*堆排序  
	*/
	
	
	
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //检查输入的特殊情况
        if(input==null || input.length<=0 || input.length<k){
            return list;
        }
        //构建最大堆
        for(int len=k/2-1; len>=0; len--){
            adjustMaxHeapSort(input,len,k-1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for(int i=k; i<input.length; i++){
            if(input[i]<input[0]){
                tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                adjustMaxHeapSort(input,0,k-1);
            }
        }
        for(int j=0; j<k; j++){
            list.add(input[j]);
        }
        return list;
    }
     
    public static void adjustMaxHeapSort(int[] input, int pos, int length){
        int temp;
        int child;
        for(temp=input[pos]; 2*pos+1<=length; pos=child){
            child=2*pos+1;
            if(child<length && input[child]<input[child+1]){
                child++;
            }
            if(input[child]>temp){
                input[pos]=input[child];
            }else{
                break;
            }
        }
        input[pos]=temp;
    }
	public static void main(String[] args) {
		int a[] = {4, 5, 1, 6, 2, 7, 3, 8};
		int k = 4;
		ArrayList<Integer> array = GetLeastNumbers_Solution(a, k);
		for(Iterator<Integer> it2 = array.iterator();it2.hasNext();){
            System.out.print(it2.next() + " ");
       }
	}
}
