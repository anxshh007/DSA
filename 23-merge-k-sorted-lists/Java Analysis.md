### Merge k Sorted Lists — Java Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to merge $k$ sorted linked lists into a single sorted linked list. It uses a **Min-Priority Queue (Min-Heap)** to efficiently track and extract the smallest available node across all lists at any given time, achieving an optimal **$O(N \log k)$ time complexity** (where $N$ is the total number of nodes across all lists and $k$ is the number of linked lists) and **$O(k)$ space complexity**.

---

#### Complete Solution Code

```java
class Solution {
    public ListNode mergeKLists(ListNode[] a) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            (x, y) -> x.val - y.val
        );

        for (ListNode x : a)
            if (x != null)
                q.add(x);

        ListNode d = new ListNode(0);
        ListNode c = d;

        while (!q.isEmpty()) {
            ListNode x = q.poll();
            c.next = x;
            c = c.next;

            if (x.next != null)
                q.add(x.next);
        }

        return d.next;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
class Solution {
    public ListNode mergeKLists(ListNode[] a) {

```

* **Explanation:**
* `class Solution`: Standard wrapper class for LeetCode solutions.
* `public ListNode mergeKLists(ListNode[] a)`: Method signature that accepts an array of linked list heads (`ListNode[] a`) and returns the head of the newly merged sorted linked list.



---

##### 2. Priority Queue Initialization

```java
        PriorityQueue<ListNode> q = new PriorityQueue<>(
            (x, y) -> x.val - y.val
        );

```

* **Explanation:**
* `PriorityQueue<ListNode> q`: Declares a min-priority queue to store `ListNode` elements.
* `(x, y) -> x.val - y.val`: A lambda expression acting as a custom comparator, ensuring that nodes with smaller integer values are kept at the top (head) of the priority queue.



---

##### 3. Initializing the Heap with List Heads

```java
        for (ListNode x : a)
            if (x != null)
                q.add(x);

```

* **Explanation:**
* Iterates through each head node `x` in the input array `a`.
* `if (x != null)`: Checks to ensure the linked list is not empty before adding its head node to the priority queue.



---

##### 4. Dummy Node and Current Pointer Setup

```java
        ListNode d = new ListNode(0);
        ListNode c = d;

```

* **Explanation:**
* `ListNode d = new ListNode(0)`: Creates a dummy placeholder node with a value of `0` to anchor the start of the merged list.
* `ListNode c = d`: Initializes a current tail pointer `c` pointing to the dummy node to help construct the merged list sequentially.



---

##### 5. Main Traversal and Extraction Loop

```java
        while (!q.isEmpty()) {
            ListNode x = q.poll();
            c.next = x;
            c = c.next;

```

* **Explanation:**
* `while (!q.isEmpty())`: Continues looping as long as there are nodes remaining in the priority queue.
* `ListNode x = q.poll()`: Extracts the node with the minimum value from the heap.
* `c.next = x` and `c = c.next`: Appends this minimum node to our merged list and advances the current pointer `c` forward.



---

##### 6. Processing Next Nodes

```java
            if (x.next != null)
                q.add(x.next);
        }

```

* **Explanation:**
* `if (x.next != null)`: If the extracted node has a successor in its original linked list, that successor is added to the priority queue so its value can be evaluated in subsequent iterations.



---

##### 7. Returning the Result

```java
        return d.next;
    }
}

```

* **Explanation:**
* `return d.next`: Returns `d.next`, which skips the initial dummy node and points directly to the head of the newly merged sorted linked list.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \log k)$ | Inserting and extracting nodes from the priority queue takes $O(\log k)$ time per node, where $k$ is the number of linked lists and $N$ is the total number of nodes across all lists. |
| **Space Complexity** | $O(k)$ | The priority queue stores at most one node from each of the $k$ linked lists at any given time. |
