class Solution 
{
    public int maxArea(int[] heights) 
    {
        int n=heights.length, left=0, right=n-1, res=0;

        while(left < right)
        {
            int base = right - left;
            int height = Math.min(heights[left], heights[right]);
            res = Math.max(res, base * height);

            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return res;
    }
}
