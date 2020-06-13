/*Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.*/


Solution 1:

class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return head;
        }
    
        ListNode first=head;

        ListNode second=first.next;
        head=second;
        ListNode prev=first;
        
        while(first!=null)
        {
            prev.next=second;
            if(second.next!=null)
            {
                first.next=second.next;    
            }
            else
            {
                first.next=null;
            }
            second.next=first;
            prev=first;
            if(first.next!=null && first.next.next!=null )
            {
            first=first.next;
            second=first.next;
            }
            else
            {
                break;
            }
        }
    return head;
    }
}

Solution 2: using dummy head

class Solution {
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        
        ListNode first=null;
        ListNode second=null;
        
        while(curr.next!=null && curr.next.next!=null)
        {
            first=curr.next;
            second=first.next;
            first.next=second.next;
            
            curr.next=second;
            second.next=first;
            curr=first;
        }
        return dummy.next;
    }
}
