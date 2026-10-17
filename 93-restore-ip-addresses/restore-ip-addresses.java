//the approach used is backtracking aur zero-allocation character array se sare valid IP segments depth-first tree traversal se extract hote hain. 

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        dfs(s, 0, 0, new char[s.length() + 3], res);
        return res;
    }

    private void dfs(String s, int i, int p, char[] path, List<String> res) {
        int n = s.length();
        if (p == 4) {
            if (i == n) res.add(new String(path));
            return;
        }
        for (int len = 1; len <= 3 && i + len <= n; len++) {
            if (len > 1 && s.charAt(i) == '0') break;
            int val = 0;
            for (int k = i; k < i + len; k++) val = val * 10 + (s.charAt(k) - '0');
            if (val > 255) break;
            for (int k = 0; k < len; k++) path[i + p + k] = s.charAt(i + k);
            if (p < 3) path[i + p + len] = '.';
            dfs(s, i + len, p + 1, path, res);
        }
    }
}