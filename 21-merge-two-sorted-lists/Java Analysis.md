### Merge Two Sorted Lists — Java Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to merge two sorted singly linked lists (`a` and `b`) into a single sorted linked list. It uses a dummy node approach to efficiently build the merged list in-place by comparing the current nodes of both lists iteratively, achieving **$O(N + M)$ time complexity** and **$O(1)$ space complexity**.

---

#### Complete Solution Code

```java
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode d = new ListNode(0);
        ListNode c = d;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }

        c.next = (a != null) ? a : b;
        return d.next;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {

```

* **Explanation:**
* `class Solution:`: Standard LeetCode wrapper class.
* `public ListNode mergeTwoLists(ListNode a, ListNode b)`: Method signature that accepts the heads of two sorted linked lists (`a` and `b`) and returns the head of the newly merged sorted linked list.



---

##### 2. Dummy Node and Current Pointer Initialization

```java
        ListNode d = new ListNode(0);
        ListNode c = d;

```

* **Explanation:**
* `ListNode d = new ListNode(0)`: Creates a dummy node with an initial value of `0`. This placeholder simplifies list construction by removing edge cases for handling the head of the new list.
* `ListNode c = d`: Initializes a current pointer `c` pointing to the dummy node. `c` will track the tail of the merged list as we append nodes.



---

##### 3. Main Traversal Loop

```java
        while (a != null && b != null) {

```

* **Explanation:**
* `while (a != null && b != null)`: Continues looping as long as both lists still have nodes to process. Once either list is exhausted, the loop terminates.



---

##### 4. Node Comparison and Attachment

```java
            if (a.val <= b.val) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }

```

* **Explanation:**
* `if (a.val <= b.val)`: Compares the values of the current nodes in both lists.
* If `a`'s value is smaller or equal:
* `c.next = a`: Attaches node `a` to the merged list after `c`.
* `a = a.next`: Advances pointer `a` to its next node.


* If `b`'s value is smaller:
* `c.next = b`: Attaches node `b` to the merged list after `c`.
* `b = b.next`: Advances pointer `b` to its next node.





---

##### 5. Advancing the Current Pointer

```java
            c = c.next;
        }

```

* **Explanation:**
* `c = c.next`: Moves the current tail pointer `c` forward to the newly attached node so it's ready for the next iteration.



---

##### 6. Attaching Remaining Nodes

```java
        c.next = (a != null) ? a : b;

```

* **Explanation:**
* `c.next = (a != null) ? a : b`: Since one of the lists (`a` or `b`) might still have remaining nodes after the loop ends, this attaches the non-null remainder directly to the end of the merged list.



---

##### 7. Returning the Result

```java
        return d.next;
    }
}

```

* **Explanation:**
* `return d.next`: Returns `d.next`, which is the actual head of the merged list (skipping the initial dummy node `0`).



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N + M)$ | The algorithm traverses every node in both lists `a` (length $N$) and `b` (length $M$) at most once. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra space by rearranging existing node pointers instead of creating new nodes. |
