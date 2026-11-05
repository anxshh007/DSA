class Solution:

  def removeNthFromEnd(self, h: Optional[ListNode], n: int) -> Optional[ListNode]:
    d = ListNode(0, h)
    s = f = d
    for _ in range(n + 1):
      f = f.next
    while f:
      s, f = s.next, f.next
    s.next = s.next.next
    return d.next
