class Solution {
    public String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            StringBuilder t = new StringBuilder();
            for (int i = 0, c = 1; i < s.length(); i++, c++) {
                if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    t.append(c).append(s.charAt(i));
                    c = 0;
                }
            }
            s = t.toString();
        }
        return s;
    }
}