class Solution:
    def convert(self, s: str, r: int) -> str:
        if r == 1 or r >= len(s):
            return s
        
        b = [""] * r
        i, d = 0, 1
        
        for c in s:
            b[i] += c
            if i == 0:
                d = 1
            elif i == r - 1:
                d = -1
            i += d
            
        return "".join(b)
