//The approach Uses 1D dynamic programming where dp[j] tracks whether s3[0...i+j-1] can be formed by interleaving s1[0...i-1] and s2[0...j-1].

class Solution {
    public boolean isInterleave(String a, String b, String c) {
        int m = a.length(), n = b.length();
        if (m + n != c.length()) return false;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++)
            dp[j] = dp[j - 1] && b.charAt(j - 1) == c.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            dp[0] = dp[0] && a.charAt(i - 1) == c.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j] && a.charAt(i - 1) == c.charAt(i + j - 1)) ||
                        (dp[j - 1] && b.charAt(j - 1) == c.charAt(i + j - 1));
            }
        }
        return dp[n];
    }
}