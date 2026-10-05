class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        int[] dp = new int[amount + 1]; // dp[i] = minimum coins needed to make amount i
        Arrays.fill(dp, amount + 1); // use amount+1 as "infinity"
        dp[0] = 0; // 0 coins needed to make amount 0
        
        for(int i=1; i<=amount; i++) 
        {
            for(int coin : coins) 
            {
                if(coin <= i) 
                {
                    // Option 1: keep current best dp[i]
                    // Option 2: use this coin → dp[i - coin] + 1
                    // Pick whichever uses fewer coins
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still "infinity" (amount + 1), it's impossible → return -1
        // Otherwise return the actual minimum count
        return dp[amount] > amount ? -1 : dp[amount];
    }
}





