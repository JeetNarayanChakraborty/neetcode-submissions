class Solution 
{
  public int[] twoSum(int[] nums, int target) 
  {
        Map<Integer, Integer> map = new HashMap<>();
        int num1=0, num2=0;

        for(int i=0; i<nums.length; i++) 
        {
            int complement = target - nums[i];

            if(map.containsKey(complement)) 
            {
                num1 = map.get(complement);
                num2 = i;
            }

            map.put(nums[i], i);
        }

        return new int[]{num1, num2};
    }
}








