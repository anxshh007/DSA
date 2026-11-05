#Approach: Sorts the array and uses two nested loops combined with a two-pointer scan while skipping duplicates to find all unique quadruplets summing to the target.

class Solution:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        n, s = len(nums), sorted(nums)
        r = []
        for i in range(n - 3):
            if i > 0 and s[i] == s[i - 1]: continue
            for j in range(i + 1, n - 2):
                if j > i + 1 and s[j] == s[j - 1]: continue
                l, h = j + 1, n - 1
                while l < h:
                    t = s[i] + s[j] + s[l] + s[h]
                    if t == target:
                        r.append([s[i], s[j], s[l], s[h]])
                        l += 1; h -= 1
                        while l < h and s[l] == s[l - 1]: l += 1
                        while l < h and s[h] == s[h + 1]: h -= 1
                    elif t < target:
                        l += 1
                    else:
                        h -= 1
        return r
