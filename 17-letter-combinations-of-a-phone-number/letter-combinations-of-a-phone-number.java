class Solution {
    String[] m = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> r = new ArrayList<>();

    public List<String> letterCombinations(String s) {
        if (s.length() == 0) return r;
        f(s, 0, new StringBuilder());
        return r;
    }

    void f(String s, int i, StringBuilder b) {
        if (i == s.length()) {
            r.add(b.toString());
            return;
        }

        String x = m[s.charAt(i) - '0'];

        for (int j = 0; j < x.length(); j++) {
            b.append(x.charAt(j));
            f(s, i + 1, b);
            b.deleteCharAt(b.length() - 1);
        }
    }
}
