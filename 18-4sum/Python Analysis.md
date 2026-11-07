##### 4Sum (LeetCode Problem 18) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to find all unique quadruplets in an array (`nums`) that sum up to a given `target`, meaning $nums[i] + nums[j] + nums[l] + nums[h] = target$. It extends the **sorting + two-pointer approach** used in 3Sum by adding a second nested loop, achieving an optimal **$O(N^3)$ time complexity** while efficiently avoiding duplicate quadruplets.

---

###### Complete Solution Code

```python
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

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode wrapper class definition.
* `def fourSum(self, nums: list[int], target: int) -> list[list[int]]:`: Method declaration accepting a list of integers `nums` and an integer `target`, returning a list of list integers containing all unique quadruplets.



---

###### 2. Array Length, Sorting, and Result Initialization

```python
        n, s = len(nums), sorted(nums)
        r = []

```

* **Explanation:**
* `n = len(nums)`: Stores the total number of elements in the array.
* `s = sorted(nums)`: Sorts the array in ascending order. Sorting is crucial for applying the two-pointer technique and skipping duplicates cleanly.
* `r = []`: Initializes an empty list to store the final valid quadruplets.



---

###### 3. First Outer Loop & Duplicate Skipping for the First Element

```python
        for i in range(n - 3):
            if i > 0 and s[i] == s[i - 1]: continue

```

* **Explanation:**
* `for i in range(n - 3):`: Iterates to fix the first element of the quadruplet, stopping at `n - 3` to reserve space for the remaining three elements.
* `if i > 0 and s[i] == s[i - 1]: continue`: Skips duplicate values for the first position to prevent adding duplicate quadruplets to the final output.



---

###### 4. Second Outer Loop & Duplicate Skipping for the Second Element

```python
            for j in range(i + 1, n - 2):
                if j > i + 1 and s[j] == s[j - 1]: continue

```

* **Explanation:**
* `for j in range(i + 1, n - 2):`: Iterates to fix the second element of the quadruplet, starting right after `i` and stopping at `n - 2`.
* `if j > i + 1 and s[j] == s[j - 1]: continue`: Skips duplicate values for the second position to maintain uniqueness among combinations.



---

###### 5. Two-Pointer Initialization

```python
                l, h = j + 1, n - 1

```

* **Explanation:**
* `l, h = j + 1, n - 1`: Initializes two pointers for the remaining sub-array:
* `l` (left pointer) starts immediately after `j`.
* `h` (high/right pointer) starts at the very end of the array.





---

###### 6. Inner While Loop & Quadruplet Sum Calculation

```python
                while l < h:
                    t = s[i] + s[j] + s[l] + s[h]

```

* **Explanation:**
* `while l < h:`: Continues running as long as the left pointer has not crossed or met the right pointer.
* `t = s[i] + s[j] + s[l] + s[h]`: Computes the sum of the current quadruplet combination.



---

###### 7. Handling Target Match and Skipping Inner Duplicates

```python
                    if t == target:
                        r.append([s[i], s[j], s[l], s[h]])
                        l += 1; h -= 1
                        while l < h and s[l] == s[l - 1]: l += 1
                        while l < h and s[h] == s[h + 1]: h -= 1

```

* **Explanation:**
* `t == target`: A valid quadruplet is found. Append it to result list `r`.
* `l += 1; h -= 1`: Move both pointers inward.
* `while` loops: Skip consecutive duplicate elements for both `l` and `h` pointers to avoid duplicate entries in the result.



---

###### 8. Adjusting Pointers Based on Sum Magnitude

```python
                    elif t < target:
                        l += 1
                    else:
                        h -= 1

```

* **Explanation:**
* `t < target`: The sum is too small. Increment `l` (`l += 1`) to pick a larger value since the array is sorted.
* `else (t > target)`: The sum is too large. Decrement `h` (`h -= 1`) to pick a smaller value.



---

###### 9. Returning the Final Result

```python
        return r

```

* **Explanation:**
* Returns the complete list of unique quadruplets `r`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^3)$ | Sorting takes $O(N \log N)$ time, and the nested loops combined with the two-pointer linear scan take $O(N^3)$ time, which dominates overall execution. |
| **Space Complexity** | $O(1)$ or $O(N)$ | Auxiliary memory depends on the sorting algorithm's internal call stack, excluding the memory required to store the output result list. |
