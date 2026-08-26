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
    private boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if(p == null && q == null) return true;
        else if(p != null && q == null) return false;
        else if(p == null && q != null) return false;
        else if(p.val != q.val ) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private boolean checkIfSubtree(TreeNode root, TreeNode subRoot)
    {
        if(root != null)
        {
            if(root.val == subRoot.val) return isSameTree(root, subRoot);

            return checkIfSubtree(root.left, subRoot) ||
                   checkIfSubtree(root.right, subRoot);
        }

        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        return checkIfSubtree(root, subRoot);
    }
}













