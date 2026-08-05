class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        int maxFrequency=0, maxCount=1, minCPUCycles=Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        for(int freq : map.values()) maxHeap.add(freq);

        int l = maxHeap.size();

        for(int i=0; i<l; i++)
        {
            if(i == 0) maxFrequency = maxHeap.poll();
            if(i > 0 && maxFrequency == maxHeap.poll()) maxCount++;
        }

        minCPUCycles = maxFrequency + ((maxFrequency - 1) * n) + maxCount - 1;

        return Math.max(tasks.length, minCPUCycles);
    }
}








