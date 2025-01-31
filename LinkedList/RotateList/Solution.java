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

    public ListNode rotateRight(ListNode head, int k) {
        // Do nothing on empty list
        if(head.next == null) {
            return head;
        }

        // Make loop
        int n = 1;
        ListNode p = head;
        ListNode c = head;
        while(p.next != null) {
            n++;
            p = p.next;
        }
        p.next = head;

        //  Shift pointers
        k = ((n - k) % n + n ) % n; // Positive mod
        while(k > 0) {
            k--;
            p = p.next;
            c = c.next;
        }

        // Rotate
        p.next = null;
        return c;
    }
}