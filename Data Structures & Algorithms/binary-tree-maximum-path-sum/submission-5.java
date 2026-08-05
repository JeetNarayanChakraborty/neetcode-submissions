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
    int maxPathSumVal=Integer.MIN_VALUE;

    private int calMaxPathSum(TreeNode root)
    {
        if(root.left == null && root.right == null)
        {
            maxPathSumVal = Math.max(maxPathSumVal, root.val);
            return root.val;
        }

        int leftSubTree=0;
        int rightSubTree=0;

        if(root.left != null) 
        {
            leftSubTree = calMaxPathSum(root.left);
            if(leftSubTree < 0) leftSubTree = 0;
        }

        if(root.right != null)
        {
            rightSubTree = calMaxPathSum(root.right);
            if(rightSubTree < 0) rightSubTree = 0;
        }

        maxPathSumVal = Math.max(maxPathSumVal, leftSubTree + root.val + rightSubTree);

        return root.val + Math.max(leftSubTree, rightSubTree);
    }

    public int maxPathSum(TreeNode root) 
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        calMaxPathSum(root);
        return maxPathSumVal;
    }
}









