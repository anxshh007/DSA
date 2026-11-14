##### Reverse Nodes in k-Group (LeetCode Problem 25) — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to reverse the nodes of a singly-linked list `k` at a time and return the modified list. If the number of nodes is not a multiple of `k`, the leftover nodes at the end remain unchanged. This in-place reversal approach achieves an optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverseKGroup(h: ListNode, k: int) -> ListNode:
    d = ListNode(0, h)
    p = d
    while True:
        t = p
        for _ in range(k):
            t = t.next
            if not t:
                return d.next
        n = p.next
        c = n.next
        for _ in range(k - 1):
            n.next = c.next
            c.next = p.next
            p.next = c
            c = n.next
        p = n

```

---

###### Line-by-Line Code Analysis

###### 1. Node Class Definition

```python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

```

* **Explanation:**
* Defines the standard singly-linked list node structure containing a integer value (`val`) and a reference to the next node (`next`).



###### 2. Function Signature & Dummy Node Initialization

```python
def reverseKGroup(h: ListNode, k: int) -> ListNode:
    d = ListNode(0, h)
    p = d

```

* **Explanation:**
* `def reverseKGroup(h: ListNode, k: int) -> ListNode:`: Method declaration taking the head of the linked list `h` and group size `k`, returning the head of the modified linked list.
* `d = ListNode(0, h)`: Creates a dummy node `d` with value `0` pointing to the original head `h`. This safely handles edge cases where the head of the list changes during reversal.
* `p = d`: Initializes pointer `p` to the dummy node, acting as the anchor point right before the current group of `k` nodes to be reversed.



###### 3. Group Availability Check Loop

```python
    while True:
        t = p
        for _ in range(k):
            t = t.next
            if not t:
                return d.next

```

* **Explanation:**
* `while True:`: An infinite loop that processes the linked list group by group until fewer than `k` nodes remain.
* `t = p`: Sets a temporary pointer `t` to scan ahead.
* `for _ in range(k): t = t.next; if not t: return d.next`: Checks if there are at least `k` nodes remaining to form a complete group. If `t` hits `None`, it means fewer than `k` nodes are left, so the loop terminates and returns `d.next`.



###### 4. Group Pointers Setup

```python
        n = p.next
        c = n.next

```

* **Explanation:**
* `n = p.next`: `n` points to the first node of the current `k`-group (which will become the tail of this group after reversal).
* `c = n.next`: `c` points to the second node of the group, which will be iteratively moved forward during the reversal steps.



###### 5. In-Place Reversal of the k-Group

```python
        for _ in range(k - 1):
            n.next = c.next
            c.next = p.next
            p.next = c
            c = n.next

```

* **Explanation:**
* Runs `k - 1` times to reverse the pointers of the `k` nodes in place:
* `n.next = c.next`: Connects the current first node `n` to the node following `c`.
* `c.next = p.next`: Places node `c` right after the preceding anchor `p`.
* `p.next = c`: Updates the anchor's next pointer to `c`.
* `c = n.next`: Advances `c` to the next node to be processed in the next iteration.





###### 6. Updating the Anchor Pointer

```python
        p = n

```

* **Explanation:**
* Moves the anchor pointer `p` forward to `n` (which is now the last node of the newly reversed group), positioning it correctly for the next `k`-group iteration.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | Every node in the linked list is visited a constant number of times during the group checks and in-place reversals, where $N$ is the total number of nodes. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory for pointer variables (`d`, `p`, `t`, `n`, `c`), without allocating additional data structures. |
