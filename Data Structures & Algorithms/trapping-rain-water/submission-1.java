class Solution 
{
    private int[] leftMax;
    private int[] rightMax;

    public int trap(int[] height) 
    {
        int n=height.length, currMax=0, totalWater=0;
        leftMax = new int[n];
        rightMax = new int[n];

        for(int i=0; i<n; i++)
        {
            currMax = Math.max(currMax, height[i]);
            leftMax[i] = currMax;
        }

        currMax = 0;

        for(int i=n-1; i>=0; i--)
        {
            currMax = Math.max(currMax, height[i]);
            rightMax[i] = currMax;
        }

        for(int i=0; i<n; i++)
        {
            totalWater += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return totalWater;
    }
}
