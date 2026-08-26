class Solution 
{
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Put all treasure chests into the queue.
        for(int i=0; i<m; i++) 
        {
            for(int j=0; j<n; j++) 
            {
                if(grid[i][j] == 0) 
                {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) 
        {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for(int[] dir : directions) 
            {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Outside grid
                if(newX < 0 || newX >= m || newY < 0 || newY >= n) 
                {
                    continue;
                }

                // Water
                if(grid[newX][newY] == -1) 
                {
                    continue;
                }

                // Already visited
                if(grid[newX][newY] != 2147483647) 
                {
                    continue;
                }

                // Distance from current cell
                grid[newX][newY] = grid[x][y] + 1;

                queue.offer(new int[]{newX, newY});
            }
        }
    }
}





