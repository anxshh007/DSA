# Two Sum — Solution Breakdown & Code Walkthrough

## Overview

The goal of this algorithm is to find two numbers in an array (`nums`) that add up to a given `target` value, returning their zero-based indices. It utilizes a **hash map** (`std::unordered_map`) to achieve an optimal **$O(N)$ time complexity**.

---

## Complete Solution Code

```cpp
//anxshh
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> num_map;

        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];

            if (num_map.count(complement)) {
                return {num_map[complement], i};
            }
            num_map[nums[i]] = i;
        }
        return {};
    }
};

```

---

## Line-by-Line Code Analysis

### 1. Header and Class Definition

```cpp
//anxshh
class Solution {
public:

```

* **Explanation:** Defines the standard class wrapper `Solution` with `public` access so the testing framework can call the method.

---

### 2. Method Signature

```cpp
    vector<int> twoSum(vector<int>& nums, int target) {

```

* **Explanation:**
* **`vector<int>`**: Specifies that the function returns a vector containing two integers (the matching indices).
* **`nums`**: A reference (`&`) to the input vector of integers to avoid unnecessary copying.
* **`target`**: The target sum we are trying to achieve.



---

### 3. Hash Map Declaration

```cpp
        unordered_map<int, int> num_map;

```

* **Explanation:** Instantiates a hash map named `num_map`.
* **Key (`int`)**: Stores the number's value from `nums`.
* **Value (`int`)**: Stores the array index where that number was found.



---

### 4. Main Iteration Loop

```cpp
        for (int i = 0; i < nums.size(); ++i) {

```

* **Explanation:** A standard `for` loop that iterates through every element in the `nums` vector from index `0` up to `nums.size() - 1`. `i` acts as the current index.

---

### 5. Complement Calculation

```cpp
            int complement = target - nums[i];

```

* **Explanation:** Calculates the required value needed to reach `target`.
* Math: $\text{complement} + \text{nums}[i] = \text{target} \implies \text{complement} = \text{target} - \text{nums}[i]$.



---

### 6. Lookup Check

```cpp
            if (num_map.count(complement)) {

```

* **Explanation:** Checks if the required `complement` already exists in `num_map`.
* `num_map.count(key)` returns `1` if the key exists, or `0` if it doesn't.
* If found, it means we previously encountered the matching number.



---

### 7. Returning Result

```cpp
                return {num_map[complement], i};
            }

```

* **Explanation:** If the complement is found, returns an initializer list `{num_map[complement], i}` containing:
1. `num_map[complement]`: The index of the previously seen matching number.
2. `i`: The index of the current element.



---

### 8. Map Insertion

```cpp
            num_map[nums[i]] = i;
        }

```

* **Explanation:** If the complement was **not** found, insert the current number (`nums[i]`) and its index (`i`) into `num_map` so future numbers can check against it.

---

### 9. Fallback Return

```cpp
        return {};
    }
};

```

* **Explanation:** Returns an empty vector `{}` if no two numbers in the array sum up to `target`.

---

## Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N)$ | Iterates through the array of size $N$ once. Hash map lookups and insertions take $O(1)$ average time. |
| **Space Complexity** | $O(N)$ | In the worst case, stores up to $N$ elements in the hash map. |
