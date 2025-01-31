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

    public ListNode swapPairs(ListNode head) { //RECURSIVE
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs(ListNode head) { //Iterative
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode c = p.next;
        ListNode n = c.next;
        head = c;
        while(c != null) {
            c.next = p;
            if(n!= null && n.next != null) {
                p.next = n.next;
            } else {
                p.next = n;
            }
            p = n;
            c = n == null ? null : n.next;
            n = c == null ? null : c.next;
        }
        return head;
    }
}