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
    List<List<Integer>> levelOrderNodes = new ArrayList<>();

    private void traverseInLevelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int len = queue.size();

            ArrayList<Integer> temp = new ArrayList<>();

            for(int i=0; i<len; i++)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            levelOrderNodes.add(new ArrayList<>(temp));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        if(root == null) return new ArrayList<>();
        traverseInLevelOrder(root);
        return levelOrderNodes;
    }
}












