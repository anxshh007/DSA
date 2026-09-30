class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length, n = g[0].length, d[] = new int[n];
        d[0] = g[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) d[j] = 0;
                else if (j > 0) d[j] += d[j - 1];
            }
        }
        return d[n - 1];
    }
}