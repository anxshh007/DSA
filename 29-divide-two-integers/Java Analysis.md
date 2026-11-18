##### Divide Two Integers — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to divide two integers (`a` and `b`) without using multiplication, division, and modulo operators. To handle edge cases and optimize performance, the solution uses bit manipulation (left shifts) to subtract multiples of the divisor efficiently, achieving an **$O(\log n)$** time complexity and **$O(1)$** space complexity.

---

###### Complete Solution Code

```java
class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        int q = 0;

        while (x >= y) {
            long t = y;
            int p = 1;

            while (x >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }

            x -= t;
            q += p;
        }

        return (a < 0) ^ (b < 0) ? -q : q;
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```java
class Solution {
    public int divide(int a, int b) {

```

* **Explanation:** Standard LeetCode class and method definition taking dividend `a` and divisor `b`.

---

###### 2. Overflow Edge Case Handling

```java
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

```

* **Explanation:** In 32-bit signed integers, `Integer.MIN_VALUE` is $-2147483648$ and `Integer.MAX_VALUE` is $2147483647$. Dividing $-2147483648$ by $-1$ results in $2147483648$, which exceeds `Integer.MAX_VALUE`. This explicit check catches this overflow condition and returns `Integer.MAX_VALUE`.

---

###### 3. Absolute Value Conversion & Initialization

```java
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        int q = 0;

```

* **Explanation:**
* Casts `a` and `b` to `long` and takes their absolute values to avoid overflow during conversion and simplify calculations.
* Initializes the quotient accumulator `q` to `0`.



---

###### 4. Main Division Loop

```java
        while (x >= y) {

```

* **Explanation:** Continues subtracting chunks of the divisor from the dividend as long as the remaining dividend `x` is greater than or equal to divisor `y`.

---

###### 5. Exponential Search Setup

```java
            long t = y;
            int p = 1;

```

* **Explanation:**
* `t` tracks the current shifted divisor value.
* `p` tracks the corresponding power of 2 multiplier (quotient increment).



---

###### 6. Bitwise Shift Loop (Exponential Growth)

```java
            while (x >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }

```

* **Explanation:** Doubles the divisor `t` and the multiplier `p` using left bit shift (`<< 1`) as long as the doubled divisor does not exceed the remaining dividend `x`. This speeds up division significantly compared to subtracting one by one.

---

###### 7. Subtraction and Quotient Update

```java
            x -= t;
            q += p;
        }

```

* **Explanation:**
* `x -= t`: Subtracts the largest found shifted divisor from the remaining dividend.
* `q += p`: Adds the corresponding multiplier to the total quotient `q`.



---

###### 8. Sign Adjustment and Return

```java
        return (a < 0) ^ (b < 0) ? -q : q;
    }
}

```

* **Explanation:** Uses the XOR operator `^` to check if exactly one of the inputs is negative. If their signs differ, it returns `-q`; otherwise, it returns positive `q`.

---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log n)$ | The bit-shifting approach reduces the number of operations logarithmically based on the magnitude of the dividend. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory for primitive variables. |
