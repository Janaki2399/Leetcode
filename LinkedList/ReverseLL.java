/*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?*/

Recursive:

class Solution {
    public ListNode reverseList(ListNode head) {
      if(head==null)
      {
          return null;
      }
       
        if(head.next ==null)
        {
         return head;   
        }
        ListNode p=reverseList(head.next);
       
        head.next.next=head;
        head.next=null;
        return p;
    }
}

Iterative:
class Solution {
    public ListNode reverseList(ListNode head) {
      if(head==null)
      {
          return null;
      }
       
       ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=head;
        while(curr!=null)
        {
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
         return prev;
    }
   
}
