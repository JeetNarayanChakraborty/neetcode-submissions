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
    private ListNode mergedHead;

    private ListNode mergeLists(ListNode head1, ListNode head2)
    {
        ListNode joinedList = new ListNode(Integer.MIN_VALUE);
        ListNode p=head1, q=head2, r=joinedList;

        while(p != null && q != null)
        {
            if(p.val < q.val)
            {
                r.next = new ListNode(p.val);
                p = p.next;
                r = r.next;
            }

            else
            {
                r.next = new ListNode(q.val);
                q = q.next;
                r = r.next;
            }
        }

        while(p != null)
        {
            r.next = new ListNode(p.val);
            p = p.next;
            r = r.next;
        }

        while(q != null)
        {
            r.next = new ListNode(q.val);
            q = q.next;
            r = r.next;
        }

        return joinedList.next;
    }

    public ListNode mergeKLists(ListNode[] lists) 
    {
        int n=lists.length, i=2;
        if(n == 0) return null;
        if(n == 1) return lists[0];

        mergedHead = mergeLists(lists[0], lists[1]);

        if(n == 2) return mergedHead;

        while(i < n) 
        {
            mergedHead = mergeLists(mergedHead, lists[i]);
            i++;
        }
        
        return mergedHead;
    }
}











