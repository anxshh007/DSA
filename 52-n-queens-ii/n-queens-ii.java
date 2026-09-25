//anxshh
class Solution {
    int c = 0;
    public int totalNQueens(int n) {
        solve(0, 0, 0, 0, (1 << n) - 1);
        return c;
    }
    private void solve(int r, int cols, int d1, int d2, int mask) {
        if (cols == mask) { c++; return; }
        int pos = mask & ~(cols | d1 | d2);
        while (pos != 0) {
            int p = pos & -pos;
            pos -= p;
            solve(r + 1, cols | p, (d1 | p) << 1, (d2 | p) >> 1, mask);
        }
    }
}