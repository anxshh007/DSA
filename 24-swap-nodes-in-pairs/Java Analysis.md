##### Swap Nodes in Pairs — Java Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to swap every adjacent pair of nodes in a singly linked list and return its new head. It utilizes an iterative pointer-rearrangement approach with a dummy node to handle the head safely, achieving an optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```java
class Solution {
    public ListNode swapPairs(ListNode h) {
        ListNode d = new ListNode(0);
        d.next = h;

        ListNode p = d;

        while (p.next != null && p.next.next != null) {
            ListNode a = p.next;
            ListNode b = a.next;

            a.next = b.next;
            b.next = a;
            p.next = b;

            p = a;
        }

        return d.next;
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```java
class Solution {
    public ListNode swapPairs(ListNode h) {

```

* **Explanation:**
* Defines the standard LeetCode Solution class.
* `swapPairs` accepts the head node `h` of a singly linked list and returns the head of the modified list after swapping adjacent pairs.



---

###### 2. Dummy Node Initialization

```java
        ListNode d = new ListNode(0);
        d.next = h;

```

* **Explanation:**
* `ListNode d = new ListNode(0);`: Creates a dummy node with a value of `0` to simplify list manipulation and avoid edge cases when modifying the actual head of the list.
* `d.next = h;`: Links the dummy node to the original head of the linked list.



---

###### 3. Pointer Initialization

```java
        ListNode p = d;

```

* **Explanation:**
* `ListNode p = d;`: Initializes a tracking pointer `p` (representing the node *before* the pair being swapped) starting at the dummy node.



---

###### 4. Traversal Loop Condition

```java
        while (p.next != null && p.next.next != null) {

```

* **Explanation:**
* Ensures that there are at least two nodes remaining ahead of `p` to form a valid pair for swapping. If fewer than two nodes are left, the loop terminates.



---

###### 5. Identifying the Pair to Swap

```java
            ListNode a = p.next;
            ListNode b = a.next;

```

* **Explanation:**
* `ListNode a = p.next;`: Assigns the first node of the current pair to `a`.
* `ListNode b = a.next;`: Assigns the second node of the current pair to `b`.



---

###### 6. Swapping Nodes and Re-linking Pointers

```java
            a.next = b.next;
            b.next = a;
            p.next = b;

```

* **Explanation:**
* `a.next = b.next;`: Connects the first node (`a`) to the remainder of the linked list (skipping past `b`).
* `b.next = a;`: Reverses the pair by pointing the second node (`b`) to the first node (`a`).
* `p.next = b;`: Links the preceding portion of the list (via `p`) to the new head of the swapped pair (`b`).



---

###### 7. Advancing the Pointer

```java
            p = a;
        }

```

* **Explanation:**
* `p = a;`: Advances the pointer `p` two nodes forward (since `a` is now the second node in the swapped pair) to prepare for processing the next pair in the subsequent iteration.



---

###### 8. Returning the Result

```java
        return d.next;
    }
}

```

* **Explanation:**
* `return d.next;`: Returns the actual head of the modified linked list, which is stored right after the temporary dummy node `d`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm traverses each node of the linked list exactly once. |
| **Space Complexity** | $O(1)$ | It rearranges existing node pointers in place, requiring constant extra memory regardless of list size. |
