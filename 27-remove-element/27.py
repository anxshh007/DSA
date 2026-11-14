class Solution:

  def removeElement(self, a: list[int], v: int) -> int:
    k = 0
    for x in a:
      if x != v:
        a[k] = x
        k += 1
    return k
