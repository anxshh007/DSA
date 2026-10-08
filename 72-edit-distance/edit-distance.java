class Solution {
    public int minDistance(String a, String b) {
        if (a.length() < b.length()) return minDistance(b, a);
        int m = a.length(), n = b.length();
        int[] d = new int[n + 1];
        for (int j = 0; j <= n; j++) d[j] = j;
        for (int i = 1; i <= m; i++) {
            int p = d[0];
            d[0] = i;
            for (int j = 1; j <= n; j++) {
                int t = d[j];
                if (a.charAt(i - 1) == b.charAt(j - 1)) d[j] = p;
                else d[j] = 1 + Math.min(p, Math.min(d[j], d[j - 1]));
                p = t;
            }
        }
        return d[n];
    }
}