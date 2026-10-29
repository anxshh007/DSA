import re


class Solution:

  def myAtoi(self, s: str) -> int:
    x = re.search(r'^\s*([+-]?\d+)', s)
    return (
        max(-2147483648, min(2147483647, int(x.group(1))))
        if x
        else 0
    )
