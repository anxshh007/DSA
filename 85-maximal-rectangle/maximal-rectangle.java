class Solution {
    public int maximalRectangle(char[][] m) {
        if (m.length == 0) return 0;
        int r = m.length, c = m[0].length, mx = 0;
        int[] h = new int[c], l = new int[c], t = new int[c];
        java.util.Arrays.fill(t, c);
        for (int i = 0; i < r; i++) {
            int cl = 0, cr = c;
            for (int j = 0; j < c; j++) h[j] = m[i][j] == '1' ? h[j] + 1 : 0;
            for (int j = 0; j < c; j++) {
                if (m[i][j] == '1') l[j] = Math.max(l[j], cl);
                else { l[j] = 0; cl = j + 1; }
            }
            for (int j = c - 1; j >= 0; j--) {
                if (m[i][j] == '1') t[j] = Math.min(t[j], cr);
                else { t[j] = c; cr = j; }
            }
            for (int j = 0; j < c; j++) mx = Math.max(mx, (t[j] - l[j]) * h[j]);
        }
        return mx;
    }
}