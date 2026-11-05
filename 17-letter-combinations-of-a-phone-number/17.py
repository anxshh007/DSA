from itertools import product


class Solution:

  def letterCombinations(self, d: str) -> list[str]:
    if not d:
      return []
    m = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
    }
    return [''.join(p) for p in product(*(m[c] for c in d))]
