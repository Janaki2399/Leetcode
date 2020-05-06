/*Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
       ListNode dummy=new ListNode(0);
        dummy.next=head;
       ListNode prev=dummy;
        int i=0;
        ListNode p=head;
       while(p!=null)   
       {
           i++;
           if(i%k==0)
           {
               prev=reverse(prev,p.next);
               p=prev.next;
           }
           else
           {
               p=p.next;
           }
       }
        
        return dummy.next;
    }
    public ListNode reverse(ListNode prev,ListNode next)
    {
       ListNode p1= prev.next;
        ListNode p2=p1.next;
        while(p2!=next)
        {
            ListNode t=p2.next;
            p2.next=p1;
            p1=p2;
            p2=t;            
        }
        ListNode rnode=prev.next;
        prev.next.next=next;
        prev.next=p1;
        return rnode;
    }
}
