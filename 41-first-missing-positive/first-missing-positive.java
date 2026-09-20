class Solution {
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            while (a[i] > 0 && a[i] <= n && a[a[i] - 1] != a[i]) {
                int t = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}