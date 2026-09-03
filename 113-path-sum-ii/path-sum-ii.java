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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        path(root, targetSum, 0, al, l);

        return al;
    }

    public void path(TreeNode root, int targetSum, int sum,
                     List<List<Integer>> al, List<Integer> l) {

        if (root == null) return;

        sum += root.val;
        l.add(root.val);

        if (root.left == null && root.right == null) {

            if (sum == targetSum) {
                al.add(new ArrayList<>(l));  // copy
            }

        } else {
            path(root.left, targetSum, sum, al, l);
            path(root.right, targetSum, sum, al, l);
        }

        l.remove(l.size() - 1);  // backtrack
    }
}