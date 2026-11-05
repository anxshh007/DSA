#Approach: Uses a fast pointer advanced by n + 1 steps so that when it reaches the end, the slow pointer sits right before the target node for a clean one-pass deletion.


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
