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
    List<Integer> rightSideNodes = new ArrayList<>();

    private void traverse(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0; i<size; i++)
            {
                TreeNode node = queue.poll();
                if(i == size - 1) rightSideNodes.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) 
    {
        if(root == null) return new ArrayList<>();
        traverse(root);
        return rightSideNodes;
    }
}










