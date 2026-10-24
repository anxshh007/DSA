# Zigzag Conversion — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to reformat a given string `s` into a **Zigzag pattern** across a specified number of rows (`numRows`) and then read the characters line-by-line from top to bottom.

Instead of constructing a 2D grid matrix, this solution simulates the movement of a pointer moving up and down across `numRows` `StringBuilder` instances. It uses a **direction flag** that reverses whenever the top or bottom row is reached, achieving an optimal **$O(N)$ time complexity** and **$O(N)$ space complexity** (where $N$ is the length of the string).

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1;

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();
    }
}

```

---

## Line-by-Line Code Analysis

### 1. Class Definition

```java
//anxshh
class Solution {

```

* **Explanation:** Standard LeetCode class wrapper definition.

---

### 2. Method Signature & Base Case Edge Checks

```java
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

```

* **Explanation:**
* `public String convert(String s, int numRows)`: Defines the method taking string `s` and row count `numRows`, returning the transformed string.
* `if (numRows == 1 || numRows >= s.length())`:
* If `numRows == 1`, no vertical or diagonal zigzag pattern can be formed, so characters remain in their original order.
* If `numRows >= s.length()`, there are more rows than available characters, meaning each row receives at most one character in a single vertical column.
* In either case, the original string `s` is returned immediately.





---

### 3. Array of StringBuilders Initialization

```java
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

```

* **Explanation:**
* `StringBuilder[] rows = new StringBuilder[numRows];`: Allocates an array of size `numRows` to hold string builders corresponding to each horizontal row of the zigzag pattern.
* The `for` loop initializes a new `StringBuilder` for each index in the `rows` array to prevent `NullPointerException` during character append operations.



---

### 4. Row Pointer & Direction Flag Setup

```java
        int row = 0;
        int direction = 1;

```

* **Explanation:**
* `row = 0`: Tracks the current row index where the next character will be placed (starts at the top row, index `0`).
* `direction = 1`: Acts as a direction toggle. `1` moves down through rows (`0 -> 1 -> 2 ...`), and `-1` moves up diagonally/vertically (`... 2 -> 1 -> 0`).



---

### 5. Main Character Iteration & Direction Flipping

```java
        for (char c : s.toCharArray()) {
            rows[row].append(c);

            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

```

* **Explanation:**
* `for (char c : s.toCharArray())`: Converts string `s` into a character array and iterates through each character `c`.
* `rows[row].append(c)`: Appends the current character `c` to the `StringBuilder` assigned to the active `row`.
* `if (row == 0)`: When the pointer reaches the top row, change direction to `1` (downward).
* `else if (row == numRows - 1)`: When the pointer reaches the bottom row (`numRows - 1`), change direction to `-1` (upward).
* `row += direction`: Updates the current row index by moving either one step down (`+1`) or one step up (`-1`).



---

### 6. Concatenating All Rows for Final Result

```java
        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();
    }
}

```

* **Explanation:**
* Creates a master `StringBuilder` named `result`.
* Iterates through each row in `rows` from index `0` to `numRows - 1` and appends its contents sequentially into `result`.
* `return result.toString()`: Converts the combined `StringBuilder` into a standard `String` and returns the final transformed string.



---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | Where $N$ is the length of string `s`. We iterate through the string once to populate row builders and once more through rows to combine them. |
| **Space Complexity** | $O(N)$ | Additional space is allocated for `StringBuilder` instances storing $N$ total characters across all rows. |
