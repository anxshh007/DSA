class Solution:
    def swapPairs(self, h: Optional[ListNode]) -> Optional[ListNode]:
        d = p = ListNode(0, h)
        while p.next and p.next.next:
            a, b = p.next, p.next.next
            p.next, a.next, b.next = b, b.next, a
            p = a
        return d.next
