##### 3Sum (Python Implementation) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to find all unique triplets in an array (`n`) that sum up to zero ($n[i] + n[j] + n[k] = 0$). It uses a **sorting + two-pointer approach** to achieve an optimal **$O(N^2)$ time complexity**, while effectively avoiding duplicate triplets without extra data structures.

---

###### Complete Solution Code

```python
def f(n):
  n.sort()
  r, l = [], len(n)
  for i in range(l - 2):
    if i > 0 and n[i] == n[i - 1]:
      continue
    j, k = i + 1, l - 1
    while j < k:
      t = n[i] + n[j] + n[k]
      if t < 0:
        j += 1
      elif t > 0:
        k -= 1
      else:
        r.append([n[i], n[j], n[k]])
        while j < k and n[j] == n[j + 1]:
          j += 1
        while j < k and n[k] == n[k - 1]:
          k -= 1
        j += 1
        k -= 1
  return r

```

---

###### Line-by-Line Code Analysis

###### 1. Function Signature

```python
def f(n):

```

* **Explanation:**
* Declares a function `f` that takes a list of integers `n` as its input parameter.



---

###### 2. Sorting and Variable Initialization

```python
  n.sort()
  r, l = [], len(n)

```

* **Explanation:**
* `n.sort()`: Sorts the list in ascending order in place. Sorting is mandatory to apply the two-pointer technique and efficiently handle duplicates.
* `r, l = [], len(n)`: Initializes `r` as an empty list to store the final valid triplets, and `l` to store the total length of the list.



---

###### 3. Outer Loop & Duplicate Skipping for the First Element

```python
  for i in range(l - 2):
    if i > 0 and n[i] == n[i - 1]:
      continue

```

* **Explanation:**
* `for i in range(l - 2):`: Iterates through the list, treating `n[i]` as the first element of the triplet. We stop at `l - 2` to leave space for the two pointer elements.
* `if i > 0 and n[i] == n[i - 1]: continue`: Skips duplicate values for the first element to ensure we do not add duplicate triplets to our result list.



---

###### 4. Two-Pointer Initialization

```python
    j, k = i + 1, l - 1

```

* **Explanation:**
* Initialises two pointers for the remaining portion of the list:
* `j` (left pointer): Starts right after `i` (`i + 1`).
* `k` (right pointer): Starts at the very end of the list (`l - 1`).





---

###### 5. Inner While Loop & Triplet Sum Calculation

```python
    while j < k:
      t = n[i] + n[j] + n[k]

```

* **Explanation:**
* `while j < k:`: Runs as long as the left pointer has not crossed or met the right pointer.
* `t = n[i] + n[j] + n[k]`: Computes the sum of the current triplet formed by `n[i]`, `n[j]`, and `n[k]`.



---

###### 6. Adjusting Pointers Based on Sum Magnitude

```python
      if t < 0:
        j += 1
      elif t > 0:
        k -= 1

```

* **Explanation:**
* `t < 0`: The sum is less than zero (too small). Since the list is sorted, incrementing `j` (`j += 1`) picks a larger number to increase the sum.
* `t > 0`: The sum is greater than zero (too large). Decrementing `k` (`k -= 1`) picks a smaller number to decrease the sum.



---

###### 7. Handling Target Match and Skipping Inner Duplicates

```python
      else:
        r.append([n[i], n[j], n[k]])
        while j < k and n[j] == n[j + 1]:
          j += 1
        while j < k and n[k] == n[k - 1]:
          k -= 1
        j += 1
        k -= 1

```

* **Explanation:**
* `else:` (Triggered when `t == 0`): A valid triplet is found and appended to our result list `r`.
* Inner `while` loops: Skip consecutive duplicate values for both pointers (`j` and `k`) to prevent identical triplets from being added.
* `j += 1` and `k -= 1`: Move both pointers inward to look for the next distinct pair.



---

###### 8. Returning the Result

```python
  return r

```

* **Explanation:**
* Returns the final list of unique triplets `r`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^2)$ | Sorting takes $O(N \log N)$ time, and the nested structure of the outer loop combined with the inner two-pointer scan takes $O(N^2)$ time, which dominates the overall runtime. |
| **Space Complexity** | $O(1)$ or $O(N)$ | Auxiliary space required depends on Python's underlying Timsort implementation (typically $O(N)$ space for sorting references), excluding the output list storage. |
