##### LeetCode 26: Remove Duplicates from Sorted Array — Solution Breakdown & Code Walkthrough

###### Overview

The goal of this algorithm is to remove duplicates from a sorted integer array (`a`) **in-place**, ensuring each unique element appears only once and returning the count (`j`) of unique elements. It uses a **two-pointer approach** (a slow write pointer `j` and a fast read pointer `i`) to overwrite duplicates in a single pass, achieving an optimal **$O(N)$ time complexity** and **$O(1)$ space complexity**.

---

###### Complete Solution Code

```java
//anxshh
class Solution {
    public int removeDuplicates(int[] a) {
        if (a.length == 0)
            return 0;

        int j = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j - 1])
                a[j++] = a[i];
        }

        return j;
    }
}

```

---

###### Line-by-Line Code Analysis

###### 1. Class and Method Signature

```java
//anxshh
class Solution {
    public int removeDuplicates(int[] a) {

```

* **Explanation:**
* `//anxshh`: Author comment tag.
* `class Solution`: Standard LeetCode wrapper class required for execution.
* `public int removeDuplicates(int[] a)`: Method signature accepting a sorted integer array `a` and returning an `int` representing the number of unique elements (`k`).



---

###### 2. Empty Array Edge Case Check

```java
        if (a.length == 0)
            return 0;

```

* **Explanation:**
* `if (a.length == 0) return 0;`: Handles the edge case where the input array is empty. If there are no elements, there are `0` unique elements, so it immediately returns `0` to prevent out-of-bounds errors later.



---

###### 3. Write Pointer Initialization

```java
        int j = 1;

```

* **Explanation:**
* `int j = 1;`: Initializes the slow "write" pointer `j` at index `1`. Because the array is sorted and non-empty, the element at index `0` (`a[0]`) is guaranteed to be unique and stays in place. Pointer `j` marks the next available slot where a newly discovered unique element should be placed.



---

###### 4. Fast Pointer Traversal Loop

```java
        for (int i = 1; i < a.length; i++) {

```

* **Explanation:**
* `for (int i = 1; i < a.length; i++)`: Initializes the fast "read" pointer `i` starting at index `1` and scans through the entire array up to the last element (`a.length - 1`).



---

###### 5. Duplicate Check & In-Place Overwrite

```java
            if (a[i] != a[j - 1])
                a[j++] = a[i];
        }

```

* **Explanation:**
* `if (a[i] != a[j - 1])`: Compares the current element being scanned (`a[i]`) with the last confirmed unique element stored at `a[j - 1]`. Since the array is sorted, any duplicate of `a[j - 1]` will be adjacent and equal to it.
* `a[j++] = a[i];`: When a new unique value is found (`a[i] != a[j - 1]`), it writes `a[i]` into position `j` and then increments `j` (`j++`) to prepare for the next unique element. If `a[i]` is a duplicate, the `if` condition is false, so `j` stays put while `i` keeps moving forward.



---

###### 6. Returning the Count of Unique Elements

```java
        return j;
    }
}

```

* **Explanation:**
* `return j;`: Once the loop finishes scanning the array, `j` represents both the index right after the last unique element and the exact total count of unique elements placed at the front of `a`.



---

###### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | Both pointers `i` and `j` traverse the array at most once, where $N$ is `a.length`. |
| **Space Complexity** | $O(1)$ | Modification is performed completely in-place using only two integer variables (`i` and `j`), requiring no extra auxiliary data structures. |
