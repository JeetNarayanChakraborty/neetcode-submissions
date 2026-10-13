class Solution 
{
    int res;
    int[][] dp;
    int[][] directions;
    boolean[][] visited;

    private void calLongestIncreasingPath(int[][] matrix, int currPathLength, 
                                          int currX, int currY, int m, int n)
    {
        visited[currX][currY] = true;
        res = Math.max(res, currPathLength);
        dp[currX][currY] = res;

        for(int[] directions : directions)
        {
            int newX = currX + directions[0];
            int newY = currY + directions[1];

            if(newX >= 0 && newX < m && newY >= 0 
               && newX < n && !visited[newX][newY])
            {
                calLongestIncreasingPath(matrix, currPathLength + 1, newX, newY, m, n);
            }
        }

        visited[currX][currY] = false;
    }

    public int longestIncreasingPath(int[][] matrix) 
    {
        int m=matrix.length, n=matrix[0].length, maxRes=0;
        dp = new int[m][n];
        visited = new boolean[m][n];
        directions = new int[][]{{-1,  0}, {0,  1}, {1,  0}, {0, -1}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                calLongestIncreasingPath(matrix, 0, i, j, m, n);
                maxRes = Math.max(maxRes, res);

                res = 0;
                dp = new int[m][n];
                visited = new boolean[m][n];
            }
        }
        
        return maxRes;
    }
}








