/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }


    public TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;
        if(node.val<=p.val && node.val>=q.val || node.val>=p.val && node.val<=q.val ){
            return node;
        }
        if(node.val>p.val && node.val>q.val)return lca(node.left, p, q);
        return lca(node.right, p, q);
    }
}