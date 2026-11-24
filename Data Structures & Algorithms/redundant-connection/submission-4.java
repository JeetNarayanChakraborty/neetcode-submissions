class Solution 
{
    private int[] parent;

    private void union(int node1, int node2)
    {
        parent[node1] = node2;
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

        for(int i=1; i<=n; i++) parent[i] = i;

        for(int[] edge : edges)
        {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);

            if(p1 == p2) return edge;
            union(p1, p2);
        }

        return new int[0];
    }
}
