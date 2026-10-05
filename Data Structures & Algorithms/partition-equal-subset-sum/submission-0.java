class Solution 
{
    private Map<String, Boolean> dp = new HashMap<>(); 

    private boolean check(int[] nums, int n, int currSum, int targetSum)
    {
        if(n == 0) return false;
        if(currSum == targetSum) return true;

        String key = n + "," + currSum;

        if(dp.containsKey(key)) return dp.get(key);

        if(nums[n-1] + currSum <= targetSum)
        {
            boolean res = check(nums, n-1, currSum + nums[n-1], targetSum)
                       || check(nums, n-1, currSum, targetSum);
            
            dp.put(key, res);
            return res;
        }

        else
        {
            boolean res = check(nums, n-1, currSum, targetSum);
            dp.put(key, res);
            return res;
        }
    }

    public boolean canPartition(int[] nums) 
    {
        int n=nums.length, totalSum=0;

        for(int i=0; i<n; i++) totalSum += nums[i];

        if(totalSum % 2 != 0) return false;
        return check(nums, n, 0, totalSum/2);
    }
}



