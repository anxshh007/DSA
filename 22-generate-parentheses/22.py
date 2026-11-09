class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        r = []
        def f(o, c, s):
            if len(s) == 2 * n:
                r.append(s)
                return
            if o < n:
                f(o + 1, c, s + '(')
            if c < o:
                f(o, c + 1, s + ')')
        f(0, 0, '')
        return r
