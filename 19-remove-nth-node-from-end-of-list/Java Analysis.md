### Remove Nth Node From End of List — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to remove the $N$-th node from the end of a singly-linked list and return its head. It uses an optimal **two-pointer approach** (often called the fast and slow pointer technique) to achieve this in a single pass with an **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {
        ListNode d = new ListNode(0, h);
        ListNode a = d, b = d;

        for (int i = 0; i < n; i++) {
            b = b.next;
        }

        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

        a.next = a.next.next;
        return d.next;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
//anxshh
class Solution {
    public ListNode removeNthFromEnd(ListNode h, int n) {

```

* **Explanation:**
* Defines the standard LeetCode `Solution` class wrapper.
* `removeNthFromEnd` takes two parameters: `h` (the head of the linked list) and `n` (the target position from the end of the list to remove). It returns the head of the modified linked list.



---

##### 2. Dummy Node and Pointer Initialization

```java
        ListNode d = new ListNode(0, h);
        ListNode a = d, b = d;

```

* **Explanation:**
* **`ListNode d = new ListNode(0, h)`**: Creates a dummy node with a value of `0` pointing to the original head `h`. Using a dummy node safely handles edge cases, such as when the head node itself needs to be removed.
* **`ListNode a = d, b = d`**: Initializes two pointers (`a` as the slow pointer and `b` as the fast pointer) pointing to the dummy node.



---

##### 3. Fast Pointer Offset Loop

```java
        for (int i = 0; i < n; i++) {
            b = b.next;
        }

```

* **Explanation:**
* A loop runs `n` times to advance the fast pointer `b` forward by `n` steps.
* This creates a fixed distance (or gap) of `n` nodes between the slow pointer `a` and the fast pointer `b`.



---

##### 4. Main Traversal Loop

```java
        while (b.next != null) {
            a = a.next;
            b = b.next;
        }

```

* **Explanation:**
* Both pointers `a` and `b` are moved forward together step-by-step until the fast pointer `b` reaches the last node of the list (`b.next == null`).
* Because of the initial `n`-step gap, when `b` reaches the end, the slow pointer `a` will be positioned precisely **at the node right before** the target node to be deleted.



---

##### 5. Node Removal

```java
        a.next = a.next.next;

```

* **Explanation:**
* Bypasses the target node by updating `a.next` to point directly to `a.next.next`. This effectively unlinks and removes the $N$-th node from the list.



---

##### 6. Result Return

```java
        return d.next;
    }
}

```

* **Explanation:**
* Returns `d.next`, which is the actual head of the modified linked list (skipping over our temporary dummy node `d`).



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm traverses the linked list in a single pass, where $N$ is the total number of nodes in the list. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra space with only a few pointer variables (`d`, `a`, `b`), regardless of the linked list length. |
