//anxshh 
// I have used a sliding-window approach with a frequency map which gives O(n) average time, for running the code. 
class Solution {
    public List<Integer> findSubstring(String s, String[] w) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() == 0 || w.length == 0) return ans;

        int len = w[0].length();
        int cnt = w.length;
        int total = len * cnt;

        if (s.length() < total) return ans;

        Map<String, Integer> need = new HashMap<>();

        for (String x : w) {
            need.put(x, need.getOrDefault(x, 0) + 1);
        }

        for (int st = 0; st < len; st++) {
            Map<String, Integer> have = new HashMap<>();
            int left = st, used = 0;

            for (int right = st; right + len <= s.length(); right += len) {
                String x = s.substring(right, right + len);

                if (!need.containsKey(x)) {
                    have.clear();
                    used = 0;
                    left = right + len;
                    continue;
                }

                have.put(x, have.getOrDefault(x, 0) + 1);
                used++;

                while (have.get(x) > need.get(x)) {
                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }

                if (used == cnt) {
                    ans.add(left);

                    String y = s.substring(left, left + len);
                    have.put(y, have.get(y) - 1);
                    left += len;
                    used--;
                }
            }
        }

        return ans;
    }
}
