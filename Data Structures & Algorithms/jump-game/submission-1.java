class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int n=nums.length, lastReacheablePos=0;

        for(int i=n-1; i>=0; i--)
        {
            if(i + nums[i] >= lastReacheablePos)
            {
                lastReacheablePos = i;
            }
        }

        return lastReacheablePos == 0;
    }
}
