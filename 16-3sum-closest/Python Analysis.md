##### 3Sum Closest — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to find three integers in a list (`n`) whose sum is closest to a given target (`t`), and return that sum. It uses a **sorting + two-pointer approach** similar to the standard 3Sum problem, achieving an optimal **$O(N^2)$ time complexity**.

---

###### Complete Solution Code

```python
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

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def threeSumClosest(self, n: list[int], t: int) -> int:

```

* **Explanation:**
* Defines the standard LeetCode wrapper class `Solution`.
* `threeSumClosest` takes an integer list `n` and an integer target `t`, returning an integer representing the closest triplet sum.



---

###### 2. Sorting and Initializing the Closest Sum

```python
        n.sort()
        s = sum(n[:3])

```

* **Explanation:**
* **`n.sort()`**: Sorts the list in ascending order. Sorting is essential to efficiently navigate the elements using the two-pointer technique.
* **`s = sum(n[:3])`**: Initializes the closest sum (`s`) with the sum of the first three elements as an initial baseline reference point.



---

###### 3. Outer Loop

```python
        for i in range(len(n) - 2):

```

* **Explanation:**
* Iterates through the list, fixing `n[i]` as the first element of our triplet.
* We stop at `len(n) - 2` to ensure there is always enough room for the two pointer elements (`l` and `r`).



---

###### 4. Two-Pointer Initialization

```python
            l, r = i + 1, len(n) - 1

```

* **Explanation:**
* Initializes two pointers for the remaining subarray to the right of `i`:
* **`l` (left pointer)**: Starts right after `i` (`i + 1`).
* **`r` (right pointer)**: Starts at the very end of the list (`len(n) - 1`).





---

###### 5. Inner While Loop & Triplet Sum Calculation

```python
            while l < r:
                x = n[i] + n[l] + n[r]

```

* **Explanation:**
* **`while l < r`**: Continues running as long as the left pointer has not crossed or met the right pointer.
* **`x = n[i] + n[l] + n[r]`**: Calculates the sum of the current triplet formed by the fixed element and the two pointer elements.



---

###### 6. Updating the Closest Sum

```python
                if abs(x - t) < abs(s - t): 
                    s = x

```

* **Explanation:**
* Computes the absolute difference between the current triplet sum (`x`) and the target (`t`), and compares it with the difference between the current best sum (`s`) and `t`.
* If `x` is closer to the target than `s`, updates `s` to store `x`.



---

###### 7. Adjusting Pointers Based on Sum Magnitude

```python
                if x < t: 
                    l += 1
                elif x > t: 
                    r -= 1
                else: 
                    return x

```

* **Explanation:**
* **`x < t`**: The sum is smaller than the target. Because the list is sorted, we increment `l` (`l += 1`) to pick a larger number and increase the sum.
* **`x > t`**: The sum is larger than the target. We decrement `r` (`r -= 1`) to pick a smaller number and decrease the sum.
* **`else` (Exact Match)**: If `x == t`, we found a triplet that matches the target exactly, so we can return `x` immediately as the optimal answer.



---

###### 8. Returning the Final Result

```python
        return s

```

* **Explanation:**
* After checking all possible triplet combinations, returns the closest sum `s` found across the entire list.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^2)$ | Sorting takes $O(N \log N)$ time, and the nested structure (outer loop combined with the two-pointer linear scan) takes $O(N^2)$ time. Thus, the overall time complexity is dominated by $O(N^2)$. |
| **Space Complexity** | $O(1)$ or $O(N)$ | Auxiliary space depends on Python's underlying Timsort algorithm implementation (typically $O(N)$ space for temporary arrays in Python's sort), using constant extra space for pointers otherwise. |
