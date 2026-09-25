class Solution {
    public int maxSubArray(int[] a) {
        int m = a[0], c = a[0];
        for (int i = 1; i < a.length; i++) {
            c = Math.max(a[i], c + a[i]);
            m = Math.max(m, c);
        }
        return m;
    }
}