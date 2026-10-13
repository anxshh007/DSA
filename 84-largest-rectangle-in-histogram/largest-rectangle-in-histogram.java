class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length, m = 0, p = 0;
        int[] s = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int v = (i == n) ? 0 : h[i];
            while (p > 0 && h[s[p - 1]] >= v) {
                int ht = h[s[--p]];
                int w = p == 0 ? i : i - s[p - 1] - 1;
                m = Math.max(m, ht * w);
            }
            s[p++] = i;
        }
        return m;
    }
}