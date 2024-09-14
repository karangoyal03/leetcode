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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            // post(root);
            // iterativeMethod(root);
            iterativeWithOneStack(root);
            return ans;
    }

    private void post(TreeNode root) {
        if(root == null){
            return;
        }

        post(root.left);
        post(root.right);
        ans.add(root.val);
    }

    private void iterativeMethod(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        if(root==null){
            return;
        }
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }

            if(node.right!=null){
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()){
            ans.add(stack2.pop().val);
        }
    }

    private void iterativeWithOneStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){

            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;

                if(temp == null){
                    temp = stack.pop();
                    ans.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
    }
}