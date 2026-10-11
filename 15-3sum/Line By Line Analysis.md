### 3Sum — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find all unique triplets in an array (`a`) that sum up to zero ($a[i] + a[j] + a[k] = 0$). It uses a **sorting + two-pointer approach** to achieve an optimal **$O(N^2)$ time complexity**, avoiding duplicate triplets effectively.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public List<List<Integer>> threeSum(int[] a) {

        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i-1]) continue;
            if (a[i] > 0) break;

            int l = i + 1, h = a.length - 1;

            while (l < h) {
                int x = a[i] + a[l] + a[h];

                if (x == 0) {
                    r.add(Arrays.asList(a[i], a[l], a[h]));

                    while (l < h && a[l] == a[l+1]) l++;
                    while (l < h && a[l] == a[h - 1]) h--;

                    l++;
                    h--;
                } 
                else if (x < 0) {
                    l++;
                } 
                else {
                    h--;
                }
            }
        }

        return r;
        
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
//anxshh
class Solution {
    public List<List<Integer>> threeSum(int[] a) {

```

* **Explanation:**
* Defines the LeetCode wrapper class `Solution`.
* `threeSum` takes an integer array `a` and returns a list of lists containing all unique triplets that sum to zero.



---

##### 2. Result Initialization and Sorting

```java
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(a);

```

* **Explanation:**
* **`List<List<Integer>> r`**: Initializes a list `r` to store the final valid triplets.
* **`Arrays.sort(a)`**: Sorts the array in ascending order. Sorting is crucial because it allows us to use the two-pointer technique and easily skip duplicate values.



---

##### 3. Outer Loop & Duplicate Skipping for the First Element

```java
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i-1]) continue;

```

* **Explanation:**
* **`for (int i = 0; i < a.length - 2; i++)`**: Iterates through the array, treating `a[i]` as the first element of our triplet. We stop at `a.length - 2` to leave room for the two pointer elements.
* **`if (i > 0 && a[i] == a[i-1]) continue;`**: Skips duplicate elements for the first position to ensure we don't add duplicate triplets to our result list.



---

##### 4. Early Exit Optimization

```java
            if (a[i] > 0) break;

```

* **Explanation:**
* Since the array is sorted, if the current number `a[i]` is greater than zero, any subsequent numbers will also be positive. Therefore, their sum can never equal zero, allowing us to safely break out of the loop early.



---

##### 5. Two-Pointer Initialization

```java
            int l = i + 1, h = a.length - 1;

```

* **Explanation:**
* Initializes two pointers for the remaining portion of the array:
* **`l` (left pointer)**: Starts right after `i` (`i + 1`).
* **`h` (high pointer)**: Starts at the very end of the array (`a.length - 1`).





---

##### 6. Inner While Loop & Triplet Sum Calculation

```java
            while (l < h) {
                int x = a[i] + a[l] + a[h];

```

* **Explanation:**
* **`while (l < h)`**: Runs as long as the left pointer hasn't crossed or met the high pointer.
* **`int x = a[i] + a[l] + a[h];`**: Calculates the sum of the current triplet formed by `a[i]`, `a[l]`, and `a[h]`.



---

##### 7. Handling Zero Sum and Skipping Duplicates

```java
                if (x == 0) {
                    r.add(Arrays.asList(a[i], a[l], a[h]));

                    while (l < h && a[l] == a[l+1]) l++;
                    while (l < h && a[l] == a[h - 1]) h--;

                    l++;
                    h--;
                } 

```

* **Explanation:**
* **`x == 0`**: We found a valid triplet! Add it to our result list `r`.
* **Inner `while` loops**: Skip consecutive duplicate values for both the left and right pointers to prevent adding duplicate triplets. *(Note: The second inner while loop checks `a[l] == a[h - 1]`, which corresponds to skipping duplicates from the right side).*
* **`l++; h--;`**: Move both pointers inward to search for new potential pairs.



---

##### 8. Adjusting Pointers Based on Sum Magnitude

```java
                else if (x < 0) {
                    l++;
                } 
                else {
                    h--;
                }
            }
        }

```

* **Explanation:**
* **`x < 0`**: The sum is too small (less than zero). Since the array is sorted, we increment the left pointer (`l++`) to pick a larger number and increase the sum.
* **`x > 0`**: The sum is too large. We decrement the high pointer (`h--`) to pick a smaller number and decrease the sum.



---

##### 9. Returning the Result

```java
        return r;
        
    }
}

```

* **Explanation:**
* Returns the final list of unique triplets `r`.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^2)$ | Sorting takes $O(N \log N)$ time, and the nested loop structure (outer loop combined with the two-pointer scan) takes $O(N^2)$ time. Thus, the overall time complexity is dominated by $O(N^2)$. |
| **Space Complexity** | $O(1)$ or $O(N)$ | Auxiliary space depends on the sorting algorithm implementation (usually $O(\log N)$ to $O(N)$ space for sorting), excluding the space needed to store the output result list. |
