class Solution {
    public boolean isValidSudoku(char[][] b) {
        int[] r = new int[9], c = new int[9], g = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] == '.') continue;
                int v = 1 << (b[i][j] - '1'), k = (i / 3) * 3 + j / 3;
                if ((r[i] & v) != 0 || (c[j] & v) != 0 || (g[k] & v) != 0) return false;
                r[i] |= v; c[j] |= v; g[k] |= v;
            }
        }
        return true;
    }
}