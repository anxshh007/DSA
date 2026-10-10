//The approach uses depth-first search (DFS) with backtracking, temporarily modifying board cells in place to mark them as visited without extra space.

class Solution {
    public boolean exist(char[][] b, String w) {
        int m = b.length, n = b[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(b, w, i, j, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] b, String w, int r, int c, int k) {
        if (k == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != w.charAt(k)) return false;
        char t = b[r][c];
        b[r][c] = '#';
        boolean res = dfs(b, w, r + 1, c, k + 1) || dfs(b, w, r - 1, c, k + 1) ||
                      dfs(b, w, r, c + 1, k + 1) || dfs(b, w, r, c - 1, k + 1);
        b[r][c] = t;
        return res;
    }
}