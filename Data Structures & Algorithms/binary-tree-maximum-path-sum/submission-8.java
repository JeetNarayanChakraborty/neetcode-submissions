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
    private int maxPathSumVal=Integer.MIN_VALUE;

    private int calMaxPathSum(TreeNode root)
    {
        if(root == null)
        {
            maxPathSumVal = Math.max(maxPathSumVal, root.val);
            return root.val;
        }

        int left=0;
        int right=0;

        if(root.left != null)
        {
            int t = calMaxPathSum(root.left);
            left = t > 0 ? t : 0;
        }

        if(root.right != null)
        {
            int t = calMaxPathSum(root.right);
            right = t > 0 ? t : 0;
        }

        maxPathSumVal = Math.max(maxPathSumVal, left + root.val + right);

        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) 
    {
        calMaxPathSum(root);
        return maxPathSumVal;
    }
}












