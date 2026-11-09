##### Merge k Sorted Lists — Python Solution Breakdown & Code Walkthrough

###### Overview

The objective of this algorithm is to merge $k$ sorted linked lists into a single sorted linked list. It uses a **min-heap (priority queue)** to efficiently track and retrieve the smallest current node among the heads of all active lists. This approach achieves an optimal **$O(N \log k)$** time complexity and **$O(k)$** space complexity (where $N$ is the total number of nodes across all lists, and $k$ is the number of linked lists).

---

###### Complete Solution Code

```python
import heapq

class Solution:
    def mergeKLists(self, l: list[Optional[ListNode]]) -> Optional[ListNode]:
        h = []
        for i, x in enumerate(l):
            if x:
                heapq.heappush(h, (x.val, i, x))
        d = p = ListNode(0)
        while h:
            _, i, x = heapq.heappop(h)
            p.next = x
            p = p.next
            if x.next:
                heapq.heappush(h, (x.next.val, i, x.next))
        return d.next

```

---

###### Line-by-Line Code Analysis

###### 1. Module Import

```python
import heapq

```

* **Explanation:**
* Imports Python's built-in `heapq` module, which provides an implementation of the min-heap property. This allows us to push and pop elements while automatically maintaining the smallest element at the root.



---

###### 2. Class and Method Signature

```python
class Solution:
    def mergeKLists(self, l: list[Optional[ListNode]]) -> Optional[ListNode]:

```

* **Explanation:**
* Defines the standard LeetCode class wrapper and the `mergeKLists` method.
* Accepts a list of linked list heads (`l`) and returns the head of the newly merged sorted linked list.



---

###### 3. Min-Heap Initialization with Initial Nodes

```python
        h = []
        for i, x in enumerate(l):
            if x:
                heapq.heappush(h, (x.val, i, x))

```

* **Explanation:**
* `h = []`: Initializes an empty list to serve as our min-heap.
* `for i, x in enumerate(l):`: Iterates through the list of heads, tracking both the index `i` and the node `x`.
* `if x:`: Ensures we skip any empty/null linked lists.
* `heapq.heappush(h, (x.val, i, x))`: Pushes a tuple containing `(node_value, index, node_reference)` into the heap. Including the index `i` prevents comparison errors in Python if two nodes happen to share the exact same value.



---

###### 4. Dummy Node and Tail Pointer Setup

```python
        d = p = ListNode(0)

```

* **Explanation:**
* Creates a dummy node with a default value of `0` and assigns both `d` (head reference) and `p` (current tail pointer) to it. The dummy node simplifies building the new list by removing edge-case checks for the initial head.



---

###### 5. Main Heap Pop and Node Extraction

```python
        while h:
            _, i, x = heapq.heappop(h)

```

* **Explanation:**
* `while h:`: Runs continuously as long as there are nodes in the min-heap.
* `_, i, x = heapq.heappop(h)`: Extracts the smallest element from the heap (the node with the minimum value). We discard the value (`_`), keep the index `i`, and capture the actual node reference `x`.



---

###### 6. Appending to the Merged List and Advancing Pointer

```python
            p.next = x
            p = p.next

```

* **Explanation:**
* `p.next = x`: Links the extracted smallest node `x` to the end of our growing merged list.
* `p = p.next`: Moves the tail pointer `p` forward to this newly added node.



---

###### 7. Pushing the Next Node from the Same List

```python
            if x.next:
                heapq.heappush(h, (x.next.val, i, x.next))

```

* **Explanation:**
* `if x.next:`: Checks if the list from which we just extracted a node has any remaining elements.
* `heapq.heappush(...)`: If it does, pushes the next node (`x.next`) from that same list into the min-heap to keep track of the next candidate for the smallest value.



---

###### 8. Returning the Final Merged List

```python
        return d.next

```

* **Explanation:**
* Returns `d.next`, which skips the temporary dummy node placeholder and points directly to the true head of the fully merged sorted linked list.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \log k)$ | There are $N$ total nodes across all lists, and each node is inserted into and popped from the min-heap of size at most $k$. Heap operations take $O(\log k)$ time. |
| **Space Complexity** | $O(k)$ | The min-heap stores at most one node from each of the $k$ linked lists at any given time. |
