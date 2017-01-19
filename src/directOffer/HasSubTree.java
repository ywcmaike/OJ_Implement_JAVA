package directOffer;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class HasSubTree {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
        	return false;
        }
        return doesRoot1HasRoot2(root1, root2) || doesRoot1HasRoot2(root1.left, root2) || doesRoot1HasRoot2(root1.right, root2);
        
    }
	public static boolean doesRoot1HasRoot2(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		
		if (root1.val == root2.val) {
			return (doesRoot1HasRoot2(root1.left, root2.left) && doesRoot1HasRoot2(root1.right, root2.right));
			
		} else {
			return false;
		}
	}
}
