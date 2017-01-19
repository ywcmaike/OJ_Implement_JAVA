import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//层次遍历二叉树
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}
public class LayerPrintTree {

	public ArrayList<Integer> LayerTree(TreeNode root) {
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
			list.add(treeNode.data);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
