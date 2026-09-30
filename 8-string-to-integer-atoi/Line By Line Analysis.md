### String to Integer (atoi) — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to implement the `myAtoi(String s)` function, which converts a string to a 32-bit signed integer (similar to C/C++'s `atoi` function). The process involves discarding leading whitespace, identifying an optional sign character (`+` or `-`), processing numerical digits while building the integer, and clamping the output to 32-bit signed integer limits ($[-2^{31}, 2^{31} - 1]$, or $[-2147483648, 2147483647]$) if overflow or underflow occurs.

This solution uses a 64-bit integer (`long`) to store intermediate accumulated values, enabling direct comparison against 32-bit integer boundaries during extraction. This ensures optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**, where $N$ is the length of string `s`.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        long r = 0;
        int sg = 1;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sg = -1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            r = r * 10 + (s.charAt(i) - '0');

            if (sg == 1 && r > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sg == -1 && -r < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (r * sg);
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

##### 2. Method Signature & Variables Initialization

```java
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        long r = 0;
        int sg = 1;

```

* **Explanation:**
* `public int myAtoi(String s)`: Defines the function that parses string `s` and returns the resulting 32-bit signed integer.


* `int i = 0, n = s.length()`: `i` acts as the index pointer traversing through `s`, and `n` stores the total character length of string `s`.


* `long r = 0`: Uses a 64-bit variable (`long`) initialized to 0 to store the numerical magnitude as digits are appended, preventing premature 32-bit integer overflow during calculations.


* `int sg = 1`: Represents the sign multiplier (defaulted to positive `1`).



---

##### 3. Discarding Whitespace

```java
        while (i < n && s.charAt(i) == ' ') i++;

```

* **Explanation:**
* Traverses through the string and skips all leading whitespace characters (`' '`).
* `i < n`: Ensures the pointer stays within valid bounds to avoid `StringIndexOutOfBoundsException`.



---

##### 4. Sign Detection

```java
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sg = -1;
            i++;
        }

```

* **Explanation:**
* Checks if the character following the whitespace is a sign specifier (`'-'` or `'+'`).
* If `-` is encountered, `sg` is updated to `-1`.
* Increments pointer `i` to move past the sign character to begin digit parsing.



---

##### 5. Digit Parsing & Range Clamping Loop

```java
        while (i < n && Character.isDigit(s.charAt(i))) {
            r = r * 10 + (s.charAt(i) - '0');

```

* **Explanation:**
* `Character.isDigit(...)`: Ensures reading continues only as long as consecutive characters are valid numerical digits (`0-9`).
* `r = r * 10 + (s.charAt(i) - '0')`: Shifts the previously extracted magnitude `r` left by one decimal place (multiplying by 10) and adds the single-digit value derived from ASCII subtraction `s.charAt(i) - '0'`.



---

##### 6. Positive Overflow Check

```java
            if (sg == 1 && r > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

```

* **Explanation:**
* If the number is positive (`sg == 1`) and accumulated magnitude `r` exceeds `Integer.MAX_VALUE` ($2147483647$), execution immediately returns `Integer.MAX_VALUE` as specified by standard clamping rules.





---

##### 7. Negative Underflow Check

```java
            if (sg == -1 && -r < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

```

* **Explanation:**
* If the number is negative (`sg == -1`) and signed value `-r` drops below `Integer.MIN_VALUE` ($-2147483648$), execution immediately returns `Integer.MIN_VALUE`.


* `i++`: Advances pointer `i` to evaluate the next character.



---

##### 8. Final Calculation & Cast

```java
        return (int) (r * sg);
    }
}

```

* **Explanation:**
* Multiplies the extracted magnitude `r` with its sign factor `sg`.
* Explicitly casts `long` back to `int` and returns the final value.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(N)$ | The string is traversed at most once with pointer `i` moving from left to right. |
| **Space Complexity** | $\mathcal{O}(1)$ | Uses a fixed set of primitive variables (`i`, `n`, `r`, `sg`) independent of input size.

 |
