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

public class Codec 
{
    private void serializeHelper(TreeNode node, StringBuilder str) 
    {
        if(node == null) 
        {
            str.append("#,");
            return;
        }

        str.append(node.val).append(",");
        serializeHelper(node.left, str);
        serializeHelper(node.right, str);
    }

    private TreeNode build(Queue<String> tokens) 
    {
        String t = tokens.poll();
        if(t.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(t));
        node.left  = build(tokens);   //  left subtree
        node.right = build(tokens);   // then right subtree
        return node;
    }

    public String serialize(TreeNode root) 
    {
        StringBuilder str = new StringBuilder();
        serializeHelper(root, str);
        return str.toString();
    }

    public TreeNode deserialize(String data) 
    {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(tokens);
    }  
}



