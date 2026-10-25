### Reverse Integer — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to reverse a 32-bit signed integer `x`. If reversing `x` causes the value to go outside the 32-bit signed integer range $[-2^{31}, 2^{31} - 1]$ (which corresponds to $[-2147483648, 2147483647]$), the function must return `0`.

Instead of converting the integer to a string or using 64-bit data types (`long`), this solution reverses the integer digit by digit while checking for potential **overflow and underflow** *before* doing the multiplication step, ensuring $O(\log_{10}(\vert{}x\vert{}))$ time complexity and $O(1)$ space complexity.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
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

##### 2. Method Signature & Result Initialization

```java
    public int reverse(int x) {
        int result = 0;

```

* **Explanation:**
* `public int reverse(int x)`: Method declaration taking a 32-bit integer `x` and returning its reversed integer form.
* `int result = 0`: Variable initialized to store the accumulated reversed integer.



---

##### 3. Main Reversal Loop

```java
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

```

* **Explanation:**
* `while (x != 0)`: Continues looping until all digits of `x` have been processed. Works for both positive and negative integers.
* `int digit = x % 10`: Extracts the rightmost (least significant) digit of `x`.
* `x /= 10`: Removes the rightmost digit from `x` by performing integer division.



---

##### 4. Overflow Guard Check

```java
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

```

* **Explanation:**
* Checks if executing `result = result * 10 + digit` will cause a positive integer overflow beyond `Integer.MAX_VALUE` ($2147483647$).
* `result > Integer.MAX_VALUE / 10`: If `result` is already greater than $214748364$, multiplying by 10 will exceed the maximum limits.
* `result == Integer.MAX_VALUE / 10 && digit > 7`: If `result` equals $214748364$, adding a digit greater than $7$ will exceed $2147483647$.
* Returns `0` immediately if overflow is detected.



---

##### 5. Underflow Guard Check

```java
            if (result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

```

* **Explanation:**
* Checks if executing `result = result * 10 + digit` will cause a negative integer underflow beyond `Integer.MIN_VALUE` ($-2147483648$).
* `result < Integer.MIN_VALUE / 10`: If `result` is less than $-214748364$, multiplying by 10 will go below the minimum limits.
* `result == Integer.MIN_VALUE / 10 && digit < -8`: If `result` equals $-214748364$, adding a negative digit smaller than $-8$ will go below $-2147483648$.
* Returns `0` immediately if underflow is detected.



---

##### 6. Digit Accumulation

```java
            result = result * 10 + digit;
        }

```

* **Explanation:**
* Shifts the existing digits in `result` one decimal place to the left (by multiplying by 10) and appends the extracted `digit`.



---

##### 7. Return Result

```java
        return result;
    }
}

```

* **Explanation:**
* Returns the final reversed 32-bit integer once all digits of `x` have been processed without overflow or underflow.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log_{10}(\vert{}x\vert{}))$ | The number of digits in an integer $x$ is approximately $\log_{10}(\vert{}x\vert{})$. The loop executes once per digit. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory ($O(1)$ auxiliary space). |
