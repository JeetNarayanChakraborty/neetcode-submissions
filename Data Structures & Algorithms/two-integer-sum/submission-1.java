class Solution 
{
    public int findIndex(int[] nums, int num)
    {
        int index=0;

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == num)
            {
                index=i;
            }
        }

        return index;
    }

    public int[] twoSum(int[] nums, int target) 
    {
        if((nums.length == 2) && (nums[0] + nums[1] == target))
        {
            return new int[]{0, 1};
        }


        HashSet<Integer> set = new HashSet<>();
        int num1=0, num2=0;

        for(int i=0; i<nums.length; i++)
        {
            set.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++)
        {
            if(set.contains(target - nums[i]))
            {
                num1 = i;
                num2 = findIndex(nums, target - nums[i]);
            }
        }

        return new int[]{num2, num1};
    }
}








