### LeetCode 90: Subsets II — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find all possible subsets (the power set) of an integer array that may contain duplicates, ensuring that all returned subsets are **unique**. It uses a **sorting followed by backtracking** approach to efficiently skip duplicate choices at the same recursion level.

---

#### Complete Solution Code

```java
//Approach: The approach uses sorting followed by backtracking to generate all unique subsets by recursively including elements and skipping adjacent duplicates at the same recursion level.

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> r = new ArrayList<>();
        f(0, a, new ArrayList<>(), r);
        return r;
    }

    void f(int i, int[] a, List<Integer> t, List<List<Integer>> r) {
        r.add(new ArrayList<>(t));
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            t.add(a[j]);
            f(j + 1, a, t, r);
            t.remove(t.size() - 1);
        }
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Imports and Class Definition

```java
import java.util.*;

class Solution {

```

* **Explanation:**
* `import java.util.*;`: Imports standard Java utility classes like `List`, `ArrayList`, and `Arrays`.
* `class Solution`: Defines the LeetCode wrapper class required for execution.



---

##### 2. Main Method Signature & Initialization

```java
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> r = new ArrayList<>();

```

* **Explanation:**
* **`public List<List<Integer>> subsetsWithDup(int[] a)`**: The entry point method that takes an integer array `a` and returns a list of all unique subsets.
* **`Arrays.sort(a)`**: Sorts the array in ascending order. Sorting is essential because it groups duplicate elements together, allowing us to easily skip duplicate subsets during backtracking.
* **`List<List<Integer>> r = new ArrayList<>();`**: Initializes the result list `r` to store all generated subsets.



---

##### 3. Initiating Backtracking & Returning Result

```java
        f(0, a, new ArrayList<>(), r);
        return r;
    }

```

* **Explanation:**
* **`f(0, a, new ArrayList<>(), r);`**: Calls the recursive helper function `f` starting from index `0`, with an empty temporary list `t` to build subsets, passing along the result list `r`.
* **`return r;`**: Returns the final populated list of unique subsets.



---

##### 4. Recursive Helper Method Signature & Adding Subsets

```java
    void f(int i, int[] a, List<Integer> t, List<List<Integer>> r) {
        r.add(new ArrayList<>(t));

```

* **Explanation:**
* **`void f(...)`**: The recursive backtracking function. `i` represents the current starting index in the array, `a` is the input array, `t` holds the current subset path, and `r` accumulates all valid subsets.
* **`r.add(new ArrayList<>(t));`**: Since *every* state in the recursion tree represents a valid subset, we add a new copy of the current subset `t` into our result list `r`.



---

##### 5. Exploration Loop & Duplicate Skipping

```java
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;

```

* **Explanation:**
* **`for (int j = i; j < a.length; j++)`**: Iterates through the array starting from index `i` to choose elements for the current subset level.
* **`if (j > i && a[j] == a[j - 1]) continue;`**: Skips adjacent duplicate elements at the same recursion level. If we encounter a duplicate value (`a[j] == a[j - 1]`) and it is not the first time we are picking an element at this level (`j > i`), we `continue` to avoid generating identical subset branches.



---

##### 6. Element Inclusion, Recursive Call, and Backtracking

```java
            t.add(a[j]);
            f(j + 1, a, t, r);
            t.remove(t.size() - 1);
        }
    }
}

```

* **Explanation:**
* **`t.add(a[j]);`**: Chooses the current element by adding it to our temporary subset list `t`.
* **`f(j + 1, a, t, r);`**: Recursively calls `f` for the next index (`j + 1`) to build further subsets with the chosen element included.
* **`t.remove(t.size() - 1);`**: Backtracks by removing the last added element from `t`, allowing the loop to try the next available element cleanly.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \cdot 2^N)$ | In the worst case, there can be up to $2^N$ subsets for an array of size $N$. Copying each subset into the result list takes $O(N)$ time, plus the time required for initial sorting ($O(N \log N)$). |
| **Space Complexity** | $O(N)$ | Auxiliary recursion stack space and temporary subset storage scale linearly with the maximum depth of the recursion tree $N$ (excluding the space needed to store the output result list). |
