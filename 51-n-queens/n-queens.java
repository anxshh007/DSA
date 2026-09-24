//anxshh
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] b = new char[n][n];
        for (char[] r : b) Arrays.fill(r, '.');
        dfs(0, n, 0, 0, 0, b, res);
        return res;
    }

    private void dfs(int r, int n, int c, int d1, int d2, char[][] b, List<List<String>> res) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : b) list.add(new String(row));
            res.add(list);
            return;
        }
        int p = ((1 << n) - 1) & ~(c | d1 | d2);
        while (p != 0) {
            int bit = p & -p;
            p &= p - 1;
            int col = Integer.numberOfTrailingZeros(bit);
            b[r][col] = 'Q';
            dfs(r + 1, n, c | bit, (d1 | bit) << 1, (d2 | bit) >>> 1, b, res);
            b[r][col] = '.';
        }
    }
}