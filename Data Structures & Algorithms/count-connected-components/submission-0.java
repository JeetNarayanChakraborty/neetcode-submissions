class Solution 
{
    private Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    private void makeGraph(int[][] edges)
    {
        for(int[] edge: edges)
        {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }

    private void BFS(int startNode)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);

        while(!queue.isEmpty())
        {
            int currNode = queue.poll();

            for(int neighbourNode : graph.get(currNode))
            {
                if(!visited.contains(neighbourNode))
                {
                    visited.add(neighbourNode);
                    queue.add(neighbourNode);
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) 
    {
        int componentCount=0;

        makeGraph(edges);

        for(int i=0; i<n; i++)
        {
            if(!visited.contains(i))
            {
                BFS(i);
                componentCount++;
            }
        }

        return componentCount;
    }
}







