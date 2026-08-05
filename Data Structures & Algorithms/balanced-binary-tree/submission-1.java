class Solution
{
    private int checkTreeBalance(TreeNode root)
    {
        if(root == null) return 0;

        int leftSubtreeHeight = checkTreeBalance(root.left);
        if(leftSubtreeHeight == -1) return -1;

        int rightSubtreeHeight = checkTreeBalance(root.right);
        if(rightSubtreeHeight == -1) return -1;

        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
            return -1;

        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    public boolean isBalanced(TreeNode root)
    {
        return checkTreeBalance(root) != -1;
    }
}