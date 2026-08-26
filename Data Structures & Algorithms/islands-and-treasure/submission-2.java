class Solution 
{
    private Set<String> visited = new HashSet<>();

    private void BFS(int[][] grid, int m, int n, int startX, int startY)
    {
        int distance=0;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{startX, startY});

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0; i<size; i++)
            {
                int[] pos = queue.poll();

                int x = pos[0];
                int y = pos[1];

                if(grid[x][y] == 0) grid[startX][startY] = distance;
                    
                if(x > 0 && x < m - 1 && y > 0 && y < n && grid[x + 1][y] != -1
                   && !visited.contains(pos[0] + 1 + "," + pos[1]))
                {
                    queue.add(new int[]{pos[0] + 1, pos[1]});
                    visited.add(pos[0] + 1 + "," + pos[1]);
                } 

                if(x > 0 && x < m && y > 0 && y < n && grid[x - 1][y] != -1
                  && !visited.contains(pos[0] - 1 + "," + pos[1])) 
                {
                    queue.add(new int[]{pos[0] - 1, pos[1]});
                    visited.add(pos[0] - 1 + "," + pos[1]);
                }

                if(x > 0 && x < m && y > 0 && y < n && grid[x][y - 1] != -1
                   && !visited.contains(pos[0] + "," + (pos[1] - 1))) 
                {
                    queue.add(new int[]{pos[0], pos[1] - 1});
                    visited.add(pos[0] + "," + (pos[1] - 1));
                }

                if(x > 0 && x < m && y > 0 && y < n - 1 && grid[x][y + 1] != -1
                   && !visited.contains(pos[0] + "," + (pos[1] + 1))) 
                {
                    queue.add(new int[]{pos[0], pos[1] + 1});
                    visited.add(pos[0] + "," + (pos[1] + 1));
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
                if(!visited.contains(i + "," + j) && (grid[i][j] != -1 || grid[i][j] != 0))
                {
                    BFS(grid, m, n, i, j);
                    visited.clear();
                }
            }
        } 
    }
}









