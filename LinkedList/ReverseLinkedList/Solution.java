class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head) {
    	// Reversing list with 0 or 1 node(s) is equivalennt to the identity
    	if(head == null || head.next == null) {
    		return head;
    	}

    	// Make pointers (in order)
    	ListNode a = head;
    	ListNode b = a.next;
    	ListNode c = b.next;

    	// Point new tail to null (all tails should point to null)
    	head.next = null;

    	// Continue to point the middle node at the left node until there are no more nodes
    	while(c != null) {
    		b.next = a;
    		a = b;
    		b = c;
    		c = c.next;
    	}

    	// Remember to point last node (new head) to the (new) next node
    	b.next = a;

    	// Return head
    	return b;
    }
}