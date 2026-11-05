class Solution:
    def threeSumClosest(self, n: list[int], t: int) -> int:
        n.sort()
        s = sum(n[:3])
        for i in range(len(n) - 2):
            l, r = i + 1, len(n) - 1
            while l < r:
                x = n[i] + n[l] + n[r]
                if abs(x - t) < abs(s - t): 
                    s = x
                if x < t: 
                    l += 1
                elif x > t: 
                    r -= 1
                else: 
                    return x
        return s
