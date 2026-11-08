class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        h = c = ListNode()
        while l1 and l2:
            if l1.val < l2.val:
                c.next, l1 = l1, l1.next
            else:
                c.next, l2 = l2, l2.next
            c = c.next
        c.next = l1 or l2
        return h.next
