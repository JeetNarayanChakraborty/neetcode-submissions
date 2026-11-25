class MedianFinder 
{
    // Max-heap to store the smaller half of the numbers
    private PriorityQueue<Integer> smallHalf;

    // Min-heap to store the larger half of the numbers
    private PriorityQueue<Integer> largeHalf;

    public MedianFinder() 
    {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
        largeHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) 
    {
        // add to smallHalf, then move the largest of smallHalf to largeHalf
        smallHalf.offer(num);
        largeHalf.offer(smallHalf.poll());
        
        // Keep smallHalf equal to or 1 element larger than largeHalf
        if(smallHalf.size() < largeHalf.size()) 
        {
            smallHalf.offer(largeHalf.poll());
        }
    }
    
    public double findMedian() 
    {
        if(smallHalf.size() > largeHalf.size()) 
        {
            return smallHalf.peek();
        }
        
        return (smallHalf.peek() + largeHalf.peek()) / 2.0;
    }
}
