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
    public ListNode reverseKGroup(ListNode h, int k) {
        ListNode d = new ListNode(0);
        d.next = h;
        ListNode p = d;

        while (true) {
            ListNode e = p;

            for (int i = 0; i < k; i++) {
                e = e.next;
                if (e == null)
                    return d.next;
            }

            ListNode a = p.next;
            ListNode b = a.next;

            for (int i = 1; i < k; i++) {
                a.next = b.next;
                b.next = p.next;
                p.next = b;
                b = a.next;
            }

            p = a;
        }
    }
}
