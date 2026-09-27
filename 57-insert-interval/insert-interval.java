class Solution {
    public int[][] insert(int[][] a, int[] n) {
        List<int[]> l = new ArrayList<>();
        int i = 0, len = a.length;
        while (i < len && a[i][1] < n[0]) l.add(a[i++]);
        while (i < len && a[i][0] <= n[1]) {
            n[0] = Math.min(n[0], a[i][0]);
            n[1] = Math.max(n[1], a[i][1]);
            i++;
        }
        l.add(n);
        while (i < len) l.add(a[i++]);
        return l.toArray(new int[l.size()][]);
    }
}