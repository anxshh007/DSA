# LeetCode 59: Spiral Matrix II

An optimized, memory-efficient Java solution for generating an $n \times n$ spiral matrix filled with elements from $1$ to $n^2$ in spiral order.

---

## Problem Statement

Given a positive integer $n$, generate an $n \times n$ matrix filled with elements from $1$ to $n^2$ in spiral order.

### Example

**Input:** `n = 3`  
**Output:**
```text
[[1, 2, 3],
 [8, 9, 4],
 [7, 6, 5]]
```

---

## Approach

The algorithm fills the matrix layer by layer from the outer perimeter towards the center. Four boundary pointers are maintained and adjusted inward after each edge traversal:

1. **Top Row**: Traverse from `left` to `right`, then increment `top`.
2. **Right Column**: Traverse from `top` to `bottom`, then decrement `right`.
3. **Bottom Row**: Traverse from `right` to `left`, then decrement `bottom`.
4. **Left Column**: Traverse from `bottom` to `top`, then increment `left`.

This process repeats inside a single `while` loop until all numbers from $1$ to $n^2$ are placed.

---

## Java Solution

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1, v = 1;
        
        while (t <= b && l <= r) {
            // Traverse Left -> Right
            for (int i = l; i <= r; i++) m[t][i] = v++;
            t++;
            
            // Traverse Top -> Bottom
            for (int i = t; i <= b; i++) m[i][r] = v++;
            r--;
            
            // Traverse Right -> Left
            for (int i = r; i >= l; i--) m[b][i] = v++;
            b--;
            
            // Traverse Bottom -> Top
            for (int i = b; i >= t; i--) m[i][l] = v++;
            l++;
        }
        
        return m;
    }
}
```

---

## Line-by-Line Code Breakdown

| Code Line | Description |
| :--- | :--- |
| `int[][] m = new int[n][n];` | Allocates the output matrix `m` of size $n \times n$. |
| `int t = 0, b = n - 1, l = 0, r = n - 1, v = 1;` | Initializes four boundary pointers: **t**op (`0`), **b**ottom (`n-1`), **l**eft (`0`), **r**ight (`n-1`), and value counter **v** (`1`). |
| `while (t <= b && l <= r)` | Loops until boundaries collapse into the center. |
| `for (int i = l; i <= r; i++) m[t][i] = v++;` | Fills the top row from left to right with current values. |
| `t++;` | Moves the top boundary down by one row. |
| `for (int i = t; i <= b; i++) m[i][r] = v++;` | Fills the right column from top to bottom. |
| `r--;` | Moves the right boundary left by one column. |
| `for (int i = r; i >= l; i--) m[b][i] = v++;` | Fills the bottom row from right to left. |
| `b--;` | Moves the bottom boundary up by one row. |
| `for (int i = b; i >= t; i--) m[i][l] = v++;` | Fills the left column from bottom to top. |
| `l++;` | Moves the left boundary right by one column. |
| `return m;` | Returns the fully populated spiral matrix. |

---

## Complexity Analysis

- **Time Complexity**: $\mathcal{O}(n^2)$ — Every cell in the $n \times n$ matrix is visited and populated exactly once.
- **Space Complexity**: $\mathcal{O}(1)$ — Auxiliary space complexity is $O(1)$ excluding the space required for the output matrix `m`.