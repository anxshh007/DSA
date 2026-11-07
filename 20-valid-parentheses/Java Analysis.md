##### Valid Parentheses (LeetCode Problem 20) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to determine whether a given string `s` containing parentheses, braces, and brackets (`(`, `)`, `{`, `}`, `[`, `]`) is valid. A string is valid if open brackets are closed by the same type of brackets in the correct order and closed in the correct nesting order. This solution uses a **Stack** data structure, achieving an optimal **$O(N)$ time complexity** and **$O(N)$ space complexity**, where $N$ is the length of the string.

---

###### Complete Solution Code

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;

                char t = st.pop();

                if ((c == ')' && t != '(') ||
                    (c == '}' && t != '{') ||
                    (c == ']' && t != '[')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```java
class Solution {
    public boolean isValid(String s) {

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `public boolean isValid(String s):`: Method declaration that takes a string `s` as input and returns a boolean value (`true` if the string of brackets is valid, `false` otherwise).



---

###### 2. Stack Initialization

```java
        Stack<Character> st = new Stack<>();

```

* **Explanation:**
* Initializes a character stack named `st`. LIFO (Last-In-First-Out) property of the stack makes it ideal for tracking nested and sequential opening brackets.



---

###### 3. Iteration and Opening Bracket Push

```java
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {

```

* **Explanation:**
* `for (char c : s.toCharArray()):` Converts the input string into a character array and loops through each character `c`.
* `if (c == '(' || c == '{' || c == '['):`: Checks if the current character is an opening bracket.
* `st.push(c);`: If it is an opening bracket, pushes it onto the stack to be matched later.
* `else:`: If it is not an opening bracket, it must be a closing bracket, so execution falls into the `else` block.



---

###### 4. Empty Stack Validation for Closing Brackets

```java
                if (st.isEmpty()) return false;

```

* **Explanation:**
* If a closing bracket is encountered when the stack is empty, it means there is no corresponding opening bracket to match it, so the string is invalid immediately.



---

###### 5. Popping and Matching Pair Verification

```java
                char t = st.pop();

                if ((c == ')' && t != '(') ||
                    (c == '}' && t != '{') ||
                    (c == ']' && t != '[')) {
                    return false;
                }
            }
        }

```

* **Explanation:**
* `char t = st.pop();`: Pops the top element from the stack, representing the most recent unmatched opening bracket.
* `if ((c == ')' && t != '(') || ...):` Checks if the current closing bracket `c` does not match the popped opening bracket `t`. If there is a mismatch (e.g., `)` paired with `{`), the string is invalid.



---

###### 6. Final Validation Return

```java
        return st.isEmpty();
    }
}

```

* **Explanation:**
* `return st.isEmpty();`: After the loop finishes checking all characters, returns `true` if the stack is completely empty (meaning all opening brackets were successfully matched and closed), or `false` if any unmatched opening brackets remain inside the stack.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm traverses the string of length $N$ exactly once, performing constant time $O(1)$ push and pop operations on the stack. |
| **Space Complexity** | $O(N)$ | In the worst-case scenario (e.g., all opening brackets like `(((({`), the stack stores all $N$ characters. |
