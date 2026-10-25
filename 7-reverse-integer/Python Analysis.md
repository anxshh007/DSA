##### Reverse Integer (Python) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to reverse a 32-bit signed integer `x`. If reversing `x` causes the value to go outside the 32-bit signed integer range $[-2^{31}, 2^{31} - 1]$ (i.e., $[-2147483648, 2147483647]$), the function must return `0`.

This Pythonic solution handles negative numbers by extracting the sign, converting the absolute value to a string to easily reverse it via slicing (`[::-1]`), converting it back to an integer, restoring the sign, and finally checking if the result fits within the 32-bit bounds.

---

###### Complete Solution Code

```python
class Solution:
    def reverse(self, x: int) -> int:
        s = -1 if x < 0 else 1 
        r = int(str(x * s)[::-1]) * s
        return r if -2**31 <= r < 2**31 else 0 

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Definition

```python
class Solution:
    def reverse(self, x: int) -> int:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def reverse(self, x: int) -> int:`: Method definition taking a 32-bit integer `x` and returning its reversed integer form.



---

###### 2. Sign Determination

```python
        s = -1 if x < 0 else 1 

```

* **Explanation:**
* Determines whether the input integer `x` is negative or positive using a conditional inline expression.
* If `x` is less than `0`, `s` is set to `-1` (negative); otherwise, `s` is set to `1` (positive). This allows us to work with the absolute value of `x` for the reversal step.



---

###### 3. String Conversion, Reversal, and Sign Restoration

```python
        r = int(str(x * s)[::-1]) * s

```

* **Explanation:**
* `x * s`: Multiplies `x` by its sign factor `s` to get its absolute positive value.
* `str(...)`: Converts the absolute integer into a string so that string manipulation can be applied.
* `[::-1]`: Uses Python's slice notation with a step of `-1` to reverse the string characters entirely from end to start.
* `int(...)`: Converts the reversed string back into a standard integer.
* `* s`: Multiplies the reversed number by the original sign (`s`), restoring it to negative if `x` was originally negative.



---

###### 4. Range Validation and Return Statement

```python
        return r if -2**31 <= r < 2**31 else 0 

```

* **Explanation:**
* Checks if the reversed integer `r` falls within the valid 32-bit signed integer range $[-2^{31}, 2^{31} - 1]$ (i.e., $-2147483648$ to $2147483647$).
* If `r` is within bounds, it returns `r`. Otherwise, it returns `0` as per the problem constraints.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(\log_{10}(\vert{}x\vert{}))$ | Converting the integer to a string and reversing it takes time proportional to the number of digits in `x`. |
| **Space Complexity** | $\mathcal{O}(\log_{10}(\vert{}x\vert{}))$ | Memory is allocated to store the string representation of the integer whose length is proportional to the number of digits. |
