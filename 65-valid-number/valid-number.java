class Solution {
    public boolean isNumber(String s) {
        boolean d = false, p = false, e = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') d = true;
            else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else if (c == 'e' || c == 'E') {
                if (e || !d) return false;
                e = true;
                d = false;
            } else if (c == '.') {
                if (p || e) return false;
                p = true;
            } else return false;
        }
        return d;
    }
}