import heapq

class Solution:
    def mergeKLists(self, l: list[Optional[ListNode]]) -> Optional[ListNode]:
        h = []
        for i, x in enumerate(l):
            if x:
                heapq.heappush(h, (x.val, i, x))
        d = p = ListNode(0)
        while h:
            _, i, x = heapq.heappop(h)
            p.next = x
            p = p.next
            if x.next:
                heapq.heappush(h, (x.next.val, i, x.next))
        return d.next
