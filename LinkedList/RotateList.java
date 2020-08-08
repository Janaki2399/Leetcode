/*Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL*/

Solution:

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null)
         {
             return null;
         }
      
        int n=length(head);
         k=k%n;
        while(k>0)
        {
            ListNode curr=head;
            ListNode prev=null;
            while(curr.next!=null)
            {
                 prev=curr;
                curr=curr.next;
               
            }
            prev.next=null;
            curr.next=head;
            head=curr;
            k--;
        }
        return head;
    }
    public int length(ListNode node)
    {
        if(node==null)
        {
            return 0;
        }
        return length(node.next)+1;
    }
}


Simplified:
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null)
         {
             return null;
         }
        ListNode curr=head;
        int i=1;
        
        for( i=1;curr.next!=null;i++)//finding the length
        {
            curr=curr.next;
        }
        
        int n=i;
        curr.next=head;
        
       ListNode p=head;
         for(i=1;i<n-k%n;i++) //finding the point from which it is rotated.
         {
             p=p.next;
         }
        
        head=p.next;
        p.next=null;
      
        return head;
    }
}
  
Notes:
	1.its not like arrays.you can slice it in the middle also.So use that property

