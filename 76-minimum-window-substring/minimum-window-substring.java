//The approach uses a sliding window with a frequency array to dynamically expand the right pointer until all required characters are covered, then shrinks from the left to find the minimum valid substring.

class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[128];
        for (char c : t.toCharArray()) m[c]++;
        int l = 0, r = 0, c = t.length(), min = Integer.MAX_VALUE, head = 0;
        while (r < s.length()) {
            if (m[s.charAt(r++)]-- > 0) c--;
            while (c == 0) {
                if (r - l < min) min = r - (head = l);
                if (m[s.charAt(l++)]++ == 0) c++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}