//The approach uses bit manipulation where each integer from $0$ to $2^n - 1$ acts as a bitmask representing whether to include each element in the subset.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length, total = 1 << n;
        for (int i = 0; i < total; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            }
            res.add(sub);
        }
        return res;
    }
}