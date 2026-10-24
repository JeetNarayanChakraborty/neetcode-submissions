class Solution 
{
    List<List<Integer>> allSubset = new ArrayList<>();

    private void findSubsets(int[] nums, int start, int n, List<Integer> temp)
    {
        allSubset.add(new ArrayList<>(temp));

        for(int i=start; i<n; i++)
        {
            temp.add(nums[i]);
            findSubsets(nums, i+1, n, temp);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) 
    {
        int n=nums.length;
        findSubsets(nums, 0, n, new ArrayList<>());
        return allSubset;
    }
}



