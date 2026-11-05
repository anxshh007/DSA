def romanToInt(s: str) -> int:
  d, t, p = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}, 0, 0
  for c in reversed(s):
    v = d[c]
    t += -v if v < p else v
    p = v
  return t
