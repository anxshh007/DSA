### Letter Combinations of a Phone Number — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to solve **LeetCode Problem 17: Letter Combinations of a Phone Number**. Given a string containing digits from `2-9` inclusive, the algorithm returns all possible letter combinations that the numbers could represent, based on standard telephone keypad mappings (e.g., `2` maps to `"abc"`, `3` maps to `"def"`, etc.).

This solution uses a **Backtracking (Depth-First Search)** approach:

* It maps each digit to its corresponding group of letters using an array.
* It recursively builds combinations character by character, exploring each letter option for the current digit and backtracking (removing the last character) to try alternative paths.
* Time complexity is **$O(4^N \cdot N)$** and space complexity is **$O(N)$** (where $N$ is the length of the input string).

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    String[] m = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> r = new ArrayList<>();

    public List<String> letterCombinations(String s) {
        if (s.length() == 0) return r;
        f(s, 0, new StringBuilder());
        return r;
    }

    void f(String s, int i, StringBuilder b) {
        if (i == s.length()) {
            r.add(b.toString());
            return;
        }

        String x = m[s.charAt(i) - '0'];

        for (int j = 0; j < x.length(); j++) {
            b.append(x.charAt(j));
            f(s, i + 1, b);
            b.deleteCharAt(b.length() - 1);
        }
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class Wrapper & Lookup Mapping Array

```java
//anxshh
class Solution {
    String[] m = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> r = new ArrayList<>();

```

* **Explanation:**
* `String[] m`: A lookup array representing the telephone keypad mapping. Index `0` and `1` are empty strings, `2` maps to `"abc"`, `3` maps to `"def"`, up to `9` which maps to `"wxyz"`.
* `List<String> r`: A global/class-level result list that accumulates all valid generated letter combinations.



---

##### 2. Main Method & Edge Case Check

```java
    public List<String> letterCombinations(String s) {
        if (s.length() == 0) return r;
        f(s, 0, new StringBuilder());
        return r;
    }

```

* **Explanation:**
* `public List<String> letterCombinations(String s)`: The primary entry point method that takes the digit string `s`.
* `if (s.length() == 0) return r;`: Base case edge check. If the input string is empty, it returns the empty result list immediately.
* `f(s, 0, new StringBuilder());`: Initiates the recursive backtracking helper function starting at index `0` with a fresh `StringBuilder` instance `b`.
* `return r;`: Returns the populated list of all valid combinations.



---

##### 3. Recursive Backtracking Helper Function & Base Case

```java
    void f(String s, int i, StringBuilder b) {
        if (i == s.length()) {
            r.add(b.toString());
            return;
        }

```

* **Explanation:**
* `void f(String s, int i, StringBuilder b)`: The recursive helper function where `i` tracks the current digit index being processed, and `b` builds the current combination string.
* `if (i == s.length())`: Base case for recursion. When index `i` equals the length of input string `s`, a complete combination has been formed.
* `r.add(b.toString());`: Converts the `StringBuilder` to a standard string and adds it to the result list `r`, then returns to backtrack.



---

##### 4. Fetching Keypad Letters & Exploration Loop

```java
        String x = m[s.charAt(i) - '0'];

        for (int j = 0; j < x.length(); j++) {
            b.append(x.charAt(j));
            f(s, i + 1, b);
            b.deleteCharAt(b.length() - 1);
        }
    }
}

```

* **Explanation:**
* `String x = m[s.charAt(i) - '0'];`: Converts the character digit at index `i` (e.g., `'2'` -> `2`) to its integer value and fetches its mapped letters string from array `m` (e.g., `"abc"`).
* `for (int j = 0; j < x.length(); j++)`: Iterates through each letter option available for the current digit.
* `b.append(x.charAt(j));`: Chooses a letter by appending it to the temporary `StringBuilder` `b`.
* `f(s, i + 1, b);`: Recursively calls `f` for the next digit index (`i + 1`).
* `b.deleteCharAt(b.length() - 1);`: Backtracks by removing the last appended character, allowing the loop to try the next letter option cleanly.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(4^N \cdot N)$ | Where $N$ is the length of input string $s$. In the worst case (e.g., digits `7` or `9`), each digit maps to 4 letters, leading to up to $4^N$ total combinations. Constructing and copying each string takes $O(N)$ time. |
| **Space Complexity** | $O(N)$ | The maximum depth of the recursive call stack and the size of the temporary `StringBuilder` is proportional to the length of the string $N$ (excluding the storage needed for the output list). |
