class Solution 
{
    int[][] dp;
    int[][] directions;

    private int calLongestIncreasingPath(int[][] matrix, int currX, 
                                         int currY, int m, int n)
    {
        if(dp[currX][currY] != 0)
        {
            return dp[currX][currY];
        }

        int longestPath=1;

        for(int[] direction : directions)
        {
            int newX = currX + direction[0];
            int newY = currY + direction[1];

            if(newX >= 0 && newX < m && newY >= 0 && newY < n &&
               matrix[newX][newY] > matrix[currX][currY])
            {
                longestPath = Math.max(longestPath, 1 + calLongestIncreasingPath(matrix, newX, newY, m, n));
            }
        }

        dp[currX][currY] = longestPath;
        return longestPath;
    }

    public int longestIncreasingPath(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 
           || matrix[0].length == 0) return 0;

        int m=matrix.length, n=matrix[0].length, answer=0; 
        directions = new int[][]{{-1,  0}, {0,  1}, {1,  0}, {0, -1}};
        dp = new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                answer = Math.max(answer, calLongestIncreasingPath(matrix, i, j, m, n));
            }
        }

        return answer;
    }
}




