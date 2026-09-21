//anxshh
//The approach that i have used to solve the problem, uses backtracking with in-place array swapping to explore all permutations without needing extra boolean memory for tracking visited elements.
class Solution {
    public List<List<Integer>> permute(int[] n) {
        List<List<Integer>> r = new ArrayList<>();
        b(n, 0, r);
        return r;
    }

    private void b(int[] a, int i, List<List<Integer>> r) {
        if (i == a.length) {
            List<Integer> l = new ArrayList<>(a.length);
            for (int x : a) l.add(x);
            r.add(l);
            return;
        }
        for (int j = i; j < a.length; j++) {
            s(a, i, j);
            b(a, i + 1, r);
            s(a, i, j);
        }
    }

    private void s(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}