class Solution {
    public int romanToInt(String s) {
        int r = 0;

        for (int i = 0; i < s.length(); i++) {
            int a = v(s.charAt(i));

            if (i < s.length() - 1 && a < v(s.charAt(i + 1)))
                r -= a;
            else
                r += a;
        }

        return r;
    }

    int v(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
