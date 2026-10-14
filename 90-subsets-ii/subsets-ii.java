//Approach: The approach uses sorting followed by backtracking to generate all unique subsets by recursively including elements and skipping adjacent duplicates at the same recursion level.

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> r = new ArrayList<>();
        f(0, a, new ArrayList<>(), r);
        return r;
    }

    void f(int i, int[] a, List<Integer> t, List<List<Integer>> r) {
        r.add(new ArrayList<>(t));
        for (int j = i; j < a.length; j++) {
            if (j > i && a[j] == a[j - 1]) continue;
            t.add(a[j]);
            f(j + 1, a, t, r);
            t.remove(t.size() - 1);
        }
    }
}