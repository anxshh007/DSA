class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] c = new char[26];
            for (char x : s.toCharArray()) c[x - 'a']++;
            String k = new String(c);
            m.putIfAbsent(k, new ArrayList<>());
            m.get(k).add(s);
        }
        return new ArrayList<>(m.values());
    }
}