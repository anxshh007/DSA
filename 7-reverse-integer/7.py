class Solution:
  def reverse(self, x: int) -> int:
    s = -1 if x < 0 else 1 
    r = int (str(x*s)[::-1])*s
    return r if -2**31 < = r < 2**31 else 0 
