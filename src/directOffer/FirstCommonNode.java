package directOffer;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FirstCommonNode {
	
	//方法1：O(mn)以一条链开始，每读取一个节点，遍历两一条链，相等返回。
	//方法2：O(m+n)两条链类似Y，借助栈，先将所有的节点分别存入栈中，同时弹出，知道节点不同，返回上一次弹出的节点。
	//方法3：O(m+n)遍历计算每条链的长度，长链先走几步，接着两条链同时走，相等返回。
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 int length1 = getListLength(pHead1);
		 int length2 = getListLength(pHead2);
		 int lengthdif = Math.abs(length1 - length2);
		 ListNode pHeadLong = null, pHeadShort = null ;
		 if (length1 > length2) {
			 pHeadLong = pHead1;
			 pHeadShort = pHead2;
		 } else {
			 pHeadLong = pHead2;
			 pHeadShort = pHead1;
		 }
		 for (int i = 0; i < lengthdif; i++) {
			 pHeadLong = pHeadLong.next;
		 }
		 while ((pHeadLong != null) && (pHeadShort != null) && (pHeadLong != pHeadShort)) {
			 pHeadLong = pHeadLong.next;
			 pHeadShort = pHeadShort.next;
		 }
		 return pHeadLong;
    }
	public static int getListLength(ListNode pHead) {
		int length = 0;
		ListNode pNode = pHead;
		while (pNode != null) {
			length++;
			pNode = pNode.next;
		}
		return length;
	}
}
