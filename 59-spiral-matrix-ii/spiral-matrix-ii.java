//anxshh
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int t = 0, b = n - 1, l = 0, r = n - 1, v = 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) m[t][i] = v++;
            t++;
            for (int i = t; i <= b; i++) m[i][r] = v++;
            r--;
            for (int i = r; i >= l; i--) m[b][i] = v++;
            b--;
            for (int i = b; i >= t; i--) m[i][l] = v++;
            l++;
        }
        return m;
    }
}