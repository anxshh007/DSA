##### Letter Combinations of a Phone Number (LeetCode Problem 17) — Python Solution Walkthrough

###### Overview

This Python solution solves **LeetCode Problem 17: Letter Combinations of a Phone Number** using Python's built-in `itertools.product` module. It maps each digit to its corresponding telephone keypad letters and generates all possible combinations efficiently in a concise expression.

---

###### Complete Solution Code

```python
from itertools import product


class Solution:

  def letterCombinations(self, d: str) -> list[str]:
    if not d:
      return []
    m = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
    }
    return [''.join(p) for p in product(*(m[c] for c in d))]

```

---

###### Line-by-Line Code Analysis

###### 1. Import Statement

```python
from itertools import product

```

* **Explanation:** Imports the `product` function from Python's standard `itertools` library, which computes the Cartesian product of input iterables (acting like nested loops).

###### 2. Class and Method Signature

```python
class Solution:

  def letterCombinations(self, d: str) -> list[str]:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class wrapper definition.
* `def letterCombinations(self, d: str) -> list[str]:`: Defines the method taking an input string of digits `d` and returning a list of string combinations.



###### 3. Edge Case Check

```python
    if not d:
      return []

```

* **Explanation:** Checks if the input string `d` is empty. If true, it immediately returns an empty list `[]` to prevent empty product evaluations.

###### 4. Keypad Mapping Dictionary

```python
    m = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz',
    }

```

* **Explanation:** Sets up a dictionary `m` mapping each telephone digit string key ('2' through '9') to its corresponding letter string.

###### 5. Cartesian Product Generation & Return

```python
    return [''.join(p) for p in product(*(m[c] for c in d))]

```

* **Explanation:**
* `(m[c] for c in d)`: A generator expression that fetches the mapped letter string for each digit character `c` in the input string `d`.
* `*(...)`: The unpacking operator passes each string as a separate argument into the `product` function.
* `product(...)`: Generates all possible combinations (Cartesian product) across the letter groups.
* `' ''.join(p)`: Joins each generated tuple of characters `p` back into a single string.
* List comprehension collects all strings into the final result list and returns it.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(4^N \cdot N)$ | Where $N$ is the length of the input string `d`. In the worst case (digits 7 or 9), each digit maps to 4 letters, yielding up to $4^N$ total combinations, with $O(N)$ time spent joining each tuple. |
| **Space Complexity** | $O(4^N \cdot N)$ | Required to store the output list containing all generated letter combinations. |
