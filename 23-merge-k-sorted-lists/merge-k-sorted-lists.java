class Solution {
    public ListNode mergeKLists(ListNode[] a) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            (x, y) -> x.val - y.val
        );

        for (ListNode x : a)
            if (x != null)
                q.add(x);

        ListNode d = new ListNode(0);
        ListNode c = d;

        while (!q.isEmpty()) {
            ListNode x = q.poll();
            c.next = x;
            c = c.next;

            if (x.next != null)
                q.add(x.next);
        }

        return d.next;
    }
}
