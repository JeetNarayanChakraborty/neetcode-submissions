class Solution 
{
    public int jump(int[] nums) 
    {
        int n=nums.length, jumps=0, left=0, right=0, prevRight=0;

        for(left=0; left<n; left++)
        {
            right = left;
            prevRight = right;

            int currMax=nums[left];

            while(right < n && right <= left + nums[left])
            {
                right++;
                
                if(right < n && nums[right] > currMax)
                {
                    currMax = nums[right];
                }
            }

            if(right != prevRight) jumps++;
        }

        return jumps;
    }
}
