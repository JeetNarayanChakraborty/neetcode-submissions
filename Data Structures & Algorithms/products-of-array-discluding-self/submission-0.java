class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int n = nums.length;
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        // LEFT: product of all numbers to the left
        left[0] = 1;
        
        for(int i=1; i<n; i++) 
        {
            left[i] = left[i-1] * nums[i-1];
        }
        
        // RIGHT: product of all numbers to the right
        right[n-1] = 1;

        for(int i=n-2; i>=0; i--) 
        {
            right[i] = right[i+1] * nums[i+1];
        }
        
        // COMBINE: multiply left and right
        for(int i=0; i<n; i++) 
        {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }
}


