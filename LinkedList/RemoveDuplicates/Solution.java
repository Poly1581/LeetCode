//Difficulty: easy
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

    public ListNode deleteDuplicates(ListNode head) {
        // Do nothing if the list contains 0 or 1 node(s)
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = head; // p = previous
        ListNode c = p.next; // c = current

        while(c != null) {

            // Find next different value
            while(c != null && c.val == p.val) {
                c = c.next;
            }

            // Point previous to next different value
            p.next = c;

            p = c;
            c = p == null ? null : p.next; // Set currrent to the next node after current if it exists
        }

        return head;
    }
}