class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0, h);
        ListNode a = d, b = d;

        for (int i = 0; i < n; i++) {
            b = b.next;
        }

        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        a.next = a.next.next;
        return d.next;
    }
}
