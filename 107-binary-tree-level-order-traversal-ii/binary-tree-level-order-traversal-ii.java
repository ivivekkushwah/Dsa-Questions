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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Stack<List<Integer>> s = new Stack<>();
        if (root == null) return al;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while (size-- > 0) {
                TreeNode temp = q.poll();

                level.add(temp.val);

                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }

            s.push(level);
        }
        while(!s.isEmpty()){
            al.add(s.pop());
        }

        return al;
    }
}