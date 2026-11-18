### Find the Index of the First Occurrence in a String (LeetCode Problem 28) — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find the first occurrence of a needle (`p`) in a haystack (`s`), returning its starting index or `-1` if the substring is not found. It uses the **Knuth-Morris-Pratt (KMP) Algorithm**, which avoids redundant comparisons by precomputing a Longest Prefix Suffix (LPS) array for the pattern. This achieves an optimal **$O(N + M)$ time complexity** (where $N$ is the length of `s` and $M$ is the length of `p`).

---

#### Complete Solution Code

```java
class Solution {
    public int strStr(String s, String p) {
        if (p.length() == 0) return 0;

        int[] lps = new int[p.length()];

        // Build LPS array
        for (int i = 1, len = 0; i < p.length();) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        for (int i = 0, j = 0; i < s.length();) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == p.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class, Method Signature & Edge Case

```java
class Solution {
    public int strStr(String s, String p) {
        if (p.length() == 0) return 0;

```

* **Explanation:**
* Defines the standard LeetCode class wrapper and method `strStr` taking strings `s` and `p`.
* If the pattern `p` is an empty string, the method immediately returns `0` as per standard convention.



---

##### 2. LPS Array Initialization

```java
        int[] lps = new int[p.length()];

```

* **Explanation:**
* Initializes the **LPS (Longest Proper Prefix which is also a Suffix)** array of the same length as pattern `p`.
* `lps[i]` stores the length of the longest proper prefix of the substring `p[0...i]` that is also a suffix of that substring.



---

##### 3. Building the LPS Array (Preprocessing Loop)

```java
        for (int i = 1, len = 0; i < p.length();) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

```

* **Explanation:**
* **Character match (`p.charAt(i) == p.charAt(len)`):** Extends the matching prefix length, records it in `lps[i]`, and increments both pointers (`i` and `len`).
* **Mismatch with a previous prefix (`len > 0`):** Falls back to the previous longest prefix using `lps[len - 1]` without advancing `i`, allowing us to check alternative matching prefixes.
* **No match (`len == 0`):** Sets `lps[i] = 0` and moves forward to the next character in the pattern (`i++`).



---

##### 4. Main Search Loop Setup

```java
        for (int i = 0, j = 0; i < s.length();) {

```

* **Explanation:**
* Initializes pointer `i` for string `s` and pointer `j` for pattern `p`, iterating through `s` character by character.



---

##### 5. Character Match & Full Match Success Check

```java
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == p.length()) {
                    return i - j;
                }

```

* **Explanation:**
* If characters match, both pointers `i` and `j` move forward.
* If `j` reaches the length of pattern `p`, it means a complete match has been found. It returns the starting index of the match in `s`, which is `i - j`.



---

##### 6. Mismatch Handling during Search

```java
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

```

* **Explanation:**
* If characters do not match and `j > 0`, it uses the LPS array to shift pattern pointer `j` back to `lps[j - 1]`, avoiding redundant re-comparisons of characters we already know match.
* If `j == 0`, it simply increments `i` to check the next character in string `s`.



---

##### 7. Fallback Return Statement

```java
        return -1;
    }
}

```

* **Explanation:**
* If the loop finishes without finding a complete match, the method returns `-1` to indicate that pattern `p` is not present in string `s`.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N + M)$ | Where $N$ is the length of string `s` and $M$ is the length of pattern `p`. Precomputing the LPS array takes $O(M)$ time, and the search traversal takes $O(N)$ time. |
| **Space Complexity** | $O(M)$ | Auxiliary space is required to store the LPS array of size equal to the length of pattern `p`. |
