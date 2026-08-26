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

class Solution 
{
    int leftSubtreeHeight=0;
    int rightSubtreeHeight=0;

    private boolean checkTreeBalance(TreeNode root, String subTree)
    {
        if(root == null) return true;

        checkTreeBalance(root.left, "left");
        checkTreeBalance(root.right, "right");

        if(subTree == "left") leftSubtreeHeight = 1 + Math.min(leftSubtreeHeight, rightSubtreeHeight);
        else rightSubtreeHeight = 1 + Math.min(leftSubtreeHeight, rightSubtreeHeight);

        return (Math.abs(leftSubtreeHeight - rightSubtreeHeight) <= 1);
    }

    public boolean isBalanced(TreeNode root) 
    {
        if(root == null) return true;

        return checkTreeBalance(root.left, "left") && 
               checkTreeBalance(root.right, "right");
    }
}
















