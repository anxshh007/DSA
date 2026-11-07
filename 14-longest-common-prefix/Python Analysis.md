### Longest Common Prefix (LeetCode Problem 14) — Python Solution Breakdown & Code Walkthrough

#### Overview

This Python solution finds the **longest common prefix** among an array of strings using a clever lexicographical trick. Instead of scanning every string character-by-character, it identifies the lexicographically smallest (`min`) and largest (`max`) strings in the list. Because strings are ordered alphabetically, any common prefix shared by all strings must also be a prefix of both the smallest and largest strings. This reduces the problem to simply comparing these two extreme strings.

---

#### Complete Solution Code

```python
class Solution:
    def longestCommonPrefix(self, v: list[str]) -> str:
        a, b = min(v), max(v)
        for i, c in enumerate(a):
            if c != b[i]: return a[:i]
        return a

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```python
class Solution:
    def longestCommonPrefix(self, v: list[str]) -> str:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper.
* `def longestCommonPrefix(self, v: list[str]) -> str:`: Defines the method taking a list of strings (`v`) and returning the longest common prefix string.



##### 2. Finding Lexicographical Extremes

```python
        a, b = min(v), max(v)

```

* **Explanation:**
* `min(v)` finds the lexicographically smallest string in the list.
* `max(v)` finds the lexicographically largest string in the list.
* Because all other strings in the list fall alphabetically between these two, any common prefix of the entire array must match the prefix of both `a` and `b`.



##### 3. Iterating Through Characters of the Smallest String

```python
        for i, c in enumerate(a):

```

* **Explanation:**
* Loops through each character `c` of the smallest string `a` along with its index `i` using `enumerate()`. We only need to check up to the length of `a` since a common prefix cannot be longer than the shortest string.



##### 4. Comparing Characters and Returning Mismatch Cutoff

```python
            if c != b[i]: return a[:i]

```

* **Explanation:**
* Compares character `c` with the character at the same index in the largest string (`b[i]`).
* If they differ, it means the common prefix ends right before index `i`. It immediately slices and returns the prefix up to that point (`a[:i]`).



##### 5. Returning the Full Smallest String

```python
        return a

```

* **Explanation:**
* If the loop finishes without finding any mismatch, it means `a` is completely identical to the prefix of `b` (i.e., `a` is a prefix of all strings in the list). Thus, `a` itself is returned as the longest common prefix.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \log N + M)$ | Finding `min` and `max` takes $O(N \times L)$ time where $N$ is the number of strings and $L$ is their average length, while the character comparison loop takes $O(M)$ time where $M$ is the length of the shortest string. |
| **Space Complexity** | $O(1)$ | Uses constant auxiliary space as no additional data structures or dynamic memory allocations are required. |

---

Would you like to explore how this lexicographical approach compares in execution speed against horizontal or vertical scanning methods for this problem?
