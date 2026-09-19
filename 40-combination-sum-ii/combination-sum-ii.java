class Solution {
    public List<List<Integer>> combinationSum2(int[] a, int t) {
        List<List<Integer>> r = new ArrayList<>();
        Arrays.sort(a);
        f(a, t, 0, new ArrayList<>(), r);
        return r;
    }

    private void f(int[] a, int t, int s, List<Integer> c, List<List<Integer>> r) {
        if (t == 0) { r.add(new ArrayList<>(c)); return; }
        for (int i = s; i < a.length; i++) {
            if (i > s && a[i] == a[i - 1]) continue;
            if (a[i] > t) break;
            c.add(a[i]);
            f(a, t - a[i], i + 1, c, r);
            c.remove(c.size() - 1);
        }
    }
}