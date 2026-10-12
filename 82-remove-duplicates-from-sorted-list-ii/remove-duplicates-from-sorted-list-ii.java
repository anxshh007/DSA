//The approach uses a dummy node and a pointer to detect duplicates and skip entire sequences of repeating values in a single pass.

class Solution {
    public ListNode deleteDuplicates(ListNode h) {
        ListNode d = new ListNode(0, h), p = d;
        while (p.next != null) {
            ListNode c = p.next;
            if (c.next != null && c.val == c.next.val) {
                while (c.next != null && c.val == c.next.val) c = c.next;
                p.next = c.next;
            } else {
                p = p.next;
            }
        }
        return d.next;
    }
}