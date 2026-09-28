# Median of Two Sorted Arrays — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to find the median of two sorted arrays (`nums1` and `nums2`) of size $m$ and $n$ respectively. Instead of merging the two arrays into a new sorted array (which would take $O(m + n)$ time), this solution uses a **binary search algorithm** on the smaller array to partition both arrays simultaneously, achieving an optimal time complexity of $O(\log(\min(m, n)))$.

---

## Complete Solution Code

```java
//anxshh
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

```

---

## Line-by-Line Code Analysis

### 1. Class and Method Signature

```java
//anxshh
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

```

* **Explanation:**
* Defines the `Solution` class standard in LeetCode platforms.


* `findMedianSortedArrays` accepts two 0-indexed sorted integer arrays (`nums1` and `nums2`) and returns a `double` representing the combined median value.





---

### 2. Ensuring Binary Search Runs on the Smaller Array

```java
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

```

* **Explanation:**
* Checks if `nums1` is longer than `nums2`. If so, it recursively calls `findMedianSortedArrays` with the arguments swapped.
* Running binary search on the smaller array minimizes search range iterations and ensures `partition2` calculation remains within valid array bounds.



---

### 3. Length Initialization and Binary Search Bounds

```java
        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

```

* **Explanation:**
* `m` and `n` store the sizes of `nums1` and `nums2` respectively.
* `low = 0` and `high = m` define the search space range for binary searching the cut index in `nums1`.



---

### 4. Partition Calculations

```java
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

```

* **Explanation:**
* `while (low <= high)`: Standard binary search loop structure.
* `partition1`: Midpoint division of elements taken from `nums1`.
* `partition2`: Automatically calculates how many elements must be taken from `nums2` to form the left half of the combined elements. The `+ 1` ensures that when total elements $(m + n)$ are odd, the left half contains the extra median element.



---

### 5. Boundary Values for `nums1` Partition

```java
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

```

* **Explanation:**
* `left1`: Largest element on the left side of `nums1` partition. If `partition1 == 0`, no elements are selected from `nums1`, so set to `Integer.MIN_VALUE` to avoid out-of-bounds error.
* `right1`: Smallest element on the right side of `nums1` partition. If `partition1 == m`, all elements are selected, so set to `Integer.MAX_VALUE`.



---

### 6. Boundary Values for `nums2` Partition

```java
            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

```

* **Explanation:**
* `left2`: Largest element on the left side of `nums2` partition. Handles `partition2 == 0` boundary edge case using `Integer.MIN_VALUE`.
* `right2`: Smallest element on the right side of `nums2` partition. Handles `partition2 == n` boundary edge case using `Integer.MAX_VALUE`.



---

### 7. Valid Partition Check & Median Calculation

```java
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;

```

* **Explanation:**
* **Condition (`left1 <= right2 && left2 <= right1`)**: Validates that all elements in the combined left side are smaller than or equal to all elements in the combined right side.
* **Odd Total Length**: If $(m + n)$ is odd, the median is the maximum of the left-side elements (`Math.max(left1, left2)`).
* **Even Total Length**: If $(m + n)$ is even, the median is the average of the largest element on the left side (`leftMax`) and the smallest element on the right side (`rightMin`), calculated with floating-point division `/ 2.0`.



---

### 8. Binary Search Adjustment & Fallback Exception

```java
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}

```

* **Explanation:**
* `left1 > right2`: `nums1` has too many large elements in the left partition. Decrease `high` to move `partition1` leftward.
* `left2 > right1`: `nums1` doesn't have enough elements in the left partition. Increase `low` to move `partition1` rightward.
* `throw new IllegalArgumentException(...)`: Thrown if binary search terminates without finding a partition (occurs if inputs are unsorted).



---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(\log(\min(m, n)))$ | Binary search is performed on the smaller array of length $\min(m, n)$. |
| **Space Complexity** | $O(1)$ | Uses constant extra space with basic pointers and scalar variables. |
