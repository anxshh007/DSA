### Regular Expression Matching (LeetCode Problem 10) — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to implement regular expression matching with support for `.` (matches any single character) and `*` (matches zero or more of the preceding element). It uses **Dynamic Programming (Bottom-Up)** to evaluate match validity across all prefix combinations of string `s` and pattern `p`. This approach achieves an **$O(M \times N)$ time complexity** and **$O(M \times N)$ space complexity**, where $M$ is the length of `s` and $N$ is the length of `p`.

---

#### Complete Solution Code

```python
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        d = [[False] * (n + 1) for _ in range(m + 1)]
        d[0][0] = True
        for j in range(1, n + 1):
            if p[j - 1] == '*':
                d[0][j] = d[0][j - 2]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] == '*':
                    d[i][j] = d[i][j - 2] or (
                        d[i - 1][j] and (p[j - 2] == '.' or p[j - 2] == s[i - 1])
                    )
                else:
                    d[i][j] = d[i - 1][j - 1] and (
                        p[j - 1] == '.' or p[j - 1] == s[i - 1]
                    )
        return d[m][n]

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```python
class Solution:
    def isMatch(self, s: str, p: str) -> bool:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def isMatch(self, s: str, p: str) -> bool:`: Defines the method taking input string `s` and pattern `p`, returning a boolean value (`True` if they match, `False` otherwise).



---

##### 2. Length Variables & DP Table Initialization

```python
        m, n = len(s), len(p)
        d = [[False] * (n + 1) for _ in range(m + 1)]

```

* **Explanation:**
* `m, n = len(s), len(p)`: Stores the lengths of string `s` (`m`) and pattern `p` (`n`).
* `d = [[False] * (n + 1) for _ in range(m + 1)]`: Creates a 2D boolean dynamic programming table of dimensions $(m + 1) \times (n + 1)$ initialized to `False`. Each entry `d[i][j]` tracks whether the prefix of `s` of length `i` matches the prefix of `p` of length `j`.



---

##### 3. Base Case Initialization

```python
        d[0][0] = True

```

* **Explanation:**
* `d[0][0] = True`: An empty string (`s` of length 0) matches an empty pattern (`p` of length 0), so this base case is set to `True`.



---

##### 4. Handling Empty String Matching with Star Patterns

```python
        for j in range(1, n + 1):
            if p[j - 1] == '*':
                d[0][j] = d[0][j - 2]

```

* **Explanation:**
* Handles patterns like `a*`, `a*b*`, or `a*b*c*` matching an empty string (`s` of length 0).
* If the character at index `j - 1` in `p` is `*`, it can match zero occurrences of the preceding element, so `d[0][j]` inherits the match state from two positions back (`d[0][j - 2]`).



---

##### 5. Nested Loops Traversing String and Pattern

```python
        for i in range(1, m + 1):
            for j in range(1, n + 1):

```

* **Explanation:**
* Outer loop iterates through each character length of `s` (from `1` to `m`).
* Inner loop iterates through each character length of `p` (from `1` to `n`).



---

##### 6. Handling '*' Wildcard (Zero or More Occurrences)

```python
                if p[j - 1] == '*':
                    d[i][j] = d[i][j - 2] or (
                        d[i - 1][j] and (p[j - 2] == '.' or p[j - 2] == s[i - 1])
                    )

```

* **Explanation:**
* Executes when the pattern character at `j - 1` is `*`.
* **Zero occurrences (`d[i][j - 2]`):** Ignores the `*` and its preceding element.
* **One or more occurrences (`d[i - 1][j] and ...`):** Checks if the preceding pattern character (`p[j - 2]`) matches the current string character (`s[i - 1]`) or is `.`, and checks if the remaining string `s` of length `i - 1` matches the pattern.



---

##### 7. Handling Regular Characters or '.' Wildcard

```python
                else:
                    d[i][j] = d[i - 1][j - 1] and (
                        p[j - 1] == '.' or p[j - 1] == s[i - 1]
                    )

```

* **Explanation:**
* Executes when the pattern character is not `*`.
* Checks if the previous prefixes matched (`d[i - 1][j - 1]`) and the current pattern character matches the current string character (either because they are equal or `p[j - 1]` is `.`).



---

##### 8. Returning Final Match State

```python
        return d[m][n]

```

* **Explanation:**
* Returns `d[m][n]`, which indicates whether the entire string `s` matches the entire pattern `p`.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(M \times N)$ | The nested loops iterate over all combinations of prefixes of string `s` (length $M$) and pattern `p` (length $N$). |
| **Space Complexity** | $O(M \times N)$ | A 2D DP table of size $(M + 1) \times (N + 1)$ is allocated in memory. |
