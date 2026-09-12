class Solution {
    public List<List<Integer>> fourSum(int[] a, long t) {
        List<List<Integer>> r = new ArrayList<>();
        int n = a.length;
        Arrays.sort(a);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int l = j + 1, k = n - 1;

                while (l < k) {
                    long s = (long)a[i] + a[j] + a[l] + a[k];

                    if (s == t) {
                        r.add(Arrays.asList(a[i], a[j], a[l], a[k]));
                        while (l < k && a[l] == a[l + 1]) l++;
                        while (l < k && a[k] == a[k - 1]) k--;
                        l++;
                        k--;
                    } else if (s < t) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return r;
    }
}
