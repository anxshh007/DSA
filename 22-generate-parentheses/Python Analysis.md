###### Generate Parentheses (LeetCode Problem 22) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to generate all valid combinations of $n$ pairs of well-formed parentheses. It uses a **Backtracking / Depth-First Search (DFS)** approach, building the string character by character while maintaining strict constraints on the counts of opening and closing brackets to ensure validity at every step. This achieves an optimal **Time Complexity of $O\left(\frac{4^n}{\sqrt{n}}\right)$** (governed by the Catalan number sequence) and a **Space Complexity of $O(n)$** for the recursion stack.

---

###### Complete Solution Code

```python
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        r = []
        def f(o, c, s):
            if len(s) == 2 * n:
                r.append(s)
                return
            if o < n:
                f(o + 1, c, s + '(')
            if c < o:
                f(o, c + 1, s + ')')
        f(0, 0, '')
        return r

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def generateParenthesis(self, n: int) -> list[str]:`: Defines the method that takes an integer `n` (representing the number of parenthesis pairs) and returns a list of strings containing all valid combinations.



---

###### 2. Result List Initialization & Helper Call

```python
        r = []
        ...
        f(0, 0, '')
        return r

```

* **Explanation:**
* `r = []`: Initializes an empty list `r` to store and accumulate all valid generated parenthesis combinations.
* `f(0, 0, '')`: Invokes the recursive helper function `f` starting with `0` opening brackets (`o`), `0` closing brackets (`c`), and an empty string (`s`).
* `return r`: Returns the final list of valid parenthesis combinations once all recursive paths have completed.



---

###### 3. Recursive Helper Definition & Base Case

```python
        def f(o, c, s):
            if len(s) == 2 * n:
                r.append(s)
                return

```

* **Explanation:**
* `def f(o, c, s):`: Defines the nested recursive backtracking function where `o` tracks the count of opening brackets used, `c` tracks the count of closing brackets used, and `s` is the current string builder state.
* `if len(s) == 2 * n:`: Base case check. A valid combination must contain exactly `2 * n` characters total (since there are `n` open and `n` close brackets).
* `r.append(s); return;`: Adds the completed valid string `s` to the result list `r` and returns to backtrack to previous choices.



---

###### 4. Opening Parenthesis Branch

```python
            if o < n:
                f(o + 1, c, s + '(')

```

* **Explanation:**
* `if o < n:`: Ensures we can only add an opening parenthesis `'('` if we haven't yet used all `n` available opening brackets.
* `f(o + 1, c, s + '(')`: Recursively calls `f`, appending `'('` to the string `s` and incrementing the open count `o` by `1`.



---

###### 5. Closing Parenthesis Branch

```python
            if c < o:
                f(o, c + 1, s + ')')

```

* **Explanation:**
* `if c < o:`: Enforces the core parenthesis validity rule—a closing parenthesis `')'` can only be added if the number of closing brackets `c` is strictly less than the number of opening brackets `o`. This prevents invalid sequences like `")("` or starting with a closing bracket.
* `f(o, c + 1, s + ')')`: Recursively calls `f`, appending `')'` to the string `s` and incrementing the close count `c` by `1`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O\left(\frac{4^n}{\sqrt{n}}\right)$ | The total number of valid parenthesis combinations for $n$ pairs is given by the $n$-th Catalan number, which grows exponentially. |
| **Space Complexity** | $O(n)$ | The maximum depth of the recursive call stack is $2n$ (proportional to $n$), and auxiliary memory is used for tracking states. |
