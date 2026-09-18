class Solution {
    public int searchInsert(int[] a, int t) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == t) return m;
            if (a[m] < t) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}