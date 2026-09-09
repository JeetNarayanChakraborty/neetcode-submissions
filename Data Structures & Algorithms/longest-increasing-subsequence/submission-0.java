class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int n=nums.length, lis=1;
        int[] dp = new int[n]; // dp[i] = length of LIS ending at index i

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) 
        {
            for(int j=0; j<i; j++) 
            {
                if(nums[j] < nums[i]) 
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            lis = Math.max(lis, dp[i]);
        }

        return lis;
    }
}



