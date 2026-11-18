/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0) return null;

        ListNode merged = new ListNode(Integer.MIN_VALUE), p=merged;
        PriorityQueue<ListNode> minHeap = 
                    new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        
        for(ListNode list : lists) if(list != null) minHeap.offer(list);

        while(!minHeap.isEmpty())
        {
            ListNode node = minHeap.poll();
            p.next = new ListNode(node.val);
            p = p.next;
            if(node.next != null) minHeap.offer(node.next);
        }
        
        return merged.next;
    }
}











