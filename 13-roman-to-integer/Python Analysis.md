##### Roman to Integer — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to convert a Roman numeral string `s` into its corresponding integer value. Roman numerals are represented by seven standard symbols: I (1), V (5), X (10), L (50), C (100), D (500), and M (1000). When a smaller value symbol appears before a larger value symbol, subtraction is performed (e.g., IV = 4). This Python solution traverses the string from right to left, maintaining a tracking variable for the previous value to decide whether to add or subtract each component. It achieves optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```python
def romanToInt(s: str) -> int:
    d, t, p = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}, 0, 0
    for c in reversed(s):
        v = d[c]
        t += -v if v < p else v
        p = v
    return t

```

---

###### Line-by-Line Code Analysis

###### 1. Method Signature

```python
def romanToInt(s: str) -> int:

```

* **Explanation:** Defines the function taking a Roman numeral string `s` as input and returning an integer.

---

###### 2. Dictionary & Variables Initialization

```python
    d, t, p = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}, 0, 0

```

* **Explanation:**
* `d`: A dictionary mapping each Roman numeral character to its integer value.
* `t`: An accumulator variable initialized to `0` to store the final running total.
* `p`: A tracker variable initialized to `0` to record the value of the previously processed symbol.



---

###### 3. Right-to-Left Traversal Loop

```python
    for c in reversed(s):

```

* **Explanation:** Iterates through the input string `s` in reverse order (from the last character to the first character).

---

###### 4. Character Value Lookup

```python
        v = d[c]

```

* **Explanation:** Looks up and stores the numerical value of the current character `c` in variable `v`.

---

###### 5. Subtractive vs. Additive Logic & Tracking Update

```python
        t += -v if v < p else v
        p = v

```

* **Explanation:**
* `t += -v if v < p else v`: If the current value `v` is smaller than the previous value `p` (e.g., 'I' before 'V'), it represents a subtractive pair, so `v` is subtracted from total `t`. Otherwise, it is added to `t`.
* `p = v`: Updates `p` to the current value `v` for the next iteration.



---

###### 6. Return Result

```python
    return t

```

* **Explanation:** Returns the final accumulated integer value after processing all characters.

---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The string `s` of length $N$ is traversed exactly once in reverse order. |
| **Space Complexity** | $O(1)$ | Uses a fixed-size dictionary mapping 7 characters and a few scalar variables, independent of input size. |
