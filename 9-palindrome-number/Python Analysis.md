##### Palindrome Number (LeetCode Problem 9) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to determine whether an integer `x` is a palindrome (reads the same backward as forward). Instead of converting the integer to a string (which requires extra space) or reversing the entire integer (which risks overflow), this solution reverses **only half** of the integer and compares it with the remaining first half. This achieves optimal **$O(\log_{10}(x))$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        r = 0
        while x > r:
            r = r * 10 + x % 10
            x //= 10
        return x == r or x == r // 10

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def isPalindrome(self, x: int) -> bool:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def isPalindrome(self, x: int) -> bool:`: Method declaration that accepts an integer `x` and returns a boolean value (`True` if it is a palindrome, `False` otherwise).



---

###### 2. Base Condition Checks

```python
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

```

* **Explanation:**
* `x < 0`: Negative numbers are never palindromes because of the leading minus sign (e.g., `-121` reversed becomes `121-`).
* `(x % 10 == 0 and x != 0)`: Any non-zero number ending in `0` cannot be a palindrome because a number cannot start with `0` (e.g., `10` reversed becomes `01`, which equals `1`).



---

###### 3. Reversed Variable Initialization

```python
        r = 0

```

* **Explanation:**
* Initializes variable `r` (reversed number) to `0`. It will store the trailing digits extracted from `x` in reversed order.



---

###### 4. Half-Reversal Loop

```python
        while x > r:
            r = r * 10 + x % 10
            x //= 10

```

* **Explanation:**
* `while x > r:`: Continues looping as long as `x` is greater than `r`. Once `x <= r`, it means we have processed at least half of the digits.
* `r = r * 10 + x % 10`: Extracts the last (rightmost) digit of `x` using modulo (`x % 10`), shifts `r` one decimal place to the left (`r * 10`), and appends the digit.
* `x //= 10`: Removes the last digit from `x` using integer division.



---

###### 5. Equality Verification & Return

```python
        return x == r or x == r // 10

```

* **Explanation:**
* **Even vs. Odd Digit Lengths:**
* `x == r`: For numbers with an **even** number of digits (e.g., `1221`), after processing half the digits, `x` becomes `12` and `r` becomes `12`. They match directly.
* `x == r // 10`: For numbers with an **odd** number of digits (e.g., `12321`), after processing, `x` becomes `12` and `r` becomes `123`. The middle digit (`3`) is discarded by doing integer division `r // 10` (yielding `12`), enabling a correct comparison.





---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log_{10}(x))$ | We divide the input integer by 10 in every iteration, so the loop runs for only half the total number of digits. |
| **Space Complexity** | $O(1)$ | Uses a fixed amount of extra memory (constant space) without allocating extra strings or arrays. |
