class Solution 
{
    private Map<String, Integer> dp = new HashMap<>();

    private int calWays(int[] nums, int n, int currIndx, int currSum, int target)
    {
        if(currIndx == 0) return currSum == target ? 1 : 0;

        String key = currIndx + "," + currSum;

        if(dp.containsKey(key)) return dp.get(key);

        int total = calWays(nums, n, currIndx-1, currSum + nums[currIndx-1], target) + 
                    calWays(nums, n, currIndx-1, currSum - nums[currIndx-1], target);
        
        dp.put(key, total);
        return total;
    }

    public int findTargetSumWays(int[] nums, int target) 
    {
        int n=nums.length;
        return calWays(nums, n, n, 0, target);
    }
}








