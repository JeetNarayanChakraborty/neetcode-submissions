class KthLargest 
{
    private int k;
    private PriorityQueue<Integer> maxHeap;


    public KthLargest(int k, int[] nums) 
    {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;

        for(int num : nums) maxHeap.add(num);
    }
    
    public int add(int val) 
    {
        maxHeap.add(val);

        ArrayList<Integer> temp = new ArrayList<Integer>();

        for(int i=0; i<k; i++) temp.add(maxHeap.poll());
        for(int i=0; i<k; i++) maxHeap.add(temp.get(i));

        return temp.get(k-1);
    }
}







