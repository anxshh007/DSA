class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseKGroup(h: ListNode, k: int) -> ListNode:
    d = ListNode(0, h)
    p = d
    while True:
        t = p
        for _ in range(k):
            t = t.next
            if not t:
                return d.next
        n = p.next
        c = n.next
        for _ in range(k - 1):
            n.next = c.next
            c.next = p.next
            p.next = c
            c = n.next
        p = n
