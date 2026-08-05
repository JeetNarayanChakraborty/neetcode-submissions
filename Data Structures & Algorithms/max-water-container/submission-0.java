class Solution 
{
    public int maxArea(int[] heights) 
    {
        int n=heights.length, left=0, right=n-1, currArea=0, maxArea=0;

        while(left < right)
        {
            currArea = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(currArea, maxArea);

            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}
