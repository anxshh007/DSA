##### Integer to Roman — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to convert an integer `n` into its corresponding Roman numeral string representation.

Roman numerals are formed by combining seven standard symbols: `I` (1), `V` (5), `X` (10), `L` (50), `C` (100), `D` (500), and `M` (1000). In addition, subtractive forms are used to represent numbers like 4 (`IV`), 9 (`IX`), 40 (`XL`), 90 (`XC`), 400 (`CD`), and 900 (`CM`).

This solution uses a **greedy strategy** with two parallel lookup arrays ordered from largest to smallest value. By repeatedly subtracting the largest possible Roman numeral value from `n` and appending its corresponding string symbol to a `StringBuilder`, the algorithm transforms the integer efficiently in optimal **$\mathcal{O}(1)$ time complexity** and **$\mathcal{O}(1)$ space complexity**.

---

###### Complete Solution Code

```java
//anxshh
class Solution {
    public String intToRoman(int n) {
        int[] a = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] b = {"M","CM","D","CD","C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder s = new StringBuilder();

        for (int i = 0; i<a.length; i++) {
            while (n >= a[i]) {
                n -= a[i];
                s.append(b[i]);
            }
        }
        return s.toString();
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class Definition

```java
//anxshh
class Solution {

```

* **Explanation:** Standard LeetCode class wrapper definition.



---

###### 2. Method Signature & Lookup Mapping Arrays

```java
    public String intToRoman(int n) {
        int[] a = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] b = {"M","CM","D","CD","C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};

```

* **Explanation:**
* `public String intToRoman(int n)`: Defines the function taking an integer `n` as input and returning its Roman numeral representation as a `String`.


* `int[] a`: An array storing numerical values sorted in strictly descending order. It includes both standard values (`1000`, `500`, `100`, `50`, `10`, `5`, `1`) and subtractive combinations (`900`, `400`, `90`, `40`, `9`, `4`).
* `String[] b`: A parallel string array where `b[i]` holds the exact Roman numeral representation corresponding to the numerical value at `a[i]`.



---

###### 3. Result String Buffer Initialization

```java
        StringBuilder s = new StringBuilder();

```

* **Explanation:**
* Instantiates a `StringBuilder` instance `s` to efficiently append and accumulate Roman numeral string symbols as matches are found.





---

###### 4. Outer Loop (Value Array Iteration)

```java
        for (int i = 0; i < a.length; i++) {

```

* **Explanation:**
* Iterates sequentially through each element in array `a` from largest value (`1000`) down to smallest value (`1`).



---

###### 5. Inner Greedy Subtraction & Append Loop

```java
            while (n >= a[i]) {
                n -= a[i];
                s.append(b[i]);
            }
        }

```

* **Explanation:**
* `while (n >= a[i])`: Checks if the remaining integer `n` is greater than or equal to the current Roman numerical value `a[i]`.
* `n -= a[i]`: Subtracts `a[i]` from `n`.
* `s.append(b[i])`: Appends the matching Roman numeral symbol `b[i]` to `s`.
* The `while` loop continues executing for the same value `a[i]` as long as `n` remains larger or equal (e.g., for `n = 3000`, `1000` is subtracted 3 times, appending `"M"` 3 times).



---

###### 6. Conversion to String & Return

```java
        return s.toString();
    }
}

```

* **Explanation:**
* `s.toString()`: Converts the accumulated `StringBuilder` object into a `String`.


* `return`: Returns the finalized Roman numeral string representation.





---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(1)$ | Array `a` has a fixed length of 13 elements, and `n` is constrained up to $3999$. The loop iterations are capped by a small constant limit. |
| **Space Complexity** | $\mathcal{O}(1)$ | Uses a constant amount of memory for fixed-size arrays and a `StringBuilder` storing at most 15 characters.

 |
