class Solution 
{
    public int longestConsecutive(int[] nums) 
    {
        if(nums.length == 0) return 0;

        int n=nums.length, currSize=1, maxSize=0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) set.add(nums[i]);

        for(int num : set)
        {
            if(!set.contains(num - 1))
            {
                while(set.contains(num + 1))
                {
                    currSize++;
                    num++;
                }

                maxSize = Math.max(maxSize, currSize);
                currSize = 1;
            }
        }

        return maxSize;
    }


}
