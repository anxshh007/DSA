//The approach traverses the array backwards, adding 1 and handling carries in-place, returning immediately if no further carry exists, or instantiating a new array with a leading 1 if all digits overflow.
class Solution {
    public int[] plusOne(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            if (d[i] < 9) {
                d[i]++;
                return d;
            }
            d[i] = 0;
        }
        int[] r = new int[d.length + 1];
        r[0] = 1;
        return r;
    }
}