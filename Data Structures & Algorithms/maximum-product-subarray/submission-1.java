class Solution 
{
    public int maxProduct(int[] nums) 
    {
        int max=nums[0], min=nums[0], answer=nums[0];

        for(int i=1; i<nums.length; i++) 
        {
            int num = nums[i];

            int a = num;
            int b = num * max;
            int c = num * min;

            max = Math.max(a, Math.max(b, c));
            min = Math.min(a, Math.min(b, c));

            answer = Math.max(answer, max);
        }

        return answer;
    }
}



