//Difficulty: medium
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

    public void deleteNode(ListNode node) {
        // Use node as the pointer to save memory
        while(node.next.next != null) {
            node.val = node.next.val; // Shift values left
            node = node.next; // Advance node
        }
        node.val = node.next.val; // Shift value one last time
        node.next = null; // Delete last node (redundant because of shifted values)
    }
}