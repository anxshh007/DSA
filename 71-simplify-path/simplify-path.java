class Solution {
    public String simplifyPath(String p) {
        String[] s = p.split("/"), st = new String[s.length];
        int top = 0;
        for (String c : s) {
            if (c.equals("") || c.equals(".")) continue;
            if (c.equals("..")) {
                if (top > 0) top--;
            } else {
                st[top++] = c;
            }
        }
        if (top == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) sb.append("/").append(st[i]);
        return sb.toString();
    }
}