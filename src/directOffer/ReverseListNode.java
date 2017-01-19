package directOffer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseListNode {
	//输入一个链表，反转链表后，输出链表的所有元素。
	public ListNode ReverseList(ListNode head) {
		ListNode pReversedHead = null;
		ListNode pPrev = null;
		ListNode pNode = head;
		
		while (pNode != null) {
			ListNode pNext = pNode.next;
			if (pNext == null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		return pReversedHead;
    }
}
