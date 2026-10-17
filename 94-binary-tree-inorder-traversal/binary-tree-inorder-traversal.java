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
    public List<Integer> inorderTraversal(TreeNode r) {
        List<Integer> l = new ArrayList<>();
        TreeNode c = r;
        while (c != null) {
            if (c.left == null) {
                l.add(c.val);
                c = c.right;
            } else {
                TreeNode p = c.left;
                while (p.right != null && p.right != c) p = p.right;
                if (p.right == null) {
                    p.right = c;
                    c = c.left;
                } else {
                    p.right = null;
                    l.add(c.val);
                    c = c.right;
                }
            }
        }
        return l;
    }
}