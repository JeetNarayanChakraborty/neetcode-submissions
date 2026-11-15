class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        int counter=0;
        Map<int[], Integer> map = new HashMap<>();
        int[][] kClosestPoints = new int[k][];
        PriorityQueue<Map.Entry<int[], Integer>> minHeap = 
                            new PriorityQueue<>(Map.Entry.comparingByValue());

        for(int[] point : points)
        {
            int distance = (int) Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            map.put(point, distance);
        }

        minHeap.addAll(map.entrySet());

        while(!minHeap.isEmpty() && counter < k)
        {
            Map.Entry<int[], Integer> entry = minHeap.poll();
            int[] temp = entry.getKey();
            kClosestPoints[counter] = new int[]{temp[0], temp[1]};
            counter++;
        }

        return kClosestPoints;
    }
}
