class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int n=nums.length, left=0, right=0, currSum=0, maxSum=Integer.MIN_VALUE;

        while(right < n)
        {
            currSum += nums[right];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0) currSum = 0;

            right++;
        }

        return maxSum;
    }
}
