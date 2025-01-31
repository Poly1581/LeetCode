class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Do nothing on empty list
        if(head.next == null) {
            return head;
        }

        // Make loop
        ListNode l = head;
        while(l.next != null) {
            l = l.next;
        }
        l.next = head;

        //  Shift pointers
        ListNode p = head;
        ListNode c = head.next;
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