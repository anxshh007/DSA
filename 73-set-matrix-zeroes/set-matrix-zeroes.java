//The approach uses the first row and first column of the matrix itself as markers to track zeros in $O(1)$ extra space, with a single boolean flag for the first column's initial state.
class Solution {
    public void setZeroes(int[][] m) {
        int R = m.length, C = m[0].length;
        boolean c0 = false;
        for (int i = 0; i < R; i++) {
            if (m[i][0] == 0) c0 = true;
            for (int j = 1; j < C; j++)
                if (m[i][j] == 0) m[i][0] = m[0][j] = 0;
        }
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 1; j--)
                if (m[i][0] == 0 || m[0][j] == 0) m[i][j] = 0;
            if (c0) m[i][0] = 0;
        }
    }
}