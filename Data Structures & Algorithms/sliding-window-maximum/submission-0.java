class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n=nums.length, left=0, right=k-1;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = 
                    new PriorityQueue<>(Collections.reverseOrder());

        for(int i=left; i<right; i++) maxHeap.add(nums[i]);

        while(right < n)
        {
            result.add(maxHeap.peek());

            maxHeap.remove(nums[left]);
            left++;
            right++;
            if(right < n) maxHeap.add(nums[right]);
        }

        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}






