//anxshh
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        long r = 0;
        int sg = 1;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sg = -1;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            r = r * 10 + (s.charAt(i) - '0');

            if (sg == 1 && r > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sg == -1 && -r < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int) (r * sg);
    }
}
