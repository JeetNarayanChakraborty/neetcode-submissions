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
    private Map<Node, Node> map = new HashMap<>();

    private void BFS()
    {
        while((!queueOriginal.isEmpty()) && (!queueCopy.isEmpty()))
        {
            Node nodeOriginal = queueOriginal.poll();
            Node nodeCopy = queueCopy.poll();

            nodeCopy.val = nodeOriginal.val;

            ArrayList<Node> temp = new ArrayList<>();

            for(Node node : nodeOriginal.neighbors)
            {
                if(!map.containsKey(node))
                {
                    map.put(node, new Node(node.val));

                    queueOriginal.add(node);
                    queueCopy.add(map.get(node));
                }

                temp.add(map.get(node));
            }

            nodeCopy.neighbors = new ArrayList<>(temp);
            temp.clear();
        }
    }

    public Node cloneGraph(Node node) 
    {
        if(node == null) return null;

        Node copyGraph = new Node(node.val);
        map.put(node, copyGraph);

        queueOriginal.add(node);
        queueCopy.add(copyGraph);

        BFS();

        return copyGraph;
    }
}








