##### Remove Duplicates from Sorted Array (Python Implementation) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to remove duplicates from a sorted integer array **in-place** such that each unique element appears only once, and return the new length of the array. It uses a **two-pointer approach** (a slow pointer `i` and a fast pointer `j`) to achieve an optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```python
class Solution:
    def removeDuplicates(self, a: List[int]) -> int:
        i = 0
        for j in range(1, len(a)):
            if a[j] != a[i]:
                i += 1
                a[i] = a[j]
        return i + 1 if a else 0

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def removeDuplicates(self, a: List[int]) -> int:

```

* **Explanation:**
* `class Solution:`: Defines the standard LeetCode wrapper class.
* `def removeDuplicates(self, a: List[int]) -> int:`: Method signature that takes a list of integers `a` as input and returns an integer representing the count of unique elements.



---

###### 2. Slow Pointer Initialization

```python
        i = 0

```

* **Explanation:**
* Initializes the slow pointer `i` at index `0`. This pointer keeps track of the boundary up to which all elements are unique.



---

###### 3. Fast Pointer Loop

```python
        for j in range(1, len(a)):

```

* **Explanation:**
* Loops through the array starting from index `1` to the end using the fast pointer `j` to scan and inspect each element.



---

###### 4. Condition for Unique Element Check

```python
            if a[j] != a[i]:

```

* **Explanation:**
* Compares the element at the fast pointer (`a[j]`) with the last known unique element at the slow pointer (`a[i]`). If they are different, it means we have found a new unique element.



---

###### 5. Updating Position and Storing Unique Element

```python
                i += 1
                a[i] = a[j]

```

* **Explanation:**
* `i += 1`: Increments the slow pointer to the next position.
* `a[i] = a[j]`: Copies the new unique value found at `j` into the front section of the array at index `i`.



---

###### 6. Return Statement

```python
        return i + 1 if a else 0

```

* **Explanation:**
* `i + 1`: Since `i` is a zero-based index, adding `1` gives the total count of unique elements.
* `if a else 0`: Handles edge cases where the input list `a` might be empty, returning `0` safely.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | We traverse the array of size $N$ exactly once using the fast pointer `j`. |
| **Space Complexity** | $O(1)$ | Modifies the array in-place without using any extra data structures. |
