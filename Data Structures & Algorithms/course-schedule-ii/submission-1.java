class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int counter=0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> verticesInDegree = new HashMap<>();
        List<Integer> graphNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();


        for(int[] prerequisite : prerequisites)
        {
            graph.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);        
        }
        
        for(int i=0; i<numCourses; i++) 
        {
            verticesInDegree.put(i, 0);
        }
        
        for(int[] prerequisite : prerequisites)
        {
            verticesInDegree.put(prerequisite[0], verticesInDegree.getOrDefault(prerequisite[0], 0) + 1);
        }

        for(var entry : verticesInDegree.entrySet())
        {
            if(entry.getValue() == 0) queue.add(entry.getKey());
        }

        while(!queue.isEmpty())
        {
            int node = queue.poll();
            counter++;
            graphNodes.add(node);

            List<Integer> neighbourNodes = graph.get(node);

            if(neighbourNodes != null) 
            {
                for(int neighbourNode : neighbourNodes)
                {
                    verticesInDegree.put(neighbourNode, verticesInDegree.get(neighbourNode) - 1);
                    if(verticesInDegree.get(neighbourNode) == 0) queue.add(neighbourNode);
                }
            }
        }

        if(counter != numCourses) return new int[0];
        else return graphNodes.stream().mapToInt(Integer::intValue).toArray();
    }
}
