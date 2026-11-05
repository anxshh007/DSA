### 3Sum Closest — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find three integers in an array (`a`) whose sum is closest to a given target (`t`), and return that sum. It uses a **sorting + two-pointer approach** similar to the standard 3Sum problem, achieving an optimal **$O(N^2)$ time complexity**.

---

#### Complete Solution Code

```java
class Solution {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);

        int b = a[0] + a[1] + a[2];

        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1, h = a.length - 1;

            while (l < h) {
                int x = a[i] + a[l] + a[h];

                if (Math.abs(x - t) < Math.abs(b - t))
                    b = x;

                if (x < t)
                    l++;
                else if (x > t)
                    h--;
                else
                    return x;
            }
        }

        return b;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
class Solution {
    public int threeSumClosest(int[] a, int t) {

```

* **Explanation:**
* Defines the LeetCode wrapper class `Solution`.
* `threeSumClosest` takes an integer array `a` and an integer target `t`, returning an integer representing the closest triplet sum.



---

##### 2. Sorting and Initializing the Closest Sum

```java
        Arrays.sort(a);

        int b = a[0] + a[1] + a[2];

```

* **Explanation:**
* **`Arrays.sort(a)`**: Sorts the array in ascending order. Sorting is essential to efficiently navigate the array using the two-pointer technique.
* **`int b = a[0] + a[1] + a[2];`**: Initializes the closest sum (`b`) with the sum of the first three elements as an initial baseline reference point.



---

##### 3. Outer Loop

```java
        for (int i = 0; i < a.length - 2; i++) {

```

* **Explanation:**
* Iterates through the array, fixing `a[i]` as the first element of our triplet.
* We stop at `a.length - 2` to ensure there is always enough room for the two pointer elements (`l` and `h`).



---

##### 4. Two-Pointer Initialization

```java
            int l = i + 1, h = a.length - 1;

```

* **Explanation:**
* Initializes two pointers for the remaining subarray to the right of `i`:
* **`l` (left pointer)**: Starts right after `i` (`i + 1`).
* **`h` (high pointer)**: Starts at the very end of the array (`a.length - 1`).





---

##### 5. Inner While Loop & Triplet Sum Calculation

```java
            while (l < h) {
                int x = a[i] + a[l] + a[h];

```

* **Explanation:**
* **`while (l < h)`**: Continues running as long as the left pointer has not crossed or met the high pointer.
* **`int x = a[i] + a[l] + a[h];`**: Calculates the sum of the current triplet formed by the fixed element and the two pointer elements.



---

##### 6. Updating the Closest Sum

```java
                if (Math.abs(x - t) < Math.abs(b - t))
                    b = x;

```

* **Explanation:**
* Computes the absolute difference between the current triplet sum (`x`) and the target (`t`), and compares it with the difference between the current best sum (`b`) and `t`.
* If `x` is closer to the target than `b`, updates `b` to store `x`.



---

##### 7. Adjusting Pointers Based on Sum Magnitude

```java
                if (x < t)
                    l++;
                else if (x > t)
                    h--;
                else
                    return x;
            }
        }

```

* **Explanation:**
* **`x < t`**: The sum is smaller than the target. Because the array is sorted, we increment `l` (`l++`) to pick a larger number and increase the sum.
* **`x > t`**: The sum is larger than the target. We decrement `h` (`h--`) to pick a smaller number and decrease the sum.
* **`else` (Exact Match)**: If `x == t`, we found a triplet that matches the target exactly, so we can return `x` immediately as the optimal answer.



---

##### 8. Returning the Final Result

```java
        return b;
    }
}

```

* **Explanation:**
* After checking all possible triplet combinations, returns the closest sum `b` found across the entire array.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^2)$ | Sorting takes $O(N \log N)$ time, and the nested structure (outer loop combined with the two-pointer linear scan) takes $O(N^2)$ time. Thus, the overall time complexity is dominated by $O(N^2)$. |
| **Space Complexity** | $O(1)$ or $O(\log N)$ | Auxiliary space depends on the sorting algorithm implementation (typically $O(\log N)$ to $O(N)$ space for sorting internal stacks), using constant extra space for pointers otherwise. |
