class Solution 
{
    public int change(int amount, int[] coins) 
    {
        int n=coins.length;
        int[][] dp = new int[n + 1][amount + 1]; // combinations to make amount j using first i coins
         
        // There is 1 way to make amount 0 (by choosing no coins)
        for(int i=0; i<=n; i++) 
        {
            dp[i][0] = 1;
        }
        
        // Fill the 2D grid
        for(int i=1; i<=n; i++) 
        {
            int currentCoin = coins[i - 1]; // Current coin we are considering
            
            for(int j=1; j<=amount; j++) 
            {
                // Skip the current coin completely
                dp[i][j] = dp[i - 1][j];
                
                // Use the current coin (only if the coin value fits in amount j)
                if(currentCoin <= j) 
                {
                    dp[i][j] = dp[i][j] + dp[i][j - currentCoin];
                }
            }
        }
        
        // Return the final cell: using all coins to make the target amount
        return dp[n][amount];
    }
}
