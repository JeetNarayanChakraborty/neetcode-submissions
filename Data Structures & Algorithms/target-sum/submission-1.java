class Solution 
{
    private Map<String, Integer> dp = new HashMap<>();

    private int calWays(int[] nums, int n, int currIndx, int currSum, int target)
    {
        if(currIndx == 0) return 0;
        else if(currSum == target) return 1;

        String key = n + "," + currSum;

        if(dp.containsKey(key)) return dp.get(key);

        if(currSum + nums[currIndx-1] <= target || 
           currSum - nums[currIndx-1] >= target)
        {
            int total = calWays(nums, n, currIndx-1, currSum + nums[currIndx-1], target) + 
                        calWays(nums, n, currIndx-1, currSum - nums[currIndx-1], target);
            
            dp.put(key, total);
            return total;
        }

        else
        {
            int total = calWays(nums, n, currIndx-1, currSum, target);
            dp.put(key, total);
            return total;
        }
    }

    public int findTargetSumWays(int[] nums, int target) 
    {
        int n=nums.length;
        return calWays(nums, n, n, 0, target);
    }
}








