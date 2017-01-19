package directOffer;
/*
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
	
	public void reOrderArray(int [] array) {
        int len=array.length;  
        int count1=0;  
        int count2=0;  
        int[] arr1=new int[len];  
        int[] arr2=new int[len];  
        for(int i=0;i<len;i++){  
            if(array[i]%2==0){  
               arr2[count2++]=array[i];  
            }else{  
                arr1[count1++]=array[i];  
            }  
        }  
        for(int i=0;i<count1;i++){  
            array[i]=arr1[i];  
        }  
        for(int i=0;i<count2;i++){  
           array[count1+i]=arr2[i];  
        }  
     
    }
}
