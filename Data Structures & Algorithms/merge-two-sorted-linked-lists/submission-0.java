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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Length of the lists?
        // Shall I reuse references or not?
        // Structure of the node?
        // ListNode {
        //   int val;
        //   ListNode next;
        // }
        // What is the output?
        // test cases:
        // 1) input: [1,2,4], [3,5]
        // output: [1,2,3,4,5]
        // 2) input: [1,2,4], [1,3,5]
        // output: [1,1,2,3,4,5]
        // Edge cases: null or null return other head
        // 1. recursive: TC: O(N), SC: O(N)
        // 2. iterative: TC: O(N), SC: O(1)
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode temp = new ListNode();
        ListNode dummy = temp;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null) {
            temp.next = list1;
        }
        if(list2 != null) temp.next = list2;
        return dummy.next;
    }
}