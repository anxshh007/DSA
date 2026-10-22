class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0), c = h;
        int k = 0;
        
        while (l1 != null || l2 != null || k != 0) {
            int s = k;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            k = s / 10;
            c.next = new ListNode(s % 10);
            c = c.next;
        }
        
        return h.next;
    }
}
