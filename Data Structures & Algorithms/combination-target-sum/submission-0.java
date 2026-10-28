class Solution 
{
    List<List<Integer>> res = new ArrayList<>();

    private void calCombinationSum(int[] nums, int n, int currSum, int start,
                                   ArrayList<Integer> combination, int target)
    {
        if(currSum > target) return;

        if(currSum == target)
        {
            res.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i=start; i<n; i++)
        {
            combination.add(nums[i]);
            calCombinationSum(nums, n, currSum+nums[i], i, combination, target);
            combination.remove(combination.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        int n=nums.length;
        calCombinationSum(nums, n, 0, 0, new ArrayList<>(), target);
        return res;
    }
}
