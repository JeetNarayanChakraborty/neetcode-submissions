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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        if(head == null || head.next == null && n == 1) return null;

        int length=0;
        ListNode p=head;

        while(p != null)
        {
            length++;
            p = p.next;
        }

        p = head;

        for(int i=0; i<length - n - 1; i++) p = p.next;

        ListNode temp = p.next.next;
        p.next.next = null;
        p.next = temp;

        return head;
    }
}









