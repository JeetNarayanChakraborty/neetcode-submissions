class Solution 
{
    private List<List<Integer>> permutations = new ArrayList<>();
    private Set<Integer> used = new HashSet<>();

    private void findPermutations(int[] nums, int n, ArrayList<Integer> currPermutation)
    {
        if(currPermutation.size() == n)
        {
            permutations.add(new ArrayList<>(currPermutation));
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(!used.contains(nums[i]))
            {
                used.add(nums[i]);
                currPermutation.add(nums[i]);
                findPermutations(nums, n, currPermutation);
                currPermutation.remove(currPermutation.size()-1);
                used.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        int n=nums.length;
        findPermutations(nums, n, new ArrayList<>());
        return permutations;
    }
}
