class Solution 
{
    List<List<Integer>> allSubset = new ArrayList<>();

    private void findSubsets(int[] nums, int start, int n, List<Integer> temp)
    {
        allSubset.add(new ArrayList<>(temp));

        for(int i=start; i<n; i++)
        {
            // Skip duplicates at the same recursion level
            if(i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            findSubsets(nums, i+1, n, temp);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        int n=nums.length;

        Arrays.sort(nums);
        findSubsets(nums, 0, n, new ArrayList<>());
        return allSubset;
    }
}





