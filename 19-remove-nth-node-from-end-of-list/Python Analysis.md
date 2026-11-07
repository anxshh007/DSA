### Remove Nth Node From End of List — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to remove the $N$-th node from the end of a singly-linked list in a single pass using an optimal **two-pointer approach** (fast and slow pointer technique). This achieves an **$O(N)$ time complexity** and **$O(1)$ space complexity** without needing to calculate the length of the list beforehand.

---

#### Complete Solution Code

```python
class Solution:
  def removeNthFromEnd(self, h: Optional[ListNode], n: int) -> Optional[ListNode]:
    d = ListNode(0, h)
    s = f = d
    for _ in range(n + 1):
      f = f.next
    while f:
      s, f = s.next, f.next
    s.next = s.next.next
    return d.next

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```python
class Solution:
  def removeNthFromEnd(self, h: Optional[ListNode], n: int) -> Optional[ListNode]:

```

* **Explanation:**
* `class Solution:`: Standard LeetCode class container.
* `def removeNthFromEnd(self, h: Optional[ListNode], n: int) -> Optional[ListNode]:`: Method that accepts the head node `h` of the linked list and an integer `n`, returning the modified linked list's head.



---

##### 2. Dummy Node Creation

```python
    d = ListNode(0, h)

```

* **Explanation:**
* Creates a dummy node `d` with a value of `0` whose `.next` points to the actual head `h`. This acts as a safeguard to handle edge cases smoothly, such as when the head node itself needs to be removed.



---

##### 3. Pointer Initialization

```python
    s = f = d

```

* **Explanation:**
* Initializes both the slow pointer (`s`) and the fast pointer (`f`) to start at the dummy node `d`.



---

##### 4. Fast Pointer Offset Loop

```python
    for _ in range(n + 1):
      f = f.next

```

* **Explanation:**
* Advances the fast pointer `f` forward by `n + 1` steps. This establishes a fixed gap of `n + 1` nodes between the slow pointer `s` and the fast pointer `f`.



---

##### 5. Main Traversal Loop

```python
    while f:
      s, f = s.next, f.next

```

* **Explanation:**
* Moves both pointers (`s` and `f`) forward together step-by-step until `f` reaches the end of the list (`None`).
* Due to the initial gap, when `f` hits `None`, the slow pointer `s` will land precisely at the node **right before** the target node that needs deletion.



---

##### 6. Node Removal

```python
    s.next = s.next.next

```

* **Explanation:**
* Bypasses the target node by pointing `s.next` directly to `s.next.next`, effectively unlinking and deleting the $N$-th node from the list.



---

##### 7. Result Return

```python
    return d.next

```

* **Explanation:**
* Returns `d.next`, which is the actual head of the modified linked list (bypassing the temporary dummy node `d`).



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm traverses the linked list in a single pass, where $N$ is the number of nodes. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory for pointer variables (`d`, `s`, `f`), independent of the list size. |
