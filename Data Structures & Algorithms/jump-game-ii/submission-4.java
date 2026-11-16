class Solution 
{
    public int jump(int[] nums) 
    {
        int n=nums.length, left=0, right=0, stepCounter=0;

        while(right < n-1)
        {
            int m = nums[left];
            for(int i=left; i<=right; i++) m = Math.max(m, i + nums[i]);
            left = right + 1;
            right = m;

            stepCounter++;
        }

        return stepCounter;
    }
}
