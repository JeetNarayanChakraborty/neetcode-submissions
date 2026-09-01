class Solution 
{
    private HashMap<Integer, ArrayList<Integer>> graph;
    Set<Integer> visited = new HashSet<>();

    private void BFS()
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            for(int neighborNode : graph.get(node))
            {
                if(!visited.contains(neighborNode))
                {
                    queue.add(neighborNode);
                    visited.add(neighborNode);
                }
            }
        }
    }

    private boolean haveCycle()
    {
        Set<Integer> seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, -1});
        seen.add(0);

        while(!queue.isEmpty())
        {
            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];

            for(int neighbor : graph.get(node))
            {
                if(!seen.contains(neighbor))
                {
                    seen.add(neighbor);
                    queue.add(new int[]{neighbor, node});
                }
                else if(neighbor != parent)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) 
    {
        if(edges.length == 0) return false;

        graph = new HashMap<>();

        for(int[] edge : edges) 
        {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        BFS();

        return (visited.size() == n) && !haveCycle();
    }
}






