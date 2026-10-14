//The approach uses memoized recursion to recursively check if string partitioning splits match directly or in swapped order.

class Solution {
    Boolean[][][] m;
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        m = new Boolean[n][n][n + 1];
        return f(s1, s2, 0, 0, n);
    }
    boolean f(String s1, String s2, int i, int j, int l) {
        if (m[i][j][l] != null) return m[i][j][l];
        if (s1.substring(i, i + l).equals(s2.substring(j, j + l))) return m[i][j][l] = true;
        int[] c = new int[26];
        for (int k = 0; k < l; k++) {
            c[s1.charAt(i + k) - 'a']++;
            c[s2.charAt(j + k) - 'a']--;
        }
        for (int x : c) if (x != 0) return m[i][j][l] = false;
        for (int k = 1; k < l; k++) {
            if ((f(s1, s2, i, j, k) && f(s1, s2, i + k, j + k, l - k)) ||
                (f(s1, s2, i, j + l - k, k) && f(s1, s2, i + k, j, l - k)))
                return m[i][j][l] = true;
        }
        return m[i][j][l] = false;
    }
}