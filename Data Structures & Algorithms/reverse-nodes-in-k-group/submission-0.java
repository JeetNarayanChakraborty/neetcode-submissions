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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        ListNode current = head;
        ListNode prev = null;
        int count = 0;

        // Check if there are k nodes
        ListNode temp = head;

        while(temp != null && count < k) 
        {
            temp = temp.next;
            count++;
        }

        if(count < k) return head;

        // Reverse k nodes
        count = 0;

        while(current != null && count < k) 
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursively reverse the remaining groups
        head.next = reverseKGroup(current, k);

        return prev;
    }
}










