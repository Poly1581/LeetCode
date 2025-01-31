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
        ListNode p = node;
        ListNode c = p.next;
        
        while(c.next != null) {
            p.val = c.val;
            p = p.next;
            c = c.next;
        }
        
        p.val = c.val;
        p.next = null;
    }
}