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

//In-order traversal of a Binary Search Tree produces a strictly increasing sequence, so we use Morris Traversal (an $O(1)$ auxiliary space in-order traversal) to locate the two swapped nodes where the sorted order is broken, then swap their values back.

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, p = null, c = root, t = null;
        while (c != null) {
            if (c.left != null) {
                t = c.left;
                while (t.right != null && t.right != c) t = t.right;
                if (t.right == null) {
                    t.right = c;
                    c = c.left;
                } else {
                    t.right = null;
                    if (p != null && p.val > c.val) {
                        if (x == null) x = p;
                        y = c;
                    }
                    p = c;
                    c = c.right;
                }
            } else {
                if (p != null && p.val > c.val) {
                    if (x == null) x = p;
                    y = c;
                }
                p = c;
                c = c.right;
            }
        }
        int v = x.val;
        x.val = y.val;
        y.val = v;
    }
}