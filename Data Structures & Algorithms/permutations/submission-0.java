class Solution 
{
    List<List<Integer>> res = new ArrayList<>();

    private void calPermute(int[] nums, int n, boolean[] used, ArrayList<Integer> currPerm)
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
            
            calPermute(nums, n, used, currPerm); 
            
            currPerm.remove(currPerm.size() - 1); // Backtrack
            used[i] = false;  // Unmark as used
        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        int n = nums.length;
        boolean[] used = new boolean[n]; 
        calPermute(nums, n, used, new ArrayList<>());
        return res;
    }
}
