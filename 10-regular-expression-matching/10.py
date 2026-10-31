#Approach - It uses a 2D dynamic programming table to track pattern matching states, handling characters, dots, and asterisk repetitions efficiently.

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        d = [[False] * (n + 1) for _ in range(m + 1)]
        d[0][0] = True
        for j in range(1, n + 1):
            if p[j - 1] == '*':
                d[0][j] = d[0][j - 2]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] == '*':
                    d[i][j] = d[i][j - 2] or (
                        d[i - 1][j] and (p[j - 2] == '.' or p[j - 2] == s[i - 1])
                    )
                else:
                    d[i][j] = d[i - 1][j - 1] and (
                        p[j - 1] == '.' or p[j - 1] == s[i - 1]
                    )
        return d[m][n]
