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

//The approach iterates through the sorted list, comparing each node's value with the next node's value and bypassing duplicates by updating pointer references in a single pass.

class Solution {
    public ListNode deleteDuplicates(ListNode h) {
        ListNode c = h;
        while (c != null && c.next != null) {
            if (c.val == c.next.val) c.next = c.next.next;
            else c = c.next;
        }
        return h;
    }
}