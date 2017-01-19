package directOffer;

/*
 * 二叉搜索树的后续遍历序列，输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果， 
 */
import java.util.Arrays;

public class VerifySequenceBST {

	boolean VerifySequenceBST(int sequence[], int length) {
		if (sequence == null || length <= 0) {
			return false;
		}
		int root = sequence[length - 1];
		//在二叉搜索树左子树节点大于根节点
		int i = 0;
		for (; i < length - 1; i++) {
			if (sequence[i] > root) {
				break;
			}
		}
		//在二叉搜索树中右子树节点大于根节点
		int j = i;
		for (; j < length - 1; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}
		//判断左子树是不是二叉搜索树
		boolean left = true;
		if (i > 0) {
			left = VerifySequenceBST(sequence, i);
		} 
		boolean right = true;
		if (i < length - 1) {
			int[] newSequence = Arrays.copyOfRange(sequence, i, length);
			right = VerifySequenceBST(newSequence, length - i);
		}
		return (left && right);
	}
}
