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
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean check(TreeNode root , long left , long right){
        if(root == null) {
            return true;
        }

        if(!(root.val < right && root.val > left)) return false;
        boolean leftResult = check(root.left,left,root.val);
        boolean rightResult = check(root.right,root.val,right);
       return leftResult && rightResult;
    }
}