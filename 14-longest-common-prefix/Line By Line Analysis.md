# Longest Common Prefix — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to find the **longest common prefix** string amongst an array of strings. It uses the **Horizontal Scanning** technique. The algorithm assumes the first string is the common prefix and iteratively trims it down character-by-character from the end until it matches the beginning of every subsequent string in the array. If at any point the prefix becomes empty, there is no common prefix, and the method immediately returns `""`.

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public String longestCommonPrefix(String[] s) {

        if (s == null || s.length == 0) return "";

        String p = s[0];

        for (int i = 1; i < s.length; i++) {
            while (!s[i].startsWith(p)) {
                p = p.substring(0, p.length() - 1);
                if (p.isEmpty()) return "";
            }
        }

        return p;
        
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

### 2. Method Signature & Guard Clause

```java
    public String longestCommonPrefix(String[] s) {

        if (s == null || s.length == 0) return "";

```

* **Explanation:**
* `public String longestCommonPrefix(String[] s)`: Takes an array of strings `s` and returns the longest common prefix shared by all strings.
* `if (s == null || s.length == 0) return ""`: Handles edge cases where the input array is either `null` or contains no elements by returning an empty string `""`.



---

### 3. Initializing Prefix Candidate

```java
        String p = s[0];

```

* **Explanation:** Initializes the prefix variable `p` with the first string of the array (`s[0]`). This acts as the baseline prefix that will be trimmed down as we inspect other strings.



---

### 4. Outer Loop — Iterating Through Remaining Strings

```java
        for (int i = 1; i < s.length; i++) {

```

* **Explanation:** Iterates through the rest of the array starting from index `1` up to `s.length - 1`.



---

### 5. Inner While Loop — Trimming the Prefix Candidate

```java
            while (!s[i].startsWith(p)) {
                p = p.substring(0, p.length() - 1);
                if (p.isEmpty()) return "";
            }
        }

```

* **Explanation:**
* `while (!s[i].startsWith(p))`: Continues executing as long as the current string `s[i]` does not start with prefix candidate `p`.
* `p = p.substring(0, p.length() - 1)`: Shortens the string `p` by removing its last character.
* `if (p.isEmpty()) return ""`: If `p` is reduced to an empty string, it indicates no common prefix exists across the array, so it immediately exits and returns `""`.



---

### 6. Returning the Result

```java
        return p;
        
    }
}

```

* **Explanation:** Once the loop completes scanning all strings in `s`, `p` holds the longest common prefix for all strings in the array and is returned.



---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(S)$ | Where $S$ is the sum of all characters in all strings. In the worst case, every character of every string will be compared. |
| **Space Complexity** | $O(1)$ | Uses constant auxiliary memory space as modifications are made on index pointers and substring operations without additional dynamic tables.

 |
