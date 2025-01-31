// Difficulty: medium
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

    // I broke up rotateRight into finding the length and rotating left to better illustrate my reasoning,
    //but it is more memory efficient to do both in one function because of the memory overhead for a function call.
    public ListNode rotateRight(ListNode head, int k) {
        // Do nothing if the list has 0 or 1 node(s)
        //      Note: rotation on lists with 0 or 1 node(s) is equivalent to the identity for all k
        if(head == null || head.next == null) {
            return head;
        }
        
        // Find length of list
        int n = 0;
        ListNode c = head;
        while(c != null) {
            n++;
            c = c.next;
        }

        // Rotating right is equivalent to rotating left by the positive modulo of k
        return rotateLeft(head, ((n - k) % n + n ) % n);
    }

    public ListNode rotateLeft(ListNode head, int k) {
        // Do nothing if the list has 0 or 1 node(s)
        //      Note: rotation on lists with 0 or 1 node(s) is equivalent to the identity for all k
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode c = head;

        // Find last node in list
        while(p.next != null) {
            p = p.next;
        }

        // Make loop
        p.next = c;

        // Shift nodes to the right by k
        //      Note: shifting pointers to the right is equivalent ot shifting the loop to the left
        while(k > 0) {
            k--;
            p = p.next;
            c = c.next;
        }

        // Break loop
        p.next = null;
        
        // Return new head
        return c;
    }
}