/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList1(ListNode head) {
        // 0 -> 1 -> 2 -> 3
        // null <- 0 <- 1 <- 2 <- 3
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        recursive(head);
        head.next = null;
        return newHead;
    }

    private ListNode recursive(ListNode head) {
        if(head.next == null) {
            newHead = head;
            return head;
        }
        ListNode next = recursive(head.next);
        next.next = head;
        return head;
    }
}
