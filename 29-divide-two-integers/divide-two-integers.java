//anxshh
class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        int q = 0;

        while (x >= y) {
            long t = y;
            int p = 1;

            while (x >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }

            x -= t;
            q += p;
        }

        return (a < 0) ^ (b < 0) ? -q : q;
    }
}
