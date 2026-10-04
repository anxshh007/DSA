### Container With Most Water — Solution Breakdown & Code Walkthrough

#### Overview

The goal of this algorithm is to find two lines in an array (`h` representing heights) that, together with the x-axis, form a container that holds the most water. Using a **two-pointer approach**, the algorithm starts with the widest possible container (the two outer boundaries) and systematically narrows the distance while searching for taller lines, achieving an optimal **$O(N)$ time complexity**.

---

#### Complete Solution Code

```java
//anxshh
class Solution {
    public int maxArea(int[] h) {
        int l=0, r=h.length-1;
        int ans=0;

        while (l<r) {
            int a = Math.min(h[l], h[r]) * (r-l);
            ans = Math.max(ans,a);

            if (h[l] < h[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Class and Method Signature

```java
//anxshh
class Solution {
    public int maxArea(int[] h) {

```

* **Explanation:**
* Defines the `Solution` class standard on LeetCode platforms.


* `maxArea` accepts an integer array `h` (representing the height of each line) and returns an integer representing the maximum calculated container area.





---

##### 2. Two-Pointer and Result Initialization

```java
        int l=0, r=h.length-1;
        int ans=0;

```

* **Explanation:**
* `l = 0`: Initializes the left pointer at the beginning of the array.
* `r = h.length - 1`: Initializes the right pointer at the last index of the array.


* `ans = 0`: Tracks the maximum water area found so far.





---

##### 3. Main Two-Pointer Loop

```java
        while (l<r) {

```

* **Explanation:**
* The loop continues as long as the left pointer is strictly less than the right pointer (`l < r`).


* Once the pointers meet, all viable container combinations have been evaluated.



---

##### 4. Current Area Calculation

```java
            int a = Math.min(h[l], h[r]) * (r-l);

```

* **Explanation:**
* Calculates the water area contained between lines at indices `l` and `r`:
* **Height (`Math.min(h[l], h[r])`)**: Water level is limited by the shorter of the two boundary lines.


* **Width (`r - l`)**: Distance between the two lines on the x-axis.


* Multiplies height by width to determine the area `a`.





---

##### 5. Maximum Area Update

```java
            ans = Math.max(ans,a);

```

* **Explanation:**
* Compares current area `a` with the previous maximum area `ans`.


* Updates `ans` if a larger area is found.





---

##### 6. Pointer Movement Logic

```java
            if (h[l] < h[r])
                l++;
            else
                r--;
        }

```

* **Explanation:**
* **Greedy Strategy**: To potentially find a larger area with a smaller width, we must move the pointer with the **shorter height**.


* If `h[l] < h[r]`: Increments `l` forward to look for a taller left line.


* `else`: Decrements `r` backward to look for a taller right line.


* Moving the taller line's pointer would only reduce width without increasing the constraining height.



---

##### 7. Returning Result

```java
        return ans;
    }
}

```

* **Explanation:**
* Returns `ans`, which holds the maximum water capacity calculated after evaluating all candidate boundaries.





---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The algorithm uses a single loop where `l` and `r` move toward each other, traversing the array of size $N$ at most once.

 |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory for pointers and area tracking variables.

 |
