### Container With Most Water — Python Solution Breakdown

#### Overview

The goal of this algorithm is to find two lines in an array (`h`) that, together with the x-axis, form a container holding the maximum amount of water. Using a **two-pointer approach**, the algorithm starts with the widest possible container (outer boundaries) and narrows down the search space systematically, achieving an optimal **$O(N)$ time complexity**.

---

#### Complete Solution Code

```python
def maxArea(h):
    l, r, m = 0, len(h) - 1, 0
    while l < r:
        m = max(m, min(h[l], h[r]) * (r - l))
        if h[l] < h[r]: l += 1
        else: r -= 1
    return m

```

---

#### Line-by-Line Code Analysis

##### 1. Function Signature

```python
def maxArea(h):

```

* **Explanation:**
* Defines the function `maxArea` which accepts a list of integers `h` representing the heights of the vertical lines.



---

##### 2. Initialization of Pointers and Maximum Area

```python
    l, r, m = 0, len(h) - 1, 0

```

* **Explanation:**
* `l = 0`: Initializes the left pointer at the start of the list.
* `r = len(h) - 1`: Initializes the right pointer at the last index of the list.
* `m = 0`: Tracks the maximum area of water found so far.



---

##### 3. Main Two-Pointer Loop

```python
    while l < r:

```

* **Explanation:**
* The loop runs as long as the left pointer is strictly less than the right pointer. Once they meet, all potential container combinations have been checked.



---

##### 4. Area Calculation and Update

```python
        m = max(m, min(h[l], h[r]) * (r - l))

```

* **Explanation:**
* `min(h[l], h[r])`: Water level is constrained by the shorter of the two boundary lines.
* `r - l`: Width of the container (distance between pointers on the x-axis).
* `min(h[l], h[r]) * (r - l)`: Calculates the area of the current container.
* `max(m, ...)`: Updates `m` if the current area is greater than the previously recorded maximum.



---

##### 5. Pointer Movement Logic

```python
        if h[l] < h[r]: l += 1
        else: r -= 1

```

* **Explanation:**
* **Greedy Strategy:** To potentially find a larger area with a smaller width, we must move the pointer with the shorter height.
* If `h[l] < h[r]`, increment `l` (`l += 1`) to check a taller potential left line.
* Otherwise, decrement `r` (`r -= 1`) to check a taller potential right line.



---

##### 6. Returning the Final Result

```python
    return m

```

* **Explanation:**
* Returns `m`, which holds the maximum water capacity calculated across all valid pointer positions.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | The single loop moves `l` and `r` toward each other, traversing the list of size $N$ at most once. |
| **Space Complexity** | $O(1)$ | Uses a constant amount of extra memory for pointers and scalar variables. |
