class Solution {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);

        int b = a[0] + a[1] + a[2];

        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1, h = a.length - 1;

            while (l < h) {
                int x = a[i] + a[l] + a[h];

                if (Math.abs(x - t) < Math.abs(b - t))
                    b = x;

                if (x < t)
                    l++;
                else if (x > t)
                    h--;
                else
                    return x;
            }
        }

        return b;
    }
}
