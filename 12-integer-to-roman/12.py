class Solution:
    def intToRoman(self, n: int) -> str:
        v = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        s = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        r = []
        for i, val in enumerate(v):
            if n == 0:
                break
            d, n = divmod(n, val)
            r.append(s[i] * d)
        return "".join(r)
