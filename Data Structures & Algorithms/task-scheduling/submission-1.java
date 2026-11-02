class Solution 
{
    private Map<Character, Integer> freqCount = new HashMap<>();
    private PriorityQueue<Integer> maxHeap = new 
                                   PriorityQueue<>(Comparator.reverseOrder());

    public int leastInterval(char[] tasks, int n) 
    {
        int minCPUCycles=0, maxFreqCharCount=0, maxFreqSimilarCount=0;

        for(char task : tasks)
        {
            freqCount.put(task, freqCount.getOrDefault(task, 0) + 1);
        }

        for(int freq : freqCount.values()) maxHeap.add(freq);

        maxFreqCharCount = maxHeap.poll();

        while(!maxHeap.isEmpty() && maxHeap.peek() == maxFreqCharCount) 
        {
            maxFreqSimilarCount++;
            maxHeap.poll();
        }

        minCPUCycles = maxFreqCharCount + ((maxFreqCharCount - 1) * n) + maxFreqSimilarCount;

        return Math.min(minCPUCycles, tasks.length);
    }
}
