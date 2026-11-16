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
    public boolean hasCycle(ListNode head) {
        // what is the listnode structure?
        // class ListNode {
        //   int val;
        //   ListNode next;
        // }
        // what is the size of the linked list?
        // what is the return type? true or false or return node where cycle formed?
        // test cases:
        // 1) input : [1, 2, 3, 4], index = 1
        // output : true
        // 2) input : [1, 2, 3, 4], index = -1
        // output : false
        // edge cases:
        // 1) input : [] return false;
        // 2) input : null return false;
        // Approach1: set, TC: O(N), SC: O(N)
        // Approach2: tortaise hare problem, TC: O(N), SC: O(N)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
