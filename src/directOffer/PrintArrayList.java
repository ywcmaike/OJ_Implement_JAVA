package directOffer;

import java.util.ArrayList;
//输入一个链表，从尾到头打印链表每个节点的值
class ListNode {
	int val;
    ListNode next = null;
    ListNode(int val) {
    	this.val = val;
    }
}


public class PrintArrayList {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ListNode temp = listNode;
        while (temp != null) {
        	a.add(new Integer(temp.val));
        	temp = temp.next;
        }
        Integer b;
        for (int i = 0; i < a.size()/2; i++) {
        	b = a.get(i);
        	a.set(i, a.get(a.size() - i - 1));
        	a.set(a.size() - i - 1, b);
        }
		return a;
		
    }
}
