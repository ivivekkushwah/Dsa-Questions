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
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        StringBuilder sb = new StringBuilder();
        List<String> al = new ArrayList<>();
        sum(root, al, sb);
        int total = 0;
        for(String s : al){
            total += Integer.parseInt(s);
        }
        return total;
    }
    public void sum(TreeNode node , List<String> al, StringBuilder s){
        if(node==null)return;
        s.append(node.val);
        if(node.left==null && node.right==null){
            al.add(new String(s.toString()));
        }else{
            sum(node.left, al ,s);
            sum(node.right, al ,s);
        }
        s.deleteCharAt(s.length()-1);
    }
}