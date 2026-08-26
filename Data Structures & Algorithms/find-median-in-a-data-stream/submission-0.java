class MedianFinder 
{
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double currentMedian

    public MedianFinder() 
    {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverse());
        currentMedian = 0.0;
    }
    
    public void addNum(int num) 
    {
        







    }
    
    public double findMedian() 
    {
        return currentMedian;
    }
}










