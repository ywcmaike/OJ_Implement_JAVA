import java.util.*;

/*
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
public class MinimalBST {
	public static TreeNode  build(int[] vals, int left, int right) {
		if (right <= left) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = TreeNode(vals[mid]);
		root.left = build(vals, left, mid - 1);
		root.right = build(vals, mid + 1, right);
		return root;
	}
	
	private static TreeNode TreeNode(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int buildMinimalBST(int[] vals) {
        // write code here
		int length = vals.length;
		if (length <= 0) {
			return 0;
		}
		TreeNode root = build(vals, 0, length - 1);
		return highBST(root);
    }
	public static int highBST(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = highBST(root.left);
		int right = highBST(root.right);
		return (left > right) ? left + 1: right + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266};
		System.out.println(buildMinimalBST(a));
	}
}
