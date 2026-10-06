//The approach calculates the number of ways to climb $n$ stairs by treating it as a Fibonacci sequence, updating two variables iteratively in $O(n)$ time and $O(1)$ space.

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            int t = a + b;
            a = b;
            b = t;
        }
        return a;
    }
}