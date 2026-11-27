### Substring with Concatenation of All Words — Solution Breakdown & Code Walkthrough and Analysis

#### Overview

The goal of this algorithm is to find all starting indices of substring(s) in string `s` that is a concatenation of each word in a given array of words `w` exactly once, without any intervening characters.

This solution uses an optimized **Sliding Window** technique combined with **Hash Maps** for word frequency matching. Instead of checking every single index character-by-character, it partitions the string into `len` independent sliding window sequences based on the remainder modulo word length (`len`), achieving high efficiency.

---

#### Complete Solution Code

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] w) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || w.length == 0) return ans;

        int len = w[0].length();
        int cnt = w.length;
        int total = len * cnt;

        if (s.length() < total) return ans;

        Map<String, Integer> need = new HashMap<>();

        for (String x : w) {
            need.put(x, need.getOrDefault(x, 0) + 1);
        }

        for (int st = 0; st < len; st++) {
            Map<String, Integer> have = new HashMap<>();
            int left = st, used = 0;

            for (int right = st; right + len <= s.length(); right += len) {
                String x = s.substring(right, right + len);

                if (!need.containsKey(x)) {
                    have.clear();
                    used = 0;
                    left = right + len;
                    continue;
                }

                have.put(x, have.getOrDefault(x, 0) + 1);
                used++;

                while (have.get(x) > need.get(x)) {
                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }

                if (used == cnt) {
                    ans.add(left);

                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }
            }
        }

        return ans;
    }
}

```

---

#### Line-by-Line Code Analysis

##### 1. Method Signature and Edge Case Validation

```java
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || w.length == 0) return ans;

        int len = w[0].length();
        int cnt = w.length;
        int total = len * cnt;

        if (s.length() < total) return ans;

```

* **Explanation:**
* Initializes an empty list `ans` to store the resulting starting indices.
* Checks edge cases: if either string `s` or the words array `w` is empty, returns an empty list.
* Calculates `len` (length of each word), `cnt` (total number of words), and `total` (the exact length of a valid concatenated substring).
* If the total string length `s` is shorter than `total`, it's impossible to form a valid substring, so it returns `ans`.



---

##### 2. Building the Frequency Map (`need`)

```java
        Map<String, Integer> need = new HashMap<>();

        for (String x : w) {
            need.put(x, need.getOrDefault(x, 0) + 1);
        }

```

* **Explanation:**
* Creates a frequency map `need` to store how many times each word appears in the input array `w`.



---

##### 3. Outer Loop — Sliding Window Offsets

```java
        for (int st = 0; st < len; st++) {
            Map<String, Integer> have = new HashMap<>();
            int left = st, used = 0;

```

* **Explanation:**
* Since words have a fixed length `len`, we need to evaluate windows starting at different offsets (`st` from `0` to `len - 1`). This ensures all possible word alignments in `s` are covered.
* Initializes a local frequency map `have` for the current offset, along with pointers `left` and `used` (tracking how many valid words are currently in the window).



---

##### 4. Inner Loop — Expanding the Window

```java
            for (int right = st; right + len <= s.length(); right += len) {
                String x = s.substring(right, right + len);

                if (!need.containsKey(x)) {
                    have.clear();
                    used = 0;
                    left = right + len;
                    continue;
                }

```

* **Explanation:**
* Iterates `right` pointer forward in jumps of `len` characters to extract word-sized substrings `x`.
* If the extracted word `x` is not present in the `need` map, the current window is invalid. It clears the `have` map, resets `used` count to `0`, moves `left` past the invalid word, and skips to the next iteration.



---

##### 5. Tracking and Shrinking the Window

```java
                have.put(x, have.getOrDefault(x, 0) + 1);
                used++;

                while (have.get(x) > need.get(x)) {
                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }

```

* **Explanation:**
* Adds valid word `x` into the `have` map and increments `used`.
* If the frequency of word `x` exceeds what is required in `need`, the `while` loop shrinks the window from the left (`left` pointer advances by `len`), removing words `y` from `have` and decrementing `used` until the frequency constraint is satisfied.



---

##### 6. Recording Valid Substring Match

```java
                if (used == cnt) {
                    ans.add(left);

                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }
            }
        }

        return ans;
    }
}

```

* **Explanation:**
* If `used` equals `cnt`, a complete valid concatenation of all words has been found starting at index `left`. This index is added to `ans`.
* To continue searching for more valid windows, it shifts the `left` boundary forward by one word (`len`), adjusts the `have` map, and decrements `used`.
* Once all offsets are evaluated, the complete result list `ans` is returned.



---

#### Complexity Analysis

| Type | Complexity | Explanation |
| --- | --- | --- |
| **Time Complexity** | $O(N \cdot L)$ | Where $N$ is the length of string `s` and $L$ is the length of each word. Each character is processed a constant number of times across the `len` offset passes. |
| **Space Complexity** | $O(M \cdot L)$ | Where $M$ is the number of words in array `w` and $L$ is word length, required to store the frequency hash maps (`need` and `have`). |
