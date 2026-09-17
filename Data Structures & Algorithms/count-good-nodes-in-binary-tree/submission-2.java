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
    int goodNodeCount;

    private void getGoodNodes(TreeNode root, int maxValTillNow)
    {
        if(root == null) return;

        if(root.val >= maxValTillNow)
        {
            goodNodeCount++;
            maxValTillNow = Math.max(maxValTillNow, root.val);
        }

        getGoodNodes(root.left, maxValTillNow);
        getGoodNodes(root.right, maxValTillNow);
    }

    public int goodNodes(TreeNode root) 
    {
        if(root == null) return 0;
        getGoodNodes(root, Integer.MIN_VALUE);
        return goodNodeCount;
    }
}










