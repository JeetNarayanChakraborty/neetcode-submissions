class Solution 
{
    public boolean hasDuplicate(int[] nums) 
    {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for(int n : nums)
        {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for(var numFrequency : frequencyMap.entrySet())
        {
            if(numFrequency.getValue() > 1) return true;
        }

        return false;
    }
}