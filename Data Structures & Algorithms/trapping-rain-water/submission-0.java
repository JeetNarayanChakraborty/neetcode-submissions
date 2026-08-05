class Solution 
{
    public int trap(int[] height) 
    {
        int n=height.length, totalArea=0;

        for(int i=1; i<n-1; i++)
        {
            int p=i-1, q=i+1, maxLeft=0, maxRight=0;

            while(p >= 0)
            {
                maxLeft = Math.max(maxLeft, height[p]);
                p--;
            }

            while(q < n)
            {
                maxRight = Math.max(maxRight, height[q]);
                q++;
            }

            int t = Math.min(maxLeft, maxRight);
            totalArea += Math.max(0, t - height[i]);
        }

        return totalArea;
    }
}
