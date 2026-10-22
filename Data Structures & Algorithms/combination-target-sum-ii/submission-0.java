class Solution 
{
    private List<List<Integer>> combinations = new ArrayList<>();
    private Set<ArrayList<Integer>> set = new HashSet<>();
    private Set<Integer> used = new HashSet<>();

    private void calCombinations(int[] candidates, int n, int target, int start,
                                 int currSum, ArrayList<Integer> currCombination)
    {
        if(currSum > target) return;

        if(currSum == target)
        {
            if(!set.contains(currCombination))
            {
                combinations.add(new ArrayList<>(currCombination));
                set.add(new ArrayList<>(currCombination));
            }

            return;
        }

        for(int i=start; i<n; i++)
        {
            if(i > start && candidates[i] == candidates[i-1]) continue;

            used.add(candidates[i]); // mark as used
            currCombination.add(candidates[i]); // add element

            calCombinations(candidates, n, target, i+1, currSum+candidates[i], currCombination); 

            used.remove(candidates[i]); // backtrack
            currCombination.remove(currCombination.size()-1); // unmark as used
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        int n=candidates.length;

        Arrays.sort(candidates); 
        calCombinations(candidates, n, target, 0, 0, new ArrayList<>());
        return combinations;
    }
}





