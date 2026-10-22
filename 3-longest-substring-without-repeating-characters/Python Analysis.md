### Longest Substring Without Repeating Characters — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find the length of the **longest substring** without repeating characters. It utilizes the **sliding window technique** optimized with a hash map (dictionary) tracking character indices, achieving an optimal **$O(N)$** **time complexity**.

---

#### Complete Solution Code

```python
class Solution:

    def lengthOfLongestSubstring(self, s: str) -> int:
        d, l, m = {}, 0, 0
        for r, c in enumerate(s):
            if c in d and d[c] >= l:
                l = d[c] + 1
            d[c] = r
            m = max(m, r - l + 1)
        return m

```

---

#### Line-by-Line Code Analysis

##### 1. Class Definition

```python
class Solution:

```

* **Explanation:** Defines the standard LeetCode class wrapper `Solution`.

---

##### 2. Method Signature

```python
    def lengthOfLongestSubstring(self, s: str) -> int:

```

* **Explanation:**
* `lengthOfLongestSubstring`: The method name taking an input string `s`.
* `s: str -> int`: Type hints indicating that input `s` is a string and the return value is an integer representing the maximum length of a substring without duplicate characters.



---

##### 3. Variable Initialization

```python
        d, l, m = {}, 0, 0

```

* **Explanation:**
* `d = {}`: Initializes an empty dictionary (hash map) to store the most recent index where each character was seen (`d[character] = index`).
* `l = 0`: `l` represents the **left** pointer boundary of the active sliding window (0-indexed).
* `m = 0`: `m` stores the **maximum** length of valid non-repeating substrings found so far.



---

##### 4. Sliding Window Expansion with Enumeration

```python
        for r, c in enumerate(s):

```

* **Explanation:**
* Iterates through the string `s` using Python's `enumerate()` function.
* `r` acts as the **right** pointer boundary index (0, 1, 2, ...).
* `c` represents the current character at index `r`.



---

##### 5. Duplicate Check & Left Boundary Update

```python
            if c in d and d[c] >= l:
                l = d[c] + 1

```

* **Explanation:**
* `c in d`: Checks if the character `c` has been encountered previously in the string.
* `d[c] >= l`: Checks if the last seen index of character `c` lies **inside** the current active sliding window (at or after the `l` pointer).
* `l = d[c] + 1`: If a duplicate character exists within our active window, we jump the left pointer `l` immediately past the duplicate's previous index (`d[c] + 1`) to eliminate the repetition from the window.



---

##### 6. Updating Character Index Map

```python
            d[c] = r

```

* **Explanation:**
* Updates or inserts the latest index `r` for character `c` in dictionary `d`.
* This ensures `d[c]` always stores the most recent location of character `c`.



---

##### 7. Calculating & Updating Maximum Substring Length

```python
            m = max(m, r - l + 1)

```

* **Explanation:**
* `r - l + 1`: Calculates the length of the current valid substring bounded between indices `l` and `r` inclusive.
* `max(m, ...)`: Updates `m` if the current window length is greater than the previous maximum length found.



---

##### 8. Returning Final Result

```python
        return m

```

* **Explanation:** Returns `m`, the overall length of the longest substring without duplicate characters after traversing the whole string.

---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The string `s` of length $N$ is traversed once using the `r` pointer. Dictionary lookup and update operations run in $O(1)$ average time. |
| **Space Complexity** | $O(\min(N, M))$ | $O(k)$ extra space where $k$ is the size of the dictionary `d`. In the worst case, $k$ is bounded by the alphabet size $M$ or length of string $N$. |
