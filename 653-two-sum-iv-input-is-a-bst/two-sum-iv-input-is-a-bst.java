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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)return false;
        Stack<TreeNode> asc = new Stack<>();
        Stack<TreeNode> dsc = new Stack<>();
        boolean ans = false;
        TreeNode l = root;
        while (l != null) {
            asc.push(l);
            l = l.left;
        }
        TreeNode r = root;
        while (r != null) {
            dsc.push(r);
            r = r.right;
        }
        TreeNode i = getMin(asc);
        TreeNode j = getMax(dsc);
        while (i != null && j != null && i != j) {
            int sum = i.val + j.val;
            if (sum == k)
                ans = true;
            if (sum < k) {
                i = getMin(asc);
            } else {
                j = getMax(dsc);
            }
        }
        return ans;
    }

    public TreeNode getMin(Stack<TreeNode> s) {
        if (s.isEmpty()) {
            return null;
        }

        TreeNode min = s.pop();
        TreeNode rightNode = min.right;
        while (rightNode != null) {
            s.push(rightNode);
            rightNode = rightNode.left;
        }
        return min;
    }

    public TreeNode getMax(Stack<TreeNode> s) {
        if (s.isEmpty()) {
            return null;
        }

        TreeNode max = s.pop();
        TreeNode leftNode = max.left;
        while (leftNode != null) {
            s.push(leftNode);
            leftNode = leftNode.right;
        }
        return max;
    }
}