##### Valid Parentheses (LeetCode Problem 20) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to determine whether a given string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'` is valid. A string is valid if open brackets are closed by the same type of brackets in the correct order, and every open bracket has a corresponding close bracket of the same type. This solution uses a **stack** data structure, achieving optimal **$O(N)$ time complexity** and **$O(N)$ space complexity**, where $N$ is the length of the string.

---

###### Complete Solution Code

```python
def isValid(s: str) -> bool:
    st, d = [], {")": "(", "}": "{", "]": "["}
    for c in s:
        if c in d:
            if not st or st.pop() != d[c]:
                return False
        else:
            st.append(c)
    return not st

```

---

###### Line-by-Line Code Analysis

###### 1. Method Signature and Initialization

```python
def isValid(s: str) -> bool:
    st, d = [], {")": "(", "}": "{", "]": "["}

```

* **Explanation:**
* `def isValid(s: str) -> bool:`: Defines the function that accepts a string `s` and returns a boolean value (`True` if valid, `False` otherwise).
* `st = []`: Initializes an empty list to act as our stack, keeping track of open brackets.
* `d = {")": "(", "}": "{", "]": "["}`: Initializes a dictionary mapping each closing bracket to its corresponding opening bracket for quick validation lookups.



---

###### 2. Character Iteration Loop

```python
    for c in s:

```

* **Explanation:**
* Loops through each character `c` one by one through the input string `s`.



---

###### 3. Handling Closing Brackets

```python
        if c in d:
            if not st or st.pop() != d[c]:
                return False

```

* **Explanation:**
* `if c in d:`: Checks if the current character is a closing bracket (since all keys in dictionary `d` are closing brackets).
* `if not st or st.pop() != d[c]:`:
* `not st`: Checks if the stack is empty. If we encounter a closing bracket when no open bracket exists, it's invalid.
* `st.pop() != d[c]`: Pops the top element from the stack and checks if it matches the expected opening bracket (`d[c]`). If it doesn't match, the order is incorrect.


* `return False`: Immediately returns `False` if any mismatch or invalid closure is detected.



---

###### 4. Handling Opening Brackets

```python
        else:
            st.append(c)

```

* **Explanation:**
* If the character is not a closing bracket (meaning it's an opening bracket like `'('`, `'{'`, or `'['`), it gets pushed onto our stack `st` using `append()`.



---

###### 5. Final Validity Check

```python
    return not st

```

* **Explanation:**
* After checking all characters in the string, `not st` returns `True` if the stack is completely empty (meaning every open bracket was properly matched and closed) and `False` if any unmatched open brackets remain.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $\mathcal{O}(N)$ | We traverse the string of length $N$ exactly once. Stack push and pop operations take $\mathcal{O}(1)$ time each. |
| **Space Complexity** | $\mathcal{O}(N)$ | In the worst-case scenario (e.g., all opening brackets like `(((((`), the stack stores up to $N$ elements. |
