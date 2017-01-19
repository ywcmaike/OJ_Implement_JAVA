package directOffer;
//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeList {
	//非递归解法
	public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
        	return null;
        }
        ListNode mergeList = null;
        ListNode current = null;
        if (list1 == null) {
        	return list2;
        }
        if (list2 == null) {
        	return list1;
        }
        while (list1 != null && list2 != null) {
        	if (list1.val <= list2.val) {
        		if (mergeList == null) {
        			mergeList = current = list1;
        		} else {
        			current.next = list1;
        			current = current.next;
        		}	
        		list1 = list1.next;
        	} else {
        		if (mergeList == null) {
        			mergeList = current = list2;
        		} else {
        			current.next = list2;
        			current = current.next;
        		}	
        		list2 = list2.next;
        	}
        }
        if (list1 == null) {
        	current.next = list2;
        } else {
        	current.next = list1;
        }
        
        return mergeList;
    }
	
	//递归解法
//	public ListNode Merge(ListNode list1,ListNode list2) {
//		if (list1 == null) {
//			return list2;
//		} else if (list2 == null) {
//			return list1;
//		}
//		 ListNode mergeList = null;
//		 if (list1.val <= list2.val) {
//			 mergeList = list1;
//			 mergeList.next = Merge(list1.next, list2);
//		 } else {
//			 mergeList = list2;
//			 mergeList.next = Merge(list1, list2.next);
//		 }
//		 return mergeList;
//	}
}
