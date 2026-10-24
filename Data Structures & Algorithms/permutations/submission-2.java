class Solution 
{
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    private void calPermute(int[] nums, int n, ArrayList<Integer> currPerm)
    {
        if(currPerm.size() == n)
        {
            res.add(new ArrayList<>(currPerm));
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(used[i])  continue;

            used[i] = true; // Mark as used
            currPerm.add(nums[i]);
            
            calPermute(nums, n, currPerm); 
            
            currPerm.remove(currPerm.size() - 1); // Backtrack
            used[i] = false;  // Unmark as used
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        int n = nums.length;
        used = new boolean[n];
        calPermute(nums, n, new ArrayList<>());
        return res;
    }
}
