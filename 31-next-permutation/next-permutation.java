//anxshh
//to start of with, we are finding the pivot, and then the successsor and then swapping the elements, and then reversing the index. 
class Solution {
    public void nextPermutation(int[] a) {
        int n = a.length, i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) j--;
            s(a, i, j);
        }
        r(a, i + 1, n - 1);
    }

    private void s(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private void r(int[] a, int l, int r) {
        while (l < r) s(a, l++, r--);
    }
}