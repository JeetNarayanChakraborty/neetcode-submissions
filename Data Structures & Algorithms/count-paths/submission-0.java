class Solution 
{
    private int[][] dp;
    private int[][] grid;

    private int calPaths(int[][] grid, int currX, int currY, int m, int n)
    {
        if(currX >= m || currY >= n) return 0;
        if(currX == m-1 && currY == n-1) return 1;

        if(dp[currX][currY] != -1) return dp[currX][currY];

        int totalPaths = calPaths(grid, currX+1, currY, m, n) + 
                         calPaths(grid, currX, currY+1, m, n);
        
        dp[currX][currY] = totalPaths;
        return totalPaths;
    }

    public int uniquePaths(int m, int n) 
    {
        dp = new int[m][n];
        grid =  new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);

        return calPaths(grid, 0, 0, m, n);
    }
}







