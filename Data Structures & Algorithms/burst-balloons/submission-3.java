class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n=nums.length;
        int[] arr = new int[n+2];
        int[][] dp = new int[n+2][n+2]; // max coins from bursting all balloons between left and right

        arr[0] = 1; // Pad the array with 1s at both ends
        arr[n+1] = 1;
        for(int i=0; i<n; i++) arr[i + 1] = nums[i];

        // len is the distance between left and right
        for(int len=2; len <= n+1; len++) 
        {
            for(int left=0; left <= n+1-len; left++) 
            {
                int right = left + len;
                
                // Try every balloon k between left and right as the last one to burst
                for(int k = left+1; k < right; k++) 
                {
                    int coins = arr[left] * arr[k] * arr[right];
                    int total = dp[left][k] + coins + dp[k][right];
                    dp[left][right] = Math.max(dp[left][right], total);
                }
            }
        }

        return dp[0][n+1];
    }
}
