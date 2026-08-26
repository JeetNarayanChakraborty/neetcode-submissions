class Solution 
{
    public int jump(int[] nums) 
    {
        int n=nums.length, currTarget=n-1, counter=0;

        for(int i=n-1; i>=0; i--)
        {
            if(i + nums[i] == currTarget)
            {
                currTarget = i;
                counter++;
            }
        }
        
        return counter++;
    }
}
