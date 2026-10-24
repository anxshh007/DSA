### Longest Palindromic Substring — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find the **longest palindromic substring** in a given string `s`. It implements **Manacher's Algorithm**, an optimal approach that solves the problem in **$O(N)$ time complexity** and **$O(N)$ space complexity**. By pre-processing the string with dummy separators (like `#`), it handles odd-length and even-length palindromes uniformly and leverages previously computed palindrome symmetries to avoid redundant character comparisons.

---

#### Complete Solution Code

```python
class Solution:

  def longestPalindrome(self, s: str) -> str:
    t = "#" + "#".join(s) + "#"
    n = len(t)
    p = [0] * n
    c = r = 0
    m_i = m_l = 0

    for i in range(n):
      i_m = 2 * c - i
      if r > i:
        p[i] = min(r - i, p[i_m])

      while (
          i + 1 + p[i] < n
          and i - 1 - p[i] >= 0
          and t[i + 1 + p[i]] == t[i - 1 - p[i]]
      ):
        p[i] += 1

      if i + p[i] > r:
        c, r = i, i + p[i]

      if p[i] > m_l:
        m_l, m_i = p[i], i

    st = (m_i - m_l) // 2
    return s[st : st + m_l]

```

---

#### Line-by-Line Code Analysis

##### 1. Class Definition & Method Signature

```python
class Solution:

  def longestPalindrome(self, s: str) -> str:

```

* **Explanation:**
* Defines the LeetCode class wrapper `Solution`.
* `longestPalindrome(self, s: str) -> str`: Takes an input string `s` and returns its longest palindromic substring.



---

##### 2. String Preprocessing

```python
    t = "#" + "#".join(s) + "#"
    n = len(t)

```

* **Explanation:**
* `t = "#" + "#".join(s) + "#"`: Transforms the string by inserting `#` between every character and at both ends (e.g., `"aba"` becomes `"#a#b#a#"`). This trick ensures that both odd-length and even-length palindromes are treated uniformly as odd-length palindromes centered at characters or `#`.
* `n = len(t)`: Stores the total length of the transformed string `t`.



---

##### 3. Initializing Tracking Arrays and Pointers

```python
    p = [0] * n
    c = r = 0
    m_i = m_l = 0

```

* **Explanation:**
* `p = [0] * n`: An array where `p[i]` stores the radius of the palindrome centered at index `i` in the transformed string `t`.
* `c = r = 0`: `c` tracks the center of the rightmost palindrome found so far, and `r` tracks its right boundary.
* `m_i = m_l = 0`: `m_i` tracks the center index and `m_l` tracks the maximum palindrome radius found overall across the string.



---

##### 4. Main Iteration & Symmetry Utilization

```python
    for i in range(n):
      i_m = 2 * c - i
      if r > i:
        p[i] = min(r - i, p[i_m])

```

* **Explanation:**
* `for i in range(n):` Iterates through each index `i` of the transformed string `t` as a potential palindrome center.
* `i_m = 2 * c - i`: Calculates the mirror image index of `i` with respect to the current center `c`.
* `if r > i: p[i] = min(r - i, p[i_m])`: If the current index `i` is within the right boundary `r` of the current rightmost palindrome, Manacher's algorithm utilizes symmetry to initialize `p[i]` to at least the minimum of the remaining distance (`r - i`) and the mirror's radius (`p[i_m]`), avoiding redundant checks.



---

##### 5. Expanding Around the Center

```python
      while (
          i + 1 + p[i] < n
          and i - 1 - p[i] >= 0
          and t[i + 1 + p[i]] == t[i - 1 - p[i]]
      ):
        p[i] += 1

```

* **Explanation:**
* Expands outward from center `i` by checking if characters at symmetrical positions to the left and right match (`t[i + 1 + p[i]] == t[i - 1 - p[i]]`) while staying within valid string bounds (`n` and `0`).
* `p[i] += 1`: Increments the palindrome radius for center `i` as long as matching characters are found.



---

##### 6. Updating Center and Right Boundary

```python
      if i + p[i] > r:
        c, r = i, i + p[i]

```

* **Explanation:**
* If the newly expanded palindrome at index `i` extends beyond the current right boundary `r`, the current center `c` is updated to `i`, and the right boundary `r` is updated to `i + p[i]`.



---

##### 7. Tracking the Overall Longest Palindrome

```python
      if p[i] > m_l:
        m_l, m_i = p[i], i

```

* **Explanation:**
* Compares the radius `p[i]` against the global maximum length `m_l`. If a larger palindrome radius is found, `m_l` and the center position `m_i` are updated.



---

##### 8. Result Mapping and Extraction

```python
    st = (m_i - m_l) // 2
    return s[st : st + m_l]

```

* **Explanation:**
* `st = (m_i - m_l) // 2`: Converts the center index and radius from the transformed string space (`t`) back to the starting index in the original string `s`.
* `return s[st : st + m_l]`: Extracts and returns the longest palindromic substring from the original string `s`.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(N)$ | Manacher's algorithm processes each character in linear time by leveraging previously computed palindrome boundaries and avoiding redundant comparisons. |
| **Space Complexity** | $\mathcal{O}(N)$ | Auxiliary space is proportional to the length of the transformed string `t` and the radius array `p`. |
