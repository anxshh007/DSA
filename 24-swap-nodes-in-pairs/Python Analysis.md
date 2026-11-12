##### Swap Nodes in Pairs — Python Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to swap every adjacent pair of nodes in a singly linked list and return its new head. It uses an iterative pointer manipulation approach with a dummy node, achieving **$O(N)$** **time complexity** and **$O(1)$** **space complexity**.

---

###### Complete Solution Code

```python
class Solution:
    def swapPairs(self, h: Optional[ListNode]) -> Optional[ListNode]:
        d = p = ListNode(0, h)
        while p.next and p.next.next:
            a, b = p.next, p.next.next
            p.next, a.next, b.next = b, b.next, a
            p = a
        return d.next

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```python
class Solution:
    def swapPairs(self, h: Optional[ListNode]) -> Optional[ListNode]:

```

* **Explanation:**
* `class Solution`: Standard LeetCode solution class wrapper.
* `def swapPairs(self, h: Optional[ListNode]) -> Optional[ListNode]`: Method signature that accepts the head `h` of a linked list and returns the head of the modified linked list after swapping adjacent pairs.



---

###### 2. Dummy Node and Pointer Initialization

```python
        d = p = ListNode(0, h)

```

* **Explanation:**
* `d = p = ListNode(0, h)`: Creates a dummy node with a value of `0` pointing to the original head `h`. Both `d` (the reference to the start of the list) and `p` (the tracking pointer) point to this dummy node. This safely handles edge cases like swapping the very first pair.



---

###### 3. While Loop Condition

```python
        while p.next and p.next.next:

```

* **Explanation:**
* `while p.next and p.next.next`: Ensures the loop runs only when there are at least two nodes remaining to be swapped (`p.next` and `p.next.next` are not `None`).



---

###### 4. Node Assignment

```python
            a, b = p.next, p.next.next

```

* **Explanation:**
* `a, b = p.next, p.next.next`: Identifies the two adjacent nodes to be swapped. `a` is the first node of the pair, and `b` is the second node.



---

###### 5. Pointer Swapping and Re-linking

```python
            p.next, a.next, b.next = b, b.next, a

```

* **Explanation:**
* Performs the swap in a single line using Python tuple assignment:
* `p.next = b`: Connects the previous node/dummy to the second node `b`.
* `a.next = b.next`: Links the first node `a` to the rest of Gymnasium/unswapped list (the node following `b`).
* `b.next = a`: Completes the pair inversion by pointing `b` to `a`.





---

###### 6. Advancing the Pointer

```python
            p = a

```

* **Explanation:**
* `p = a`: Moves the pointer `p` forward to `a` (which is now the last node of the newly swapped pair) to prepare for processing the next pair.



---

###### 7. Returning the Result

```python
        return d.next

```

* **Explanation:**
* `return d.next`: Returns the head of the modified linked list, which is the node immediately following the temporary dummy node `d`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm traverses every node in the linked list exactly once, where $N$ is the total number of nodes. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra space with scalar pointer references (`d`, `p`, `a`, `b`) without allocating additional data structures. |
