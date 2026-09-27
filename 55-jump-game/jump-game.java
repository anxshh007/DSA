//anxshh
//This approach uses a greedy strategy, tracking the maximum reachable index at each step and returning false early if the current position becomes unreachable.
class Solution {
    public boolean canJump(int[] a) {
        int m = 0;
        for (int i = 0; i < a.length; i++) {
            if (i > m) return false;
            m = Math.max(m, i + a[i]);
        }
        return true;
    }
}