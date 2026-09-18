class Solution {
    public List<List<Integer>> combinationSum(int[] c, int t) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(c);
        f(c, t, 0, new ArrayList<>(), res);
        return res;
    }

    private void f(int[] c, int t, int s, List<Integer> cur, List<List<Integer>> res) {
        if (t == 0) { res.add(new ArrayList<>(cur)); return; }
        for (int i = s; i < c.length && c[i] <= t; i++) {
            cur.add(c[i]);
            f(c, t - c[i], i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}