# Add Two Numbers — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to add two non-empty linked lists representing two non-negative integers. The digits are stored in **reverse order**, meaning the head of each list contains the least significant digit (ones place). The function iterates through both linked lists, adds corresponding digits along with any carried value, and builds a new linked list representing the total sum.

---

## Complete Solution Code

```python
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        curr = dummy
        carry = 0

        while l1 or l2 or carry:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0

            s = v1 + v2 + carry
            carry = s // 10
            curr.next = ListNode(s % 10)
            curr = curr.next

            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        return dummy.next

```

---

## Line-by-Line Code Analysis

### 1. Class and Function Signature

```python
class Solution:
    def addTwoNumbers(self, l1, l2):

```

* **Explanation:**
* Defines the standard `Solution` class wrapper.
* `addTwoNumbers` receives two arguments, `l1` and `l2`, which are the heads of the two singly-linked lists.



---

### 2. Initialization of Dummy Node, Pointer, and Carry

```python
        dummy = ListNode(0)
        curr = dummy
        carry = 0

```

* **Explanation:**
* **`dummy = ListNode(0)`**: Creates a placeholder node. Using a dummy node simplifies edge cases when building the result list because we don't need special conditional logic to set up the head of the new list.
* **`curr = dummy`**: A pointer initialized to track the tail node of the newly created sum list.
* **`carry = 0`**: Keeps track of the value carried over from addition when two single digits sum to $10$ or greater.



---

### 3. Main Traversal Loop

```python
        while l1 or l2 or carry:

```

* **Explanation:** The loop continues as long as **at least one** of the following conditions is true:
1. `l1` still has remaining nodes to process.
2. `l2` still has remaining nodes to process.
3. A non-zero `carry` remains from the previous addition step (e.g., $5 + 5 = 10$, requiring a new node for `1`).



---

### 4. Extracting Node Values

```python
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0

```

* **Explanation:** Safely retrieves digit values using Python's ternary operator:
* If `l1` exists, `v1` gets its node value `l1.val`; otherwise, `0`.
* If `l2` exists, `v2` gets its node value `l2.val`; otherwise, `0`.
* This allows smooth iteration even if one list is longer than the other.



---

### 5. Sum and Carry Calculation

```python
            s = v1 + v2 + carry
            carry = s // 10

```

* **Explanation:**
* **`s = v1 + v2 + carry`**: Computes the sum of the two current digits plus any carry forward from the prior column.
* **`carry = s // 10`**: Uses integer division to extract the new carry (e.g., $15 // 10 = 1$).



---

### 6. Creating and Attaching the Result Node

```python
            curr.next = ListNode(s % 10)
            curr = curr.next

```

* **Explanation:**
* **`s % 10`**: Obtains the single-digit value for the current position (e.g., $15 \% 10 = 5$).
* **`curr.next = ListNode(...)`**: Instantiates a new node containing this digit and attaches it after the current node.
* **`curr = curr.next`**: Advances the `curr` pointer to point to the newly created node.



---

### 7. Advancing List Pointers

```python
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

```

* **Explanation:** Advances `l1` and `l2` to their respective next nodes if they are not already `None`.

---

### 8. Returning the Head of the Result List

```python
        return dummy.next

```

* **Explanation:** `dummy` served as an initial anchor point. `dummy.next` holds the actual start node of the resulting linked list.

---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\max(N, M))$ | Where $N$ and $M$ are the lengths of `l1` and `l2`. The loop runs at most $\max(N, M) + 1$ times to handle all digits and an optional final carry. |
| **Space Complexity** | $O(\max(N, M))$ | The output list will contain at most $\max(N, M) + 1$ nodes. |
