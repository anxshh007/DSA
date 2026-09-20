//anxshh
//The approach uses a greedy strategy to track the furthest reachable index within the current jump's range, incrementing the jump count whenever reaching the end of that range.

class Solution {
    public int jump(int[] a) {
        int j = 0, c = 0, f = 0;
        for (int i = 0; i < a.length - 1; i++) {
            f = Math.max(f, i + a[i]);
            if (i == c) {
                j++;
                c = f;
            }
        }
        return j;
    }
}