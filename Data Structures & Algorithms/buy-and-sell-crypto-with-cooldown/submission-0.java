class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int n=prices.length, currMinValue=Integer.MAX_VALUE, currMaxValue=0;
        int[] max = new int[n];
        int[] min = new int[n];
        int[][] dp = new int[n][n];

        max[0] = prices[0];
        min[0] = prices[0];

        for(int i=1; i<n; i++)
        {
            max[i] = Math.min(max[i-1], prices[i]);
            min[i] = Math.max(min[i-1], prices[i]);
        }

        for(int len=1; len<=n; len++)
        {
            for(int i=0; i+len-1<n; i++)
            {
                int j = i+len-1;

                dp[i][j] = Math.max(dp[i][j], max[j] - min[j]);
            }
        }

        return dp[n-1][n-1];        
    }
}
