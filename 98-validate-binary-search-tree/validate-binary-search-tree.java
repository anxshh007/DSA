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
    TreeNode p;

    public boolean isValidBST(TreeNode r) {
        if (r == null) return true;
        if (!isValidBST(r.left)) return false;
        if (p != null && r.val <= p.val) return false;
        p = r;
        return isValidBST(r.right);
    }
}