class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums) maxHeap.add(n);
        for(int i=0; i<k-1; i++) maxHeap.poll();

        return maxHeap.poll();
    }
}
