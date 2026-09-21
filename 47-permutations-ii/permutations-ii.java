class Solution {
    public List<List<Integer>> permuteUnique(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(n);
        bt(res, new ArrayList<>(), n, new boolean[n.length]);
        return res;
    }

    private void bt(List<List<Integer>> res, List<Integer> cur, int[] n, boolean[] u) {
        if (cur.size() == n.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (u[i] || (i > 0 && n[i] == n[i - 1] && !u[i - 1])) continue;
            u[i] = true;
            cur.add(n[i]);
            bt(res, cur, n, u);
            u[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}