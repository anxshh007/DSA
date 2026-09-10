class Solution {
    public int romanToInt(String s) {
        int[] v = new int[91];
        v['I'] = 1;
        v['V'] = 5;
        v['X'] = 10;
        v['L'] = 50;
        v['C'] = 100;
        v['D'] = 500;
        v['M'] = 1000;

        int r = 0;
        int p = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int a = v[s.charAt(i)];

            if (a < p)
                r -= a;
            else {
                r += a;
                p = a;
            }
        }

        return r;
    }
}
