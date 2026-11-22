class Solution 
{
    private int[] parent;

    private void union(int root1, int root2)
    {
        parent[root1] = root2;
    }

    private int findParent(int node)
    {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public int[] findRedundantConnection(int[][] edges) 
    {
        int n=edges.length;
        parent = new int[n+1];

        for(int i=1; i<=n; i++) 
        {
            parent[i] = i;
        }

        for(int[] edge : edges)
        {
            int u = findParent(edge[0]);
            int v = findParent(edge[1]);

            if(u == v) return edge;

            union(u, v);
        }

        return new int[0];
    }
}





