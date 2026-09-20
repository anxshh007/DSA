//anxshh
//The approach places each positive integer x into its corresponding index x - 1 using cyclic swaps, then scans to find the first index where the value does not match.
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