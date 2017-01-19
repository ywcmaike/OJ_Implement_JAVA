package directOffer;
/*
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class KthNode {
	int count = 0;
	TreeNode KthNode(TreeNode pRoot, int k)
    {
		if (pRoot != null) {
			TreeNode ret = KthNode(pRoot.left, k);
			if (ret != null) {
				return ret;
			}
			if (++count == k) {
				return pRoot;
			}
			ret = KthNode(pRoot.right, k);
			if (ret != null) {
				return ret;
			}
		}
		return null;
    }
}
