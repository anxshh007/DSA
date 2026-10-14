class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int a = 1, b = 1;
        for (int i = 1; i < s.length(); i++) {
            int c = 0;
            int d = s.charAt(i) - '0';
            int e = (s.charAt(i - 1) - '0') * 10 + d;
            if (d >= 1 && d <= 9) c += b;
            if (e >= 10 && e <= 26) c += a;
            a = b;
            b = c;
        }
        return b;
    }
}