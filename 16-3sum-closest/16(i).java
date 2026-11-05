//anxshh
//This solution focuses on making the runtime faster by adding pruning and skipping unnecessary work.

class Solution {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);
        int n = a.length, b = a[0] + a[1] + a[2];

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            int x = a[i] + a[i + 1] + a[i + 2];
            if (x > t) {
                if (Math.abs(x - t) < Math.abs(b - t)) b = x;
                break;
            }

            x = a[i] + a[n - 2] + a[n - 1];
            if (x < t) {
                if (Math.abs(x - t) < Math.abs(b - t)) b = x;
                continue;
            }

            int l = i + 1, h = n - 1;

            while (l < h) {
                x = a[i] + a[l] + a[h];

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
