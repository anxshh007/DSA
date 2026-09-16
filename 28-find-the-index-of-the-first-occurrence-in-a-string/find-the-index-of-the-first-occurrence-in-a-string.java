class Solution {
    public int strStr(String s, String p) {
        if (p.length() == 0) return 0;

        int[] lps = new int[p.length()];

        // Build LPS array
        for (int i = 1, len = 0; i < p.length();) {
            if (p.charAt(i) == p.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        // KMP search
        for (int i = 0, j = 0; i < s.length();) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;

                if (j == p.length()) {
                    return i - j;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }
}
