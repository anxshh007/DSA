### Merge Two Sorted Lists — Solution Breakdown & Code Walkthrough

#### Overview

The objective of this algorithm is to merge two sorted linked lists into a single sorted linked list. Instead of allocating new nodes, it efficiently splices the existing nodes together by comparing their values iteratively. This achieves an optimal **$O(N + M)$ time complexity** and **$O(1)$ space complexity** (where $N$ and $M$ are the lengths of the two linked lists).

---

#### Complete Solution Code

```python
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        h = c = ListNode()
        while l1 and l2:
            if l1.val < l2.val:
                c.next, l1 = l1, l1.next
            else:
                c.next, l2 = l2, l2.next
            c = c.next
        c.next = l1 or l2
        return h.next

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```python
class Solution:
    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:

```

* **Explanation:**
* Defines the standard LeetCode class wrapper.
* `mergeTwoLists` accepts two heads of singly-linked lists (`l1` and `l2`) and returns the head of the merged sorted linked list.



---

##### 2. Dummy Node and Pointer Initialization

```python
        h = c = ListNode()

```

* **Explanation:**
* Creates a dummy node and initializes both `h` (head reference) and `c` (current pointer) to point to it.
* The dummy node acts as a reliable anchor, avoiding special edge-case handling when establishing the initial head of the merged list.



---

##### 3. Traversal Loop

```python
        while l1 and l2:

```

* **Explanation:**
* Loops as long as both `l1` and `l2` contain active nodes to compare. The loop terminates when either list becomes empty.



---

##### 4. Value Comparison and Node Attachment

```python
            if l1.val < l2.val:
                c.next, l1 = l1, l1.next
            else:
                c.next, l2 = l2, l2.next

```

* **Explanation:**
* Compares the current values of both lists (`l1.val` and `l2.val`).
* Uses Python tuple assignment to simultaneously link the smaller node to `c.next` and advance the respective list pointer (`l1` or `l2`) to its next node.



---

##### 5. Advancing the Current Pointer

```python
            c = c.next

```

* **Explanation:**
* Moves the current pointer `c` forward to the newly attached node, preparing it for the next iteration.



---

##### 6. Attaching Remaining Nodes

```python
        c.next = l1 or l2

```

* **Explanation:**
* Once the `while` loop finishes, at least one of the lists (`l1` or `l2`) is completely traversed (`None`).
* Using Python's logical `or`, this attaches the remaining portion of the non-empty list directly to the end of the merged list in one concise step.



---

##### 7. Returning the Merged Result

```python
        return h.next

```

* **Explanation:**
* Returns `h.next`, which skips the initial dummy node placeholder and points directly to the actual starting node of the newly merged sorted list.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N + M)$ | Every node from both linked lists is visited and processed at most once. |
| **Space Complexity** | $O(1)$ | The lists are merged in place by rearranging existing pointers without allocating extra nodes. |
