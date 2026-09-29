# Longest Palindromic Substring — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to find the **longest palindromic substring** in a given string `s`. It uses the **Expand Around Center** technique. Since a palindrome mirrors around its center, there are $2N - 1$ possible centers for a string of length $N$ (single characters for odd-length palindromes and gaps between characters for even-length palindromes). This approach checks all possible centers to find the longest palindrome in **$O(N^2)$ time complexity** and **$O(1)$ auxiliary space complexity**.

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
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

* **Explanation:** Defines the standard LeetCode class wrapper `Solution`.



---

### 2. Main Method Signature & Base Case Check

```java
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

```

* **Explanation:**
* `public String longestPalindrome(String s)`: Takes an input string `s` and returns the longest palindromic substring.
* `if (s == null || s.length() < 2)`: If the string is `null` or contains fewer than 2 characters (0 or 1), it is already a valid palindrome, so the string itself is returned immediately.



---

### 3. Substring Index Pointers Initialization

```java
        int start = 0;
        int end = 0;

```

* **Explanation:**
* `start` and `end` store the starting and ending indices of the longest palindromic substring found so far.
* Both are initialized to `0`.



---

### 4. Main Iteration Loop

```java
        for (int i = 0; i < s.length(); i++) {

```

* **Explanation:** Iterates through each character index `i` of the string `s`, treating `i` as the center of potential palindromes.

---

### 5. Expanding Around Centers (Odd and Even Palindromes)

```java
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);

```

* **Explanation:**
* `len1`: Expands around a single character center at index `i` to check for **odd-length palindromes** (e.g., `"aba"` centered at `'b'`).
* `len2`: Expands around two adjacent character centers at indices `i` and `i + 1` to check for **even-length palindromes** (e.g., `"abba"` centered between `'b'` and `'b'`).



---

### 6. Determining Maximum Length & Updating Boundaries

```java
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

```

* **Explanation:**
* `int len = Math.max(len1, len2)`: Obtains the longer palindrome length between the odd and even expansion results for center `i`.
* `if (len > end - start + 1)`: Compares `len` against the length of the current best palindrome (`end - start + 1`).
* `start = i - (len - 1) / 2`: Calculates the starting index of the new palindrome relative to center `i`.
* `end = i + len / 2`: Calculates the ending index of the new palindrome relative to center `i`.



---

### 7. Extracting and Returning the Longest Palindrome

```java
        return s.substring(start, end + 1);
    }

```

* **Explanation:** Uses Java's `substring(start, end + 1)` method to extract and return the longest palindromic substring from `start` to `end` inclusive.

---

### 8. Helper Method Signature

```java
    private int expandFromCenter(String s, int left, int right) {

```

* **Explanation:** A private helper method that expands outward from the given `left` and `right` indices while characters match and boundaries are valid.

---

### 9. Center Expansion Loop

```java
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

```

* **Explanation:**
* `left >= 0 && right < s.length()`: Ensures expansion stays within valid string bounds.
* `s.charAt(left) == s.charAt(right)`: Continues expanding as long as the character on the left matches the character on the right.
* `left--` and `right++`: Move pointers one position outward in opposite directions.



---

### 10. Returning Palindrome Length

```java
        return right - left - 1;
    }
}

```

* **Explanation:**
* When the `while` loop terminates, `left` and `right` have overshot the valid palindrome boundaries by 1 position on each side.
* The actual palindrome length is calculated as `(right - 1) - (left + 1) + 1`, which simplifies algebraically to `right - left - 1`.



---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^2)$ | Expanding from a center takes $O(N)$ time in the worst case, and we perform this for $2N - 1$ centers across a string of length $N$.

 |
| **Space Complexity** | $O(1)$ | Constant extra space is used since expansion is performed using two index pointers (`left` and `right`).

 |
