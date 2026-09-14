class Solution {
    public int removeDuplicates(int[] a) {
        if (a.length == 0)
            return 0;

        int j = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j - 1])
                a[j++] = a[i];
        }

        return j;
    }
}
