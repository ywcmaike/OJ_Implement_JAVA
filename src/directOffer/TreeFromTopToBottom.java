package directOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class TreeFromTopToBottom {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
        	return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	TreeNode treeNode = queue.poll();
        	if (treeNode.left != null) {
        		queue.offer(treeNode.left);
        	}
        	if (treeNode.right != null) {
        		queue.offer(treeNode.right);
        	}
        	list.add(treeNode.val);
        }
        return list;
    }
}
