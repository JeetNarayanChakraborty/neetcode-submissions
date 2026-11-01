class Solution 
{
    private List<List<Integer>> permutations = new ArrayList<>();
    private Set<Integer> used = new HashSet<>();

    private void doPermutations(int[] nums, int n, ArrayList<Integer> curr)
    {
        if(curr.size() == n)
        {
            permutations.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(!used.contains(nums[i]))
            {
                used.add(nums[i]);
                curr.add(nums[i]);
                doPermutations(nums, n, curr);
                used.remove(nums[i]);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        doPermutations(nums, nums.length, new ArrayList<>());
        return permutations;
    }
}
