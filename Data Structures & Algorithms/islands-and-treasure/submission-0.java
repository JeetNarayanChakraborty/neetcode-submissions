class Solution 
{
    private void BFS(int[][] grid, int m, int n, int startX, int startY)
    {
        int x=0, y=0, distance=0;
        Queue<int[]> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();

        queue.add(new int[]{startX, startY});

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0; i<size; i++)
            {
                int[] pos = queue.poll();

                if(grid[pos[0]][pos[1]] == 0) grid[startX][startY] = distance;
                    
                if(x > 0 && x < m - 1 && y > 0 && y < n && grid[pos[0] + 1][pos[1]] != -1)
                {
                    queue.add(new int[]{pos[0] + 1, pos[1]});
                    visited.add(new int[]{pos[0] + 1, pos[1]});
                } 

                if(x > 0 && x < m && y > 0 && y < n && grid[pos[0] - 1][pos[1]] != -1) 
                {
                    queue.add(new int[]{pos[0] - 1, pos[1]});
                    visited.add(new int[]{pos[0] - 1, pos[1]});
                }

                if(x > 0 && x < m && y > 0 && y < n && grid[pos[0]][pos[1] - 1] != -1) 
                {
                    queue.add(new int[]{pos[0], pos[1] - 1});
                    visited.add(new int[]{pos[0], pos[1] - 1});
                }

                if(x > 0 && x < m && y > 0 && y < n - 1 && grid[pos[0]][pos[1] + 1] != -1) 
                {
                    queue.add(new int[]{pos[0], pos[1] + 1});
                    visited.add(new int[]{pos[0], pos[1] + 1});
                }
            }
            
            distance++;
        }
    }

    public void islandsAndTreasure(int[][] grid) 
    {
        int m=grid.length, n=grid[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] != -1 || grid[i][j] != 0)
                {
                    BFS(grid, m, n, i, j);
                }
            }
        } 
    }
}









