class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        d = h = ListNode(0)
        c = 0
        while l1 or l2 or c:
            v = c
            if l1:
                v += l1.val
                l1 = l1.next
            if l2:
                v += l2.val
                l2 = l2.next
            c, v = divmod(v, 10)
            h.next = ListNode(v)
            h = h.next
        return d.next
