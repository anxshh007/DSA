//You are correct—that specific single-line swap trick fails in Java because operand evaluation order evaluates a on the left before updating a = b on the right, which breaks the Fibonacci progression.
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