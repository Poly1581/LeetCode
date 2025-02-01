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

    public ListNode swapPairs(ListNode head) { //RECURSIVE
        // If list has 0 or 1 node(s), there is nothing to swap
        if(head == null || head.next == null) {
            return head;
        }
        // The new head is the node that follows the current head
        ListNode newHead = head.next;
        // Point the old head to the head returned by swapping the rest of the list
        head.next = swapPairs(newHead.next);
        // Point the new head to the old head
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs(ListNode head) { //Iterative
        // If the list has 0 or 1 node(s), there is nothing to swap
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head; // p = previous node
        ListNode c = p.next; // c = current node
        ListNode n = c.next; // n = next node;
        head = c; // The new head will be the second node in the list
        while(c != null) {
            c.next = p; // Point current at previous
            if(n != null && n.next != null) {
                p.next = n.next; // Point previous to the node after n (skip a node) when there is another pair to swap
            } else {
                p.next = n; // Point previous to n if there is not another node to swap
            }
            p = n; // Set previous to next
            c = n == null ? null : n.next; // Set current to the node after new previous if there is such a node
            n = c == null ? null : c.next; // Set next to the node after new current if there is such a node
        }
        return head; // Retun the new head (modified earlier in the function)
    }
}