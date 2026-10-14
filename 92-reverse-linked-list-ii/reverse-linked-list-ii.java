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
    public ListNode reverseBetween(ListNode h, int m, int n) {
        if (h == null || m == n) return h;
        ListNode d = new ListNode(0);
        d.next = h;
        ListNode p = d;
        for (int i = 0; i < m - 1; i++) p = p.next;
        ListNode c = p.next;
        for (int i = 0; i < n - m; i++) {
            ListNode t = c.next;
            c.next = t.next;
            t.next = p.next;
            p.next = t;
        }
        return d.next;
    }
}