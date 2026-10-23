Here is the detailed, line-by-line breakdown of the Python solution for **LeetCode Problem #4: Median of Two Sorted Arrays**, formatted as a `README.md` file.

---

# Median of Two Sorted Arrays — Python Solution Breakdown

## Overview

The objective of this algorithm is to find the median of two sorted arrays (`A` and `B`) of sizes $m$ and $n$ respectively. Instead of merging both arrays into a single sorted array (which takes $O(m + n)$ time and space), this solution uses **binary search on the smaller array** to partition both arrays simultaneously, achieving an optimal **$O(\log(\min(m, n)))$ time complexity**.

---

## Complete Solution Code

```python
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

```

---

## Line-by-Line Code Analysis

### 1. Class and Method Signature

```python
class Solution:

    def findMedianSortedArrays(self, A: list[int], B: list[int]) -> float:

```

* **Explanation:**
* Defines the standard `Solution` class wrapper required by LeetCode.


* `findMedianSortedArrays` takes two 0-indexed sorted integer lists `A` and `B` and returns a `float` representing the combined median value.





---

### 2. Ensuring Binary Search Runs on the Smaller Array

```python
        if len(A) > len(B):
            A, B = B, A

```

* **Explanation:**
* Checks if array `A` is longer than array `B`. If it is, swaps `A` and `B` using tuple unpacking.


* Ensuring `A` is always the shorter array guarantees that the binary search runs in $O(\log(\min(m, n)))$ time and prevents out-of-bounds indexing when computing the partition index `j` for array `B`.





---

### 3. Size Initialization and Binary Search Range

```python
        m, n = len(A), len(B)
        l, r = 0, m

```

* **Explanation:**
* `m` and `n` store the lengths of arrays `A` and `B` respectively.


* `l = 0` and `r = m` set the search boundaries for binary searching the partition point in array `A`.





---

### 4. Binary Search Loop and Partition Calculation

```python
        while l <= r:
            i = (l + r) // 2
            j = (m + n + 1) // 2 - i

```

* **Explanation:**
* `while l <= r:` Standard binary search loop condition.


* `i`: The cut/partition point in array `A`, calculated as the midpoint of the current search range $[l, r]$.


* `j`: The corresponding cut/partition point in array `B`. The formula `(m + n + 1) // 2 - i` ensures that the combined left half of both arrays contains exactly half of the total elements (or one extra element if total length $m + n$ is odd).





---

### 5. Boundary Value Extraction for Array A

```python
            max_l_A = float("-inf") if i == 0 else A[i - 1]
            min_r_A = float("inf") if i == m else A[i]

```

* **Explanation:**
* `max_l_A`: The largest element on the left side of partition `A`. If `i == 0`, no elements from `A` are in the left partition, so it is set to `-inf` to handle edge cases safely.


* `min_r_A`: The smallest element on the right side of partition `A`. If `i == m`, all elements of `A` are in the left partition, so it is set to `inf`.





---

### 6. Boundary Value Extraction for Array B

```python
            max_l_B = float("-inf") if j == 0 else B[j - 1]
            min_r_B = float("inf") if j == n else B[j]

```

* **Explanation:**
* `max_l_B`: The largest element on the left side of partition `B`. If `j == 0`, no elements from `B` are in the left partition, so it defaults to `-inf`.


* `min_r_B`: The smallest element on the right side of partition `B`. If `j == n`, all elements of `B` are in the left partition, so it defaults to `inf`.





---

### 7. Valid Partition Check & Median Calculation

```python
            if max_l_A <= min_r_B and max_l_B <= min_r_A:
                if (m + n) % 2 == 1:
                    return float(max(max_l_A, max_l_B))
                return (
                    max(max_l_A, max_l_B) + min(min_r_A, min_r_B)
                ) / 2.0

```

* **Explanation:**
* **Partition Valid Condition (`max_l_A <= min_r_B and max_l_B <= min_r_A`)**: Confirms that all elements in the combined left partition are smaller than or equal to all elements in the combined right partition.


* **Odd Total Length (`(m + n) % 2 == 1`)**: The total number of elements is odd, so the median is simply the largest value in the combined left partition (`max(max_l_A, max_l_B)`).


* **Even Total Length**: The total number of elements is even, so the median is the average of the maximum element on the left (`max(max_l_A, max_l_B)`) and the minimum element on the right (`min(min_r_A, min_r_B)`), computed with floating-point division `/ 2.0`.





---

### 8. Binary Search Adjustment

```python
            elif max_l_A > min_r_B:
                r = i - 1
            else:
                l = i + 1

```

* **Explanation:**
* `max_l_A > min_r_B`: Array `A` has contributed too many large elements to the left partition. We shift the right bound `r = i - 1` to search in the lower half of `A`.


* `else` (`max_l_B > min_r_A`): Array `A` hasn't contributed enough elements to the left partition. We shift the left bound `l = i + 1` to search in the upper half of `A`.





---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log(\min(m, n)))$ | Binary search is performed exclusively on the smaller array of size $\min(m, n)$.

 |
| **Space Complexity** | $O(1)$ | Uses constant extra space with scalar pointers and boundary tracking variables.

 |
