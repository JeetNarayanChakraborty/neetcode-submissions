class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        int n=nums.length, minNum=Integer.MAX_VALUE, currCons=0, res=1;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++)
        {
            minNum = Math.min(minNum, nums[i]);
            set.add(nums[i]);
        }

        currCons = minNum;

        while(set.contains(currCons + 1))
        {
            res++;
            currCons += 1;
        }

        return res;
    }
}
