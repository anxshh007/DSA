# Roman to Integer — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to convert a Roman numeral string `s` into its corresponding integer value.

Roman numerals are represented by seven standard symbols: `I` (1), `V` (5), `X` (10), `L` (50), `C` (100), `D` (500), and `M` (1000). Typically, Roman numerals are written from largest to smallest from left to right. However, when a smaller value symbol appears **before** a larger value symbol, subtraction is performed (for example, `IV` represents 4 and `IX` represents 9).

This solution traverses the string **right-to-left (from back to front)**. By maintaining a tracker for the maximum Roman numeral value encountered so far (`p`), it determines whether each character's value should be **added** or **subtracted** from the total sum. It achieves an optimal **$\mathcal{O}(N)$ time complexity** and **$\mathcal{O}(1)$ space complexity**.

---

## Complete Solution Code

```java
//anxshh007
class Solution {
    public int romanToInt(String s) {
        int[] v = new int[91];
        v['I'] = 1;
        v['V'] = 5;
        v['X'] = 10;
        v['L'] = 50;
        v['C'] = 100;
        v['D'] = 500;
        v['M'] = 1000;

        int r = 0;
        int p = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int a = v[s.charAt(i)];

            if (a < p)
                r -= a;
            else {
                r += a;
                p = a;
            }
        }

        return r;
    }
}

```

---

## Line-by-Line Code Analysis

### 1. Class Definition

```java
//anxshh007
class Solution {

```

* **Explanation:** Standard LeetCode class wrapper definition.



---

### 2. Method Signature & Direct Index Lookup Array Setup

```java
    public int romanToInt(String s) {
        int[] v = new int[91];
        v['I'] = 1;
        v['V'] = 5;
        v['X'] = 10;
        v['L'] = 50;
        v['C'] = 100;
        v['D'] = 500;
        v['M'] = 1000;

```

* **Explanation:**
* `public int romanToInt(String s)`: Defines the method taking a Roman numeral string `s` and returning its integer representation.


* `int[] v = new int[91]`: Creates an integer array of size 91 to act as a fast direct-address hash table.


* `v['I'] = 1 ... v['M'] = 1000`: Assigns values directly at the ASCII index of each uppercase Roman character. Since `'X'` has an ASCII value of 88, array size 91 is sufficient to store all relevant character mappings without requiring a `HashMap` or `switch` block.



---

### 3. Accumulator & Previous Maximum Variable Tracking

```java
        int r = 0;
        int p = 0;

```

* **Explanation:**
* `int r = 0`: Represents the accumulated total sum (`result`).


* `int p = 0`: Stores the previous/highest value encountered so far while traversing from right to left (`previous max`).



---

### 4. Right-to-Left Loop Traversal

```java
        for (int i = s.length() - 1; i >= 0; i--) {
            int a = v[s.charAt(i)];

```

* **Explanation:**
* `for (int i = s.length() - 1; i >= 0; i--)`: Loops through string `s` in reverse order (from last character to first character).


* `int a = v[s.charAt(i)]`: Fetches the numerical value corresponding to the character at position `i` directly from array `v`.



---

### 5. Subtraction vs. Addition Decision Logic

```java
            if (a < p)
                r -= a;
            else {
                r += a;
                p = a;
            }
        }

```

* **Explanation:**
* `if (a < p)`: If the current character's value `a` is strictly smaller than `p` (the maximum value seen to its right), it indicates a subtractive combination (e.g., `'I'` before `'V'` or `'X'`). Hence, `a` is subtracted from total result `r`.
* `else`: If current value `a` is greater than or equal to `p`, it is an additive component. It adds `a` to `r` and updates `p = a` as the new threshold for subsequent steps.



---

### 6. Return Result

```java
        return r;
    }
}

```

* **Explanation:**
* `return r`: Returns the final accumulated integer value after iterating through the full string.





---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(N)$ | The string `s` of length $N$ is traversed exactly once from right to left.

 |
| **Space Complexity** | $\mathcal{O}(1)$ | Uses a fixed-size primitive array of length 91 (`v`) and a few integer variables, independent of input string length.

 |
