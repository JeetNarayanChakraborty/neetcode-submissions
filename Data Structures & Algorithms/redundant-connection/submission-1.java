class Solution 
{
    // Array to track the parent (leader) of each node
    private int[] parent;

    // Find operation with Path Compression
    private int find(int node) 
    {
        if(parent[node] == node) 
        {
            return node;
        }

        // points node directly to the ultimate root leader
        return parent[node] = find(parent[node]);
    }

    // merges two components under one leader
    private void union(int root1, int root2) 
    {
        parent[root1] = root2;
    }

    public int[] findRedundantConnection(int[][] edges) 
    {
        int n = edges.length;
        parent = new int[n+1];

        // Initially, every node is its own leader
        for(int i=1; i<=n; i++) 
        {
            parent[i] = i;
        }

        // Process each edge sequentially
        for(int[] edge : edges) 
        {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            // If leaders are identical, a path already exists -> Cycle detected!
            if(rootU == rootV) 
            {
                return edge; 
            }

            // Otherwise, merge the two components
            union(rootU, rootV);
        }

        return new int[0];
    }
}







