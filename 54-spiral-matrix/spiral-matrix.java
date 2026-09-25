class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> ans = new ArrayList<>();
        int t = 0, b = m.length - 1, l = 0, r = m[0].length - 1;
        while (t <= b && l <= r) {
            for (int j = l; j <= r; j++) ans.add(m[t][j]);
            t++;
            for (int i = t; i <= b; i++) ans.add(m[i][r]);
            r--;
            if (t <= b) {
                for (int j = r; j >= l; j--) ans.add(m[b][j]);
                b--;
            }
            if (l <= r) {
                for (int i = b; i >= t; i--) ans.add(m[i][l]);
                l++;
            }
        }
        return ans;
    }
}