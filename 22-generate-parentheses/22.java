class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        f(r, "", 0, 0, n);
        return r;
    }

    void f(List<String> r, String s, int o, int c, int n) {
        if (s.length() == 2 * n) {
            r.add(s);
            return;
        }

        if (o < n)
            f(r, s + "(", o + 1, c, n);

        if (c < o)
            f(r, s + ")", o, c + 1, n);
    }
}
