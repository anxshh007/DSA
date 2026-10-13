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
    public ListNode partition(ListNode h, int x) {
        ListNode d1 = new ListNode(0), d2 = new ListNode(0), p1 = d1, p2 = d2;
        for (ListNode c = h; c != null; c = c.next) {
            if (c.val < x) { p1.next = c; p1 = p1.next; }
            else { p2.next = c; p2 = p2.next; }
        }
        p2.next = null;
        p1.next = d2.next;
        return d1.next;
    }
}