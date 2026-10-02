### Palindrome Number — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to determine whether an integer `x` is a palindrome (reads the same backward as forward).

Instead of converting the integer to a string (which requires extra space) or reversing the entire integer (which risks 32-bit integer overflow), this solution reverses **only half** of the integer and compares it with the remaining first half. This achieves optimal **$O(\log_{10}(x))$ time complexity** and **$O(1)$ space complexity**.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int r = 0;

        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }

        return x == r || x == r / 10;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class Definition

```java
//anxshh
class Solution {

```

* **Explanation:** Standard LeetCode class wrapper definition.



---

##### 2. Method Signature & Base Condition Checks

```java
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

```

* **Explanation:**
* `public boolean isPalindrome(int x)`: Method declaration that accepts an integer `x` and returns `true` if `x` is a palindrome, otherwise `false`.
* `x < 0`: Negative numbers are never palindromes because of the leading minus sign (e.g., `-121` reversed is `121-`).
* `(x % 10 == 0 && x != 0)`: Any non-zero number ending in `0` cannot be a palindrome because a number cannot start with `0` (e.g., `10` reversed is `01`, which equals `1`).



---

##### 3. Reversed Variable Initialization

```java
        int r = 0;

```

* **Explanation:**
* Initializes variable `r` (reversed number) to `0`. It will store the trailing digits extracted from `x` in reversed order.



---

##### 4. Half-Reversal Loop

```java
        while (x > r) {
            r = r * 10 + x % 10;
            x /= 10;
        }

```

* **Explanation:**
* `while (x > r)`: Continues looping as long as `x` is greater than `r`. Once `x <= r`, it means we have processed at least half of the digits.
* `x % 10`: Extracts the last (rightmost) digit of `x`.


* `r = r * 10 + x % 10`: Shifts `r` one decimal place to the left and appends the extracted digit.


* `x /= 10`: Removes the last digit from `x` by integer division.





---

##### 5. Equality Verification

```java
        return x == r || x == r / 10;
    }
}

```

* **Explanation:**
* **Odd vs. Even Digit Lengths:**
* `x == r`: For numbers with an **even** number of digits (e.g., `1221`), after processing half the digits, `x` becomes `12` and `r` becomes `12`. They match directly.
* `x == r / 10`: For numbers with an **odd** number of digits (e.g., `12321`), after processing, `x` becomes `12` and `r` becomes `123`. The middle digit (`3`) is discarded by doing `r / 10` (yielding `12`), enabling a correct comparison.





---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log_{10}(x))$ | We divide the input integer by 10 in every iteration, so the loop runs for only half the total number of digits. |
| **Space Complexity** | $O(1)$ | Uses a fixed amount of extra memory (constant space) without allocating strings or arrays.

 |
