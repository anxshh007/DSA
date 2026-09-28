//anxshh
//The approach uses factorials to determine each digit of the permutation position-by-position, building the sequence directly in $O(n^2)$ time without generating lower permutations.
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> v = new ArrayList<>();
        int f = 1;
        for (int i = 1; i <= n; i++) {
            v.add(i);
            f *= i;
        }
        k--;
        StringBuilder s = new StringBuilder();
        for (int i = n; i > 0; i--) {
            f /= i;
            int idx = k / f;
            s.append(v.remove(idx));
            k %= f;
        }
        return s.toString();
    }
}