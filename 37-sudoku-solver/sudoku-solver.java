class Solution {
    int[] r = new int[9], c = new int[9], g = new int[9];

    public void solveSudoku(char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] != '.') {
                    int v = 1 << (b[i][j] - '1'), k = (i / 3) * 3 + j / 3;
                    r[i] |= v; c[j] |= v; g[k] |= v;
                }
            }
        }
        dfs(b, 0, 0);
    }

    private boolean dfs(char[][] b, int i, int j) {
        if (i == 9) return true;
        if (j == 9) return dfs(b, i + 1, 0);
        if (b[i][j] != '.') return dfs(b, i, j + 1);

        int k = (i / 3) * 3 + j / 3;
        for (int d = 0; d < 9; d++) {
            int v = 1 << d;
            if ((r[i] & v) == 0 && (c[j] & v) == 0 && (g[k] & v) == 0) {
                r[i] |= v; c[j] |= v; g[k] |= v;
                b[i][j] = (char) ('1' + d);
                if (dfs(b, i, j + 1)) return true;
                b[i][j] = '.';
                r[i] ^= v; c[j] ^= v; g[k] ^= v;
            }
        }
        return false;
    }
}