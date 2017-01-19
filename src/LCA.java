
import java.util.Stack;


class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}

public class LCA {
	/*
	 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
测试样例：
2，3
返回：1
	 */
	//思路：满二叉树的子节点与父节点之间的关系为root = child / 2
	//利用这个关系，如果a ！= b，就让其中的较大数除以2， 如此循环知道a == b，
	//即是原来两个数的最近公共祖先
	public int getLCA(int a, int b) {
        // write code here
		while (a != b) {
			if (a > b) {
				a /= 2;
			} else {
				b /= 2;
			}
		}
		return a;
    }
	
	
	
	/*
	  * 任意树的两个节点找公共祖先
	  */
	 //先调用获取路径，接着调用最后一个公共节点返回最近的公共节点
	 public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		 Stack stackp = new Stack(); 
		 Stack stackq = new Stack();
		 getPath(root, p, stackp); 
		 getPath(root, q, stackq);
		 return lowestCommonAncestor(stackp, stackq); 
	 }
	 //两个路径path1和path2的最后一个公共节点
	 private static TreeNode lowestCommonAncestor(Stack stackp, Stack stackq) {
		 TreeNode target = null; 
		 while (!stackp.isEmpty() && !stackq.isEmpty() && stackp.peek() == stackq.peek()){
			 target = (TreeNode) stackp.peek();
			 stackp.pop();stackq.pop(); 
		} 
		 return target;
	 } 
	 //从根节点开始到达节点的路径， 保存在path中。
	 private static boolean getPath(TreeNode root, TreeNode p, Stack stackp) {
		 // TODO Auto-generated method stub
		 if (root == null)
			 return false;
		 if (root == p) {
			 stackp.push(root); 
			 return true; 
		 } else {
			 if (getPath(root.left, p, stackp) || getPath(root.right, p, stackp)){
				 stackp.push(root);
				 return true;
			 }
		 } 
		 return false;
	 }/*** * * 这个代码在实现过程中，是当找到给定节点的时候才将路径依次压入stack中的， * 也就是说，两个stack的栈顶都是存放着root节点。 * 因此，此时就应该找两条路径分离开之前的最后一个节点， * 此节点就是所求的最低公共祖先。 * @param args */
	 public static void main(String args[]){ 
		 TreeNode n1 = new TreeNode();
		 TreeNode n2 = new TreeNode();
		 TreeNode n3 = new TreeNode();
		 TreeNode n4 = new TreeNode();
		 TreeNode n5 = new TreeNode();
		 TreeNode n6 = new TreeNode();
		 TreeNode n7 = new TreeNode();
		 n1.left=n2;
		 n1.right=n3;
		 n2.left=n4;
		 n2.right=n5;
		 n3.left=n6;
		 n3.right=n7;
		 n1.data=1;
		 n2.data=2;
		 n3.data=3;
		 n4.data=4;
		 n5.data=5;
		 n6.data=6;
		 n7.data=7;
		 // 搜索二叉树// 1// / /// 2 3// / / / /// 4 5 6 7
		 System.out.println(n1.data);
		 System.out.println(n6.data);
		 System.out.println(n7.data);
		 TreeNode parent=getLowestCommonAncestor(n1, n6, n7); 
		 System.out.println(parent.data);
	 }

}