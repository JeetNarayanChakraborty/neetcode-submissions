class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = 
                    new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(ListNode node : lists) 
        {
            if(node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()) 
        {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = smallest;
            if(smallest.next != null) pq.offer(smallest.next);
        }

        return dummy.next;
    }
}