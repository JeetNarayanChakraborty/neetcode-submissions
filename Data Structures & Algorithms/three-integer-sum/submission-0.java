class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        int n=nums.length, first=0;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        while(first < n - 2)
        {
            while(first > 0 && nums[first] == nums[first-1]) first++;

            int second = first+1;
            int third = n - 1;

            while(second < third)
            {
                int sum = nums[first] + nums[second] + nums[third];

                if(sum == 0) 
                {
                    result.add(new ArrayList<>(List.of(nums[first], nums[second], nums[third])));

                    second++;
                    third--;

                    while(second < n && nums[second-1] == nums[second]) second++;
                    while(third >= 0 && nums[third] == nums[third+1]) third--;
                }

                else if(sum < 0) second++;
                else third--;
            }

            first++;
        }

        return result;
    }
}









