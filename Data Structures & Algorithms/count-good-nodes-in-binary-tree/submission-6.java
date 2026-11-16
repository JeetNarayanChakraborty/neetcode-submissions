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
    int goodNodes;

    private void countGoodNodes(TreeNode root, int currMaxNodeVal)
    {
        if(root == null) return;

        if(root.val >= currMaxNodeVal)
        {
            goodNodes++;
            currMaxNodeVal = Math.max(currMaxNodeVal, root.val);
        }

        countGoodNodes(root.left, currMaxNodeVal);
        countGoodNodes(root.right, currMaxNodeVal);
}

    public int goodNodes(TreeNode root) 
    {
        countGoodNodes(root, root.val);
        return goodNodes;
    }
}







