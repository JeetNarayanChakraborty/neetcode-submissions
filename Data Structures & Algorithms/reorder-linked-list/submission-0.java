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
    static ListNode p=null, t=null;
    static int currSize=1;
    static int flag=0;

    private void reorder(ListNode r, int n)
    {
        if(r.next != null)
        {
            reorder(r.next, n);
        }

        if(flag == 0)
        {
            ListNode q = p.next;
            p.next = r;
            r.next = q;

            p = q;
            t = q;

            currSize += 2;
        }
        
        if(currSize >= n)
        {
            flag = 1;
            t.next = null;
        }
    }

    public void reorderList(ListNode head) 
    {
        p=head;
        t=null;
        currSize=1;
        flag=0;

        int n=0;
        ListNode r=head, temp=head;
        p=head;

        while(temp != null)
        {
            n++;
            temp = temp.next;
        }

        if(head != null && n >= 3)
        {
            reorder(r, n);
        } 
    }
}








