# Longest Substring Without Repeating Characters — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to find the length of the **longest substring** without repeating characters. It utilizes the **sliding window technique** optimized with an ASCII direct address table (an array acting as a lookup map) to track character positions, achieving an optimal **$O(N)$ time complexity**.

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            left = Math.max(left, lastSeen[c]);

            maxLen = Math.max(maxLen, right - left + 1);

            lastSeen[c] = right + 1;
        }

        return maxLen;
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

### 2. Method Signature

```java
    public int lengthOfLongestSubstring(String s) {

```

* **Explanation:**
* **`public int`**: The method returns an integer representing the maximum length of a substring without duplicate characters.
* **`String s`**: The input string to be evaluated.



---

### 3. Direct Address Table Initialization

```java
        int[] lastSeen = new int[128];

```

* **Explanation:** Initializes an array of size 128 (covering all standard ASCII characters) to keep track of the position of characters.
* By default, all values in Java integer arrays are initialized to `0`.
* `lastSeen[c]` stores `index + 1` of character `c` so that `0` can represent a character that has not been encountered yet.



---

### 4. Sliding Window Pointer & Max Length Setup

```java
        int left = 0;
        int maxLen = 0;

```

* **Explanation:**
* **`left`**: Tracks the left boundary (0-indexed starting index) of the current valid sliding window.
* **`maxLen`**: Keeps track of the maximum length of valid substrings seen so far.



---

### 5. Expanding the Sliding Window

```java
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

```

* **Explanation:**
* The `for` loop moves the `right` pointer one character at a time across the string `s`.
* `char c = s.charAt(right)` extracts the character at the current `right` boundary index.



---

### 6. Shrinking / Updating Left Boundary

```java
            left = Math.max(left, lastSeen[c]);

```

* **Explanation:**
* Checks if character `c` was seen previously within our current active window.
* If `lastSeen[c]` is greater than `left`, it means character `c` appeared inside the current substring window. We jump `left` forward past that last duplicate occurrence (`lastSeen[c]` stores `previous_index + 1`).
* `Math.max` ensures that `left` never moves backward if `lastSeen[c]` refers to an old occurrence outside the active window.



---

### 7. Updating Maximum Substring Length

```java
            maxLen = Math.max(maxLen, right - left + 1);

```

* **Explanation:**
* `right - left + 1` calculates the current size of the valid substring between `left` and `right`.
* `Math.max` updates `maxLen` whenever a substring longer than the current `maxLen` is found.



---

### 8. Recording Character Position

```java
            lastSeen[c] = right + 1;
        }

```

* **Explanation:**
* Updates the position of character `c` in the `lastSeen` array to `right + 1`.
* Storing `right + 1` allows the `left` pointer to jump directly to the next index after the duplicate character if `c` appears again later.



---

### 9. Returning Result

```java
        return maxLen;
    }
}

```

* **Explanation:** Returns the longest valid substring length found throughout the entire string traversal.

---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The string is traversed once using the `right` pointer ($N$ is the length of `s`). Lookups and updates in `lastSeen` take $O(1)$ constant time. |
| **Space Complexity** | $O(1)$ | Uses a fixed-size integer array of size $128$ regardless of the input string length. |
