package directOffer;
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class NumsAppearOnce {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (array == null || length < 2) {
        	return;
        }
        int resultExclusiveOR = 0;
        for (int i = 0; i < length; i++) {
        	resultExclusiveOR ^= array[i];
        }
        int indexOf1 = FindFirstBitIs1(resultExclusiveOR);
        num1[0] = num2[0] = 0;
        for (int j = 0; j < length; j++) {
        	if (IsBit1(array[j], indexOf1) != 0) {
        		num1[0] ^= array[j];
        	} else {
        		num2[0] ^= array[j];
        	}
        }
    }
	int FindFirstBitIs1(int num) {
		int indexBit = 0;
		while (((num & 1) == 0)) {
			num = num >> 1;
        	++ indexBit;
		}
		return indexBit;
	}
	int IsBit1(int num, int indexBit) {
		num = num >> indexBit;
        return (num & 1);
	}
}
