class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, m = -1, k = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++; j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                m = j++; k = i;
            } else if (m != -1) {
                j = m + 1; i = ++k;
            } else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') j++;
        return j == p.length();
    }
}