##### Integer to Roman (LeetCode Problem 12) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to convert an integer `n` into its corresponding Roman numeral string representation. This solution uses a **greedy strategy** with two parallel lookup arrays ordered from largest to smallest value (`v` for numerical values and `s` for Roman symbols). By using integer division and modulo (`divmod`) to find how many times each symbol fits into `n`, it builds the result efficiently with an optimal **$\mathcal{O}(1)$ time complexity** and **$\mathcal{O}(1)$ space complexity**.

---

###### Complete Solution Code

```python
class Solution:
    def intToRoman(self, n: int) -> str:
        v = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        s = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        r = []
        for i, val in enumerate(v):
            if n == 0:
                break
            d, n = divmod(n, val)
            r.append(s[i] * d)
        return "".join(r)

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def intToRoman(self, n: int) -> str:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def intToRoman(self, n: int) -> str:`: Method declaration that accepts an integer `n` and returns its Roman numeral representation as a string.



---

###### 2. Lookup Mapping Arrays Initialization

```python
        v = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        s = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]

```

* **Explanation:**
* `v`: An array storing numerical values sorted in strictly descending order, including both standard symbols (1000, 500, etc.) and subtractive combination values (900, 400, 90, 40, 9, 4).
* `s`: A parallel string array where `s[i]` holds the exact Roman numeral symbol corresponding to the value at `v[i]`.



---

###### 3. Result List Initialization

```python
        r = []

```

* **Explanation:**
* Initializes an empty list `r` to accumulate the generated Roman numeral chunks.



---

###### 4. Greedy Iteration Loop

```python
        for i, val in enumerate(v):
            if n == 0:
                break
            d, n = divmod(n, val)
            r.append(s[i] * d)

```

* **Explanation:**
* `for i, val in enumerate(v):`: Iterates through each value and its index in the descending array `v`.
* `if n == 0: break`: Optimizes execution by stopping early once all parts of `n` have been processed.
* `d, n = divmod(n, val)`: Calculates how many times the current value `val` fits into `n` (`d`), and updates `n` to the remainder using Python's built-in `divmod` function.
* `r.append(s[i] * d)`: Repeats the Roman symbol `s[i]` `d` times (e.g., repeating `"M"` three times for `3000`) and appends it to the results list `r`.



---

###### 5. Combining and Returning the Result

```python
        return "".join(r)

```

* **Explanation:**
* `"".join(r)`: Concatenates all individual string chunks stored in list `r` into a single final Roman numeral string and returns it.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(1)$ | The lookup arrays have a fixed length of 13, and `n` is constrained within standard LeetCode bounds (up to $3999$). The number of operations is bounded by a constant. |
| **Space Complexity** | $\mathcal{O}(1)$ | Uses a constant amount of extra memory for the fixed-size lookup arrays and result storage. |
