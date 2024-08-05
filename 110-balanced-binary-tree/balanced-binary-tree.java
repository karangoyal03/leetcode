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
    public boolean isBalanced(TreeNode root) {
        return diameterCheck(root)!=-1;
    }

    private int diameterCheck(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = diameterCheck(root.left);
        int right = diameterCheck(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }

    
}