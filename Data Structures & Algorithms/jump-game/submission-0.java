class Solution 
{
    public boolean canJump(int[] nums) 
    {
        int n=nums.length, currTarget=n-1;

        for(int i=n-1; i>=0; i--)
        {
            if(i + nums[i] >= currTarget) currTarget = i;
        }

        return (currTarget == 0); 
    }
}
