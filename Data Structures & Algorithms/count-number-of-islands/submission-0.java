class Solution 
{
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;

    private void BFS(char[][] grid, int currX, int currY, int m, int n)
    {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{currX, currY});

        while(!queue.isEmpty())
        {
            int[] p = queue.poll();

            for(int[] direction : directions)
            {
                int newX = p[0] + direction[0];
                int newY = p[1] + direction[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n && 
                   grid[newX][newY] == '1' && !visited[newX][newY])
                {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }

    public int numIslands(char[][] grid) 
    {
        int islands=0, m=grid.length, n=grid[0].length;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    BFS(grid, i, j, m, n);
                    islands++;
                }
            }
        }
        
        return islands;
    }
}
