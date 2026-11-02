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
    int goodNodes=0;

    private void countGoodNodes(TreeNode root, int maxNodeValTillNow)
    {
        if(root == null) return;

        if(root.val >= maxNodeValTillNow) 
        {
            goodNodes++;
            maxNodeValTillNow = Math.max(maxNodeValTillNow, root.val);
        }

        countGoodNodes(root.left, maxNodeValTillNow);
        countGoodNodes(root.right, maxNodeValTillNow);
    }

    public int goodNodes(TreeNode root) 
    {
        countGoodNodes(root, 0);
        return goodNodes;
    }
}








