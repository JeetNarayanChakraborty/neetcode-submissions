class Solution 
{
    public int maxCoins(int[] nums) 
    {
        int n=nums.length, maxCoins=0;

        if(n == 0) return 0;

        for(int i=0; i<n; i++)
        {
            int max=0;

            for(int j=0; j<n; j++)
            {
                int left=0, mid=0, right=0;

                left = (j-1 < 0) ? left = 1 : nums[j-1];
                right = (j+1 == n) ? right = 1 : nums[j+1];
                mid = nums[j];

                int coins = left * mid * right;

                if(coins > max)
                {
                    max = coins;
                    nums[j] = 1;
                }
            }

            maxCoins += max;
        }
        
        return maxCoins;
    }
}
