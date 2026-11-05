class Solution:
    def longestCommonPrefix(self, v: list[str]) -> str:
        a, b = min(v), max(v)
        for i, c in enumerate(a):
            if c != b[i]: return a[:i]
        return a
