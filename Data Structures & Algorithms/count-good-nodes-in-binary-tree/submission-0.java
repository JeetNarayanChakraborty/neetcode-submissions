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
        if(root.val >= maxValTillNow)
        {
            goodNodeCount++;
            getGoodNodes(root.left, root.val);
            getGoodNodes(root.right, root.val);
        }

        else
        {
            getGoodNodes(root.left, maxValTillNow);
            getGoodNodes(root.right, maxValTillNow);
        }
    }

    public int goodNodes(TreeNode root) 
    {
        if(root != null) return 0;
        getGoodNodes(root, 0);
        return goodNodeCount;
    }
}










