# Add Two Numbers — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to solve **LeetCode Problem 2: Add Two Numbers**. It adds two numbers represented by two non-empty linked lists where digits are stored in **reverse order**, and each node contains a single digit. The algorithm iterates through both lists simultaneously, adds corresponding digits along with any carried over value, and builds a new result linked list in **$O(\max(N, M))$ time complexity** and **$O(\max(N, M))$ space complexity**.

---

## Complete Solution Code

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0), c = h;
        int k = 0;
        
        while (l1 != null || l2 != null || k != 0) {
            int s = k;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            k = s / 10;
            c.next = new ListNode(s % 10);
            c = c.next;
        }
        
        return h.next;
    }
}

```

---

## Line-by-Line Code Analysis

### 1. Class Definition & Method Signature

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

```

* **Explanation:** Standard LeetCode class wrapper and method declaration accepting two linked list heads, `l1` and `l2`, returning the head of the resulting linked list.



---

### 2. Dummy Node and Variables Initialization

```java
        ListNode h = new ListNode(0), c = h;
        int k = 0;

```

* **Explanation:**
* `ListNode h = new ListNode(0)`: Creates a dummy node `h` initialized with a value of `0`. This acts as a placeholder to simplify building the result list without dealing with edge cases for the head node.
* `c = h`: A current pointer `c` starting at the dummy node `h`, used to append new nodes to the result list sequentially.
* `int k = 0`: Variable `k` initializes the carry value to `0` (used when the sum of two digits exceeds `9`).



---

### 3. Main Iteration Loop

```java
        while (l1 != null || l2 != null || k != 0) {

```

* **Explanation:**
* Continues the loop as long as there are digits remaining in either `l1` or `l2`, or there is a leftover carry `k` from the previous addition.



---

### 4. Sum Initialization & First List Addition

```java
            int s = k;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }

```

* **Explanation:**
* `int s = k`: Initializes the current sum `s` with the carry `k` carried over from the previous step.
* `if (l1 != null)`: Checks if list `l1` still has nodes. If so, adds its current value `l1.val` to `s` and advances `l1` to the next node (`l1 = l1.next`).





---

### 5. Second List Addition

```java
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }

```

* **Explanation:**
* `if (l2 != null)`: Checks if list `l2` still has nodes. If so, adds its current value `l2.val` to `s` and advances `l2` to the next node (`l2 = l2.next`).





---

### 6. Carry Calculation & New Node Creation

```java
            k = s / 10;
            c.next = new ListNode(s % 10);
            c = c.next;
        }

```

* **Explanation:**
* `k = s / 10`: Computes the new carry for the next iteration via integer division (e.g., if sum is `15`, carry `k` becomes `1`).
* `c.next = new ListNode(s % 10)`: Extracts the units digit via modulo (`s % 10`), creates a new node with this value, and links it to the result list.


* `c = c.next`: Advances the current pointer `c` to the newly added node.





---

### 7. Returning the Result Head

```java
        return h.next;
    }
}

```

* **Explanation:**
* Returns `h.next`, which points to the actual head of the resulting linked list, skipping the initial dummy node `h`.





---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\max(N, M))$ | Where $N$ and $M$ are the lengths of `l1` and `l2` respectively. The loop iterates a maximum of $\max(N, M) + 1$ times to process all digits and any final carry. |
| **Space Complexity** | $O(\max(N, M))$ | The length of the newly created result linked list is at most $\max(N, M) + 1$ nodes.

 |
