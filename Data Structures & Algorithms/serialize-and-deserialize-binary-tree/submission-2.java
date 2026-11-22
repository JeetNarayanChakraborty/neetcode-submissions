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
    private void serializationHelper(TreeNode root, StringBuilder str)
    {
        if(root == null)
        {
            str.append("#,");
            return;
        }

        str.append(root.val).append(",");

        serializationHelper(root.left, str);
        serializationHelper(root.right, str);
    }

    private TreeNode deserializationHelper(Queue<String> parts)
    {
        String t = parts.poll();
        if(t.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(t));
        node.left = deserializationHelper(parts);
        node.right = deserializationHelper(parts);
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder str = new StringBuilder();
        serializationHelper(root, str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializationHelper(tokens);
    }
}






