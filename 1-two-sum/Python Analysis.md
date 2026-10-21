### Two Sum — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find two numbers in an array (`nums`) that add up to a given `target` value, returning their zero-based indices. It utilizes a **hash map** (`dict` in Python) to achieve an optimal **$O(N)$ time complexity**.

---

#### Complete Solution Code

```python
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        d = {}
        for i, n in enumerate(nums):
            m = target - n
            if m in d:
                return [d[m], i]
            d[n] = i

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```python
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

```

* **Explanation:**
* Defines the standard LeetCode class wrapper `Solution`.
* `twoSum` takes a list of integers `nums` and an integer `target`, and returns a list of two integers representing the indices of the numbers that add up to the target.



---

##### 2. Hash Map Initialization

```python
        d = {}

```

* **Explanation:** Initializes an empty dictionary (`d`) to store numbers as keys and their corresponding indices as values. This allows us to check for previously seen numbers in $O(1)$ average time.

---

##### 3. Main Traversal Loop with Enumeration

```python
        for i, n in enumerate(nums):

```

* **Explanation:** Iterates through every element in the `nums` list. `enumerate()` provides both the current index (`i`) and the element's value (`n`) simultaneously.

---

##### 4. Complement Calculation

```python
            m = target - n

```

* **Explanation:** Calculates the required complement value needed to reach the target sum.
* **Math:** $\text{complement} + \text{n} = \text{target} \implies \text{complement} = \text{target} - \text{n}$



---

##### 5. Lookup Check

```python
            if m in d:
                return [d[m], i]

```

* **Explanation:**
* Checks if the complement `m` already exists as a key in our dictionary `d`.
* If it exists, it means we have previously encountered the matching number. We immediately return a list containing `d[m]` (the index of the old number) and `i` (the index of the current number).



---

##### 6. Map Insertion

```python
            d[n] = i

```

* **Explanation:** If the complement is **not** found in the dictionary, we store the current number `n` as the key and its index `i` as the value in `d` so future numbers can check against it.

---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | We iterate through the array of size $N$ at most once. Hash map lookups and insertions take $O(1)$ average time in Python. |
| **Space Complexity** | $O(N)$ | In the worst-case scenario, we store up to $N$ elements in the dictionary before finding the pair. |
