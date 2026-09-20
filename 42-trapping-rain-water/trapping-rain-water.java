//anxshh
//The approach uses two pointers moving inward from both ends, tracking the maximum heights seen so far to accumulate trapped water in O(N) time and O(1) space.
class Solution {
    public int trap(int[] h) {
        int l = 0, r = h.length - 1, lm = 0, rm = 0, w = 0;
        while (l < r) {
            if (h[l] < h[r]) {
                if (h[l] >= lm) lm = h[l];
                else w += lm - h[l];
                l++;
            } else {
                if (h[r] >= rm) rm = h[r];
                else w += rm - h[r];
                r--;
            }
        }
        return w;
    }
}