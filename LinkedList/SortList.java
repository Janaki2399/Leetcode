Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

Solution:

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null )//this is the condition when breaking the LL after slow ..Else use prev and break it at prev
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        
        ListNode l1=sortList(head);
       ListNode l2=sortList(head2);
        
        head=merge(l1,l2);
        return head;
        
    }
    public ListNode merge(ListNode head1,ListNode head2)
    {
        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }
        if(head1.val<=head2.val)
        {
            head1.next=merge(head1.next,head2);
            return head1;
        }
        else
        {
            head2.next=merge(head1,head2.next);
            return head2;
        }
    }
