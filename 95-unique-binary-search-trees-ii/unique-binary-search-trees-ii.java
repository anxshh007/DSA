/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode>[][] m;

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        m = new List[n + 2][n + 2];
        return g(1, n);
    }

    private List<TreeNode> g(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        if (m[s][e] != null) return m[s][e];

        for (int i = s; i <= e; i++) {
            List<TreeNode> l = g(s, i - 1);
            List<TreeNode> r = g(i + 1, e);

            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return m[s][e] = res;
    }
}