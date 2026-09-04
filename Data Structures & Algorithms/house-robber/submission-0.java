class Solution 
{
    public int rob(int[] nums) 
    {
        int n=nums.length;
        
        if(n == 0) return 0;
        if(n == 1) return nums[0];

        // Exact sizing to match the nums array
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<n; i++)
        {
            // max(Skip current house, Rob current house + profit from 2 houses back)
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        // The final index holds the maximum possible profit
        return dp[n-1];
    }
}



