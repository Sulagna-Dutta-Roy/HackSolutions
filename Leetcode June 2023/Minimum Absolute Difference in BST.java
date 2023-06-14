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
    int start = Integer.MAX_VALUE;
    int end =  Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       inOrder(root);
       return end;   
    }
    public void inOrder(TreeNode root) {
        if(root.left != null) inOrder(root.left);
        end = Math.min(end,Math.abs(root.val-start));
        start = root.val;
        if(root.right != null) inOrder(root.right);
    }
}
