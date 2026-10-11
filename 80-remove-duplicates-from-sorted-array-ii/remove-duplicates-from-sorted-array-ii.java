//The approach uses a two-pointer technique to allow each element to appear at most twice by comparing the current element with the element two positions behind the write pointer.

class Solution {
    public int removeDuplicates(int[] n) {
        int i = 0;
        for (int x : n) {
            if (i < 2 || x > n[i - 2]) {
                n[i++] = x;
            }
        }
        return i;
    }
}