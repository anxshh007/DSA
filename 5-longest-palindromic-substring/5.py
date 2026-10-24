#Approach: Manacher's Algorithm transforms the string with delimiters to treat odd and even palindromes uniformly, then uses previously calculated palindrome radii and symmetry to find all palindrome boundaries in $O(n)$ time.

class Solution:

  def longestPalindrome(self, s: str) -> str:
    t = "#" + "#".join(s) + "#"
    n = len(t)
    p = [0] * n
    c = r = 0
    m_i = m_l = 0

    for i in range(n):
      i_m = 2 * c - i
      if r > i:
        p[i] = min(r - i, p[i_m])

      while (
          i + 1 + p[i] < n
          and i - 1 - p[i] >= 0
          and t[i + 1 + p[i]] == t[i - 1 - p[i]]
      ):
        p[i] += 1

      if i + p[i] > r:
        c, r = i, i + p[i]

      if p[i] > m_l:
        m_l, m_i = p[i], i

    st = (m_i - m_l) // 2
    return s[st : st + m_l]
