# Regular Expression Matching — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to implement regular expression matching with support for `'.'` (matches any single character) and `'*'` (matches zero or more of the preceding element). It uses **Dynamic Programming (Bottom-Up)** to evaluate match validity across all prefix combinations of string `s` and pattern `p`. This approach achieves a **$O(N \times M)$ time complexity** and **$O(N \times M)$ space complexity**, where $N$ is the length of `s` and $M$ is the length of `p`.

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);

                if (b == '.' || b == a) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else if (b == '*' && j >= 2) {
                    dp[i][j] = dp[i][j - 2];

                    char c = p.charAt(j - 2);
                    if (c == '.' || c == a)
                        dp[i][j] |= dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
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

* **Explanation:** Defines the standard LeetCode solution class wrapper.



---

### 2. Method Signature & Dynamic Programming Table Initialization

```java
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

```

* **Explanation:**
* `n` and `m` store the lengths of string `s` and pattern `p` respectively.


* `boolean[][] dp`: Creates a 2D boolean DP matrix of size `(n + 1) x (m + 1)`.


* `dp[i][j]` represents whether the prefix of string `s` of length `i` matches the prefix of pattern `p` of length `j`.



---

### 3. Base Case Initialization

```java
        dp[0][0] = true;

```

* **Explanation:** An empty string (`s` of length 0) matches an empty pattern (`p` of length 0), so `dp[0][0]` is initialized to `true`.



---

### 4. Handling Empty String Matching with Star Patterns

```java
        for (j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

```

* **Explanation:**
* Handles patterns like `"a*"`, `"a*b*"`, or `"a*b*c*"` matching an empty string (`s` of length 0).
* If character at index `j - 1` in `p` is `'*'`, it can match zero occurrences of the preceding element (`p.charAt(j - 2)`).
* Thus, `dp[0][j]` inherits the match state from 2 positions back in pattern `p` (`dp[0][j - 2]`).



---

### 5. Nested Loops Traversing String and Pattern

```java
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);

```

* **Explanation:**
* Outer loop iterates through character lengths of `s` (from 1 to `n`).
* Inner loop iterates through character lengths of `p` (from 1 to `m`).
* `char a` extracts the current character from `s` at index `i - 1`.


* `char b` extracts the current character from `p` at index `j - 1`.





---

### 6. Matching Single Characters or '.' Wildcard

```java
                if (b == '.' || b == a) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 

```

* **Explanation:**
* If the pattern character `b` is `'.'` or equals character `a` directly, the current match depends on whether the preceding substring matched the preceding pattern.
* Copies the diagonal result: `dp[i][j] = dp[i - 1][j - 1]`.



---

### 7. Handling '*' Wildcard (Zero or More Occurrences)

```java
                else if (b == '*' && j >= 2) {
                    dp[i][j] = dp[i][j - 2];

                    char c = p.charAt(j - 2);
                    if (c == '.' || c == a)
                        dp[i][j] |= dp[i - 1][j];
                }

```

* **Explanation:**
* Executes when pattern character `b` is `'*'` (with valid preceding character index `j >= 2`).
* **Case 1 (Zero occurrences):** `dp[i][j] = dp[i][j - 2]` ignores the `'*'` and its preceding character.
* **Case 2 (One or more occurrences):** `char c = p.charAt(j - 2)` gets the preceding character before `'*'`. If `c` matches `a` or is `'.'`:
* Performs `dp[i][j] |= dp[i - 1][j]` (bitwise OR assignment) to check if matching one more character of `s` with the current star pattern yields `true`.





---

### 8. Returning Final Match State

```java
        return dp[n][m];
    }
}

```

* **Explanation:** Returns `dp[n][m]`, indicating whether the full string `s` of length `n` matches the full pattern `p` of length `m`.

---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \times M)$ | The nested loops iterate over all combinations of prefixes of `s` of length $N$ and `p` of length $M$.

 |
| **Space Complexity** | $O(N \times M)$ | A 2D array of dimensions $(N + 1) \times (M + 1)$ is allocated to maintain the DP table.

 |
