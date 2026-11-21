class Solution {
    public int[] searchRange(int[] a, int t) {
        int l = 0, r = a.length - 1, x = -1, y = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] >= t) r = m - 1;
            else l = m + 1;
        }
        if (l < a.length && a[l] == t) x = l;

        l = 0;
        r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] <= t) l = m + 1;
            else r = m - 1;
        }
        if (r >= 0 && a[r] == t) y = r;

        return new int[]{x, y};
    }
}
