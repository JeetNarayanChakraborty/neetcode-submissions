/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution 
{
    private Queue<Node> queueOriginal = new LinkedList<>();
    private Queue<Node> queueCopy = new LinkedList<>();

    private void BFS()
    {
        while((!queueOriginal.isEmpty()) && (!queueCopy.isEmpty()))
        {
            Node nodeOriginal = queueOriginal.poll();
            Node nodeCopy = queueCopy.poll();

            nodeCopy.val = nodeOriginal.val;

            ArrayList<Node> temp = new ArrayList<>();
            for(Node node : nodeOriginal.neighbors) temp.add(new Node(node.val));
            nodeCopy.neighbors = new ArrayList<>(temp);
            temp.clear();

            for(Node neighbor : nodeOriginal.neighbors) queueOriginal.add(neighbor);
            for(Node neighbor : nodeCopy.neighbors) queueCopy.add(neighbor);
        }
    }

    public Node cloneGraph(Node node) 
    {
        Node copyGraph = new Node();
        queueOriginal.add(node);
        queueCopy.add(copyGraph);

        BFS();

        return copyGraph;
    }
}








