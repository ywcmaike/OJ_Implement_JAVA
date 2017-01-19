import java.util.*;

class Node implements Comparable {
	private int value;
	private Node left;
	private Node right;
	public Node(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public Node getLeft() {
		return left;
				
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Node that = (Node) o;
		double result = this.value - that.value;
		return result > 0? 1 : result == 0? 0 : -1;
	
	}
	
}
public class Hafman {

	private static Node build(List<Node> nodes) {
		nodes = new ArrayList<Node>(nodes);
		sortList(nodes);
		while (nodes.size() > 1) {
			createAndReplace(nodes);
		}
		return nodes.get(0);
	}
	private static void createAndReplace(List<Node> nodes) {
		Node left = nodes.get(0);
		Node right = nodes.get(1);
		Node parent = new Node(left.getValue() + right.getValue());
		parent.setLeft(left);
		parent.setRight(right);
		nodes.remove(0);
		nodes.remove(0);
		nodes.add(parent);
		sortList(nodes);
	}
	private static void sortList(List<Node> nodes) {
		Collections.sort(nodes);
	}
	public static void printTree(Node node) {
		Node left = null;
		Node right = null;
		if (node != null) {
			System.out.print(node.getValue());
			left = node.getLeft();
			right = node.getRight();
			System.out.println("(" + (left != null ? left.getValue():" ") + ", " 
					+ (right != null ? right.getValue():" "));
		}
		if (left != null) {
			printTree(left);
		}
		if (right != null) {
			printTree(right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node> nodes = Arrays.asList(new Node(1), 
				new Node(3), new Node(5), new Node(7));
		Node node = Hafman.build(nodes);
		printTree(node);
	}

}
