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
    public int maxDepth(TreeNode root) {
        return md(root, 0, 0);
    }
    public int md(TreeNode node, int maxDepth, int depth){
        if(node==null){
            return depth;
        }
        depth++;
        int leftDepth = md(node.left, maxDepth, depth);
        int rightDepth = md(node.right , maxDepth, depth);
        maxDepth = Math.max(Math.max(leftDepth, rightDepth), maxDepth);
        return maxDepth;
    }
}