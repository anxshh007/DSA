### 4Sum — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find all unique quadruplets in an array (`a`) that sum up to a given target (`t`), i.e., $a[i] + a[j] + a[l] + a[k] = t$. It extends the **sorting + two-pointer approach** used in 3Sum by adding a second nested loop, achieving an optimal **$O(N^3)$ time complexity** while carefully avoiding duplicate quadruplets.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public List<List<Integer>> fourSum(int[] a, long t) {
        List<List<Integer>> r = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int l = j + 1, k = n - 1;

                while (l < k) {
                    long s = (long)a[i] + a[j] + a[l] + a[k];

                    if (s == t) {
                        r.add(Arrays.asList(a[i], a[j], a[l], a[k]));
                        while (l < k && a[l] == a[l + 1]) l++;
                        while (l < k && a[k] == a[k - 1]) k--;
                        l++;
                        k--;
                    } else if (s < t) {
                        l++;
                    } else {
                        k--;
                    }
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
    public List<List<Integer>> fourSum(int[] a, long t) {

```

* **Explanation:**
* Defines the LeetCode wrapper class `Solution`.
* `fourSum` takes an integer array `a` and a target `t` (of type `long` to prevent integer overflow during addition), returning a list of lists containing all unique quadruplets that sum to `t`.



---

##### 2. Result Initialization, Array Length, and Sorting

```java
        List<List<Integer>> r = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);

```

* **Explanation:**
* **`List<List<Integer>> r`**: Initializes a list to store the final valid quadruplets.
* **`int n = a.length`**: Stores the total number of elements in the array.
* **`Arrays.sort(a)`**: Sorts the array in ascending order. Sorting is essential for utilizing the two-pointer technique and efficiently skipping duplicates.



---

##### 3. First Outer Loop & Duplicate Skipping for the First Element

```java
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

```

* **Explanation:**
* **`for (int i = 0; i < n - 3; i++)`**: Iterates through the array to fix the first element of our quadruplet, stopping at `n - 3` to leave space for the remaining three elements.
* **`if (i > 0 && a[i] == a[i - 1]) continue;`**: Skips duplicate elements for the first position to avoid adding duplicate quadruplets to the result list.



---

##### 4. Second Outer Loop & Duplicate Skipping for the Second Element

```java
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;

```

* **Explanation:**
* **`for (int j = i + 1; j < n - 2; j++)`**: Iterates through the remaining array elements to fix the second element of our quadruplet, stopping at `n - 2`.
* **`if (j > i + 1 && a[j] == a[j - 1]) continue;`**: Skips duplicate elements for the second position to maintain uniqueness among the final combinations.



---

##### 5. Two-Pointer Initialization

```java
                int l = j + 1, k = n - 1;

```

* **Explanation:**
* Initializes two pointers for the remaining portion of the array:
* **`l` (left pointer)**: Starts right after `j` (`j + 1`).
* **`k` (right/high pointer)**: Starts at the very end of the array (`n - 1`).





---

##### 6. Inner While Loop & Quadruplet Sum Calculation

```java
                while (l < k) {
                    long s = (long)a[i] + a[j] + a[l] + a[k];

```

* **Explanation:**
* **`while (l < k)`**: Runs as long as the left pointer has not crossed or met the right pointer.
* **`long s = (long)a[i] + a[j] + a[l] + a[k];`**: Calculates the sum of the current quadruplet. Casting to `long` prevents integer overflow issues that can occur when adding large array elements.



---

##### 7. Handling Target Match and Skipping Inner Duplicates

```java
                    if (s == t) {
                        r.add(Arrays.asList(a[i], a[j], a[l], a[k]));
                        while (l < k && a[l] == a[l + 1]) l++;
                        while (l < k && a[k] == a[k - 1]) k--;
                        l++;
                        k--;

```

* **Explanation:**
* **`s == t`**: A valid quadruplet is found! Add it to the result list `r`.
* **`while` loops**: Skip consecutive duplicate values for both the left (`l`) and right (`k`) pointers to prevent duplicate entries.
* **`l++; k--;`**: Move both pointers inward to search for new potential pairs.



---

##### 8. Adjusting Pointers Based on Sum Magnitude

```java
                    } else if (s < t) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }

```

* **Explanation:**
* **`s < t`**: The sum is smaller than the target. Since the array is sorted, we increment `l` (`l++`) to pick a larger number and increase the sum.
* **`s > t`**: The sum is larger than the target. We decrement `k` (`k--`) to pick a smaller number and decrease the sum.



---

##### 9. Returning the Final Result

```java
        return r;
    }
}

```

* **Explanation:**
* Returns the complete list of unique quadruplets `r`.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N^3)$ | Sorting takes $O(N \log N)$ time, and the nested loops combined with the two-pointer scan take $O(N^3)$ time, which dominates the overall runtime. |
| **Space Complexity** | $O(1)$ or $O(\log N)$ | Auxiliary space depends on the sorting algorithm's internal stack usage, excluding the space required to store the output result list. |
