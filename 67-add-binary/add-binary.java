//The approach uses a two-pointer loop starting from the end of both strings to sum corresponding binary digits and carry, appending the result bit-by-bit to a StringBuilder in $O(N)$ time.
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c == 1) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            sb.append(c % 2);
            c /= 2;
        }
        return sb.reverse().toString();
    }
}