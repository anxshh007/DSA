class Solution:

    def findMedianSortedArrays(self, A: list[int], B: list[int]) -> float:
        if len(A) > len(B):
            A, B = B, A
        m, n = len(A), len(B)
        l, r = 0, m

        while l <= r:
            i = (l + r) // 2
            j = (m + n + 1) // 2 - i

            max_l_A = float("-inf") if i == 0 else A[i - 1]
            min_r_A = float("inf") if i == m else A[i]
            max_l_B = float("-inf") if j == 0 else B[j - 1]
            min_r_B = float("inf") if j == n else B[j]

            if max_l_A <= min_r_B and max_l_B <= min_r_A:
                if (m + n) % 2 == 1:
                    return float(max(max_l_A, max_l_B))
                return (
                    max(max_l_A, max_l_B) + min(min_r_A, min_r_B)
                ) / 2.0
            elif max_l_A > min_r_B:
                r = i - 1
            else:
                l = i + 1
