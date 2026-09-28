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
 //anxshh
class Solution {
    public ListNode rotateRight(ListNode h, int k) {
        if (h == null || h.next == null || k == 0) return h;
        int l = 1;
        ListNode t = h;
        while (t.next != null) { t = t.next; l++; }
        t.next = h;
        k %= l;
        for (int i = 0; i < l - k; i++) t = t.next;
        h = t.next;
        t.next = null;
        return h;
    }
}