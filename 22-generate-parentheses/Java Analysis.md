##### Generate Parentheses (LeetCode Problem 22) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to generate all valid combinations of `n` pairs of well-formed parentheses. It uses a **Backtracking / Depth-First Search (DFS)** approach, building the string character by character while maintaining strict constraints on the counts of opening and closing brackets to ensure validity at every step. This achieves an optimal **Time Complexity of $O\left(\frac{4^n}{\sqrt{n}}\right)$** (governed by the Catalan number sequence) and a **Space Complexity of $O(n)$** for the recursion stack.

---

###### Complete Solution Code

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        f(r, "", 0, 0, n);
        return r;
    }

    void f(List<String> r, String s, int o, int c, int n) {
        if (s.length() == 2 * n) {
            r.add(s);
            return;
        }

        if (o < n)
            f(r, s + "(", o + 1, c, n);

        if (c < o)
            f(r, s + ")", o, c + 1, n);
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```java
class Solution {
    public List<String> generateParenthesis(int n) {

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper.
* `public List<String> generateParenthesis(int n)`: Main method taking integer `n` (the number of parenthesis pairs) and returning a list of all valid parenthesis combinations.



---

###### 2. Result List Initialization & Helper Call

```java
        List<String> r = new ArrayList<>();
        f(r, "", 0, 0, n);
        return r;
    }

```

* **Explanation:**
* `List<String> r = new ArrayList<>();`: Initializes a list `r` to accumulate all valid generated strings.
* `f(r, "", 0, 0, n);`: Invokes the recursive backtracking helper function `f` with an empty string `""`, `0` opening brackets (`o`), `0` closing brackets (`c`), and target `n`.
* `return r;`: Returns the final list of valid parenthesis combinations once recursion completes.



---

###### 3. Recursive Helper Method & Base Case

```java
    void f(List<String> r, String s, int o, int c, int n) {
        if (s.length() == 2 * n) {
            r.add(s);
            return;
        }

```

* **Explanation:**
* `void f(...)`: The recursive backtracking function where `s` is the current string builder state, `o` tracks used opening brackets, and `c` tracks used closing brackets.
* `if (s.length() == 2 * n)`: Base case check. A valid combination must contain `2 * n` characters total (since there are `n` open and `n` close brackets).
* `r.add(s); return;`: Adds the completed valid string `s` to the result list `r` and returns to backtrack.



---

###### 4. Opening Parenthesis Branch

```java
        if (o < n)
            f(r, s + "(", o + 1, c, n);

```

* **Explanation:**
* `if (o < n)`: Ensures we can only add an opening parenthesis `(` if we haven't yet used all `n` available opening brackets.
* `f(r, s + "(", o + 1, c, n)`: Recursively calls `f`, appending `(` to string `s` and incrementing the open count `o` by 1.



---

###### 5. Closing Parenthesis Branch

```java
        if (c < o)
            f(r, s + ")", o, c + 1, n);
    }
}

```

* **Explanation:**
* `if (c < o)`: Enforces the core parenthesis validity rule—a closing bracket `)` can only be added if the number of closing brackets `c` is strictly less than the number of opening brackets `o`. This prevents invalid sequences like `)(`.
* `f(r, s + ")", o, c + 1, n)`: Recursively calls `f`, appending `)` to string `s` and incrementing the close count `c` by 1.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O\left(\frac{4^n}{\sqrt{n}}\right)$ | The total number of valid parenthesis combinations for $n$ pairs is given by the $n$-th Catalan number, which grows exponentially. |
| **Space Complexity** | $O(n)$ | The maximum depth of the recursive call stack is $2n$ (proportional to $n$), and auxiliary memory is used for tracking states. |
