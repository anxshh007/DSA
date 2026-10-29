#Approach: Extracts the first valid signed integer sequence from the string using a regular expression, parses it, and clamps the result to the 32-bit signed integer range.


import re


class Solution:

  def myAtoi(self, s: str) -> int:
    x = re.search(r'^\s*([+-]?\d+)', s)
    return (
        max(-2147483648, min(2147483647, int(x.group(1))))
        if x
        else 0
    )
