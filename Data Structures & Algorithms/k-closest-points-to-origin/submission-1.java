class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        int[][] kClosestPoints = new int[k][2];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1])
        );

        for(int[] point : points) 
        {
            minHeap.offer(point);
        }
       
        for(int i=0; i<k; i++) 
        {
            kClosestPoints[i] = minHeap.poll();
        }

        return kClosestPoints;
    }
}
