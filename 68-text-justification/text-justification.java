class Solution {
    public List<String> fullJustify(String[] w, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = w.length;
        while (i < n) {
            int j = i + 1, l = w[i].length();
            while (j < n && l + 1 + w[j].length() <= maxWidth) {
                l += 1 + w[j].length();
                j++;
            }
            StringBuilder sb = new StringBuilder();
            int c = j - i, s = maxWidth - l + (c - 1);
            if (j == n || c == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(w[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                int q = s / (c - 1), r = s % (c - 1);
                for (int k = i; k < j; k++) {
                    sb.append(w[k]);
                    if (k < j - 1) {
                        for (int p = 0; p < q + (k - i < r ? 1 : 0); p++) sb.append(' ');
                    }
                }
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}