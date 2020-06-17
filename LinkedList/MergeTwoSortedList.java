/*Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/

Solution:

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     
        ListNode l3=new ListNode();
        ListNode node3=l3;
       
       while(l1!=null && l2!=null)
       {
           if(l1.val<=l2.val)
           {
               node3.next=l1;
               l1=l1.next;
           }
           else if(l2.val<=l1.val)
           {
               node3.next=l2;
               l2=l2.next;
           }
           node3=node3.next;
       }
        if(l1!=null)
        {
            node3.next=l1;
           // l1=l1.next;
            //node3=node3.next;
        }
        if(l2!=null)
        {
            node3.next=l2;
            //l2=l2.next;
          //  node3=node3.next;
        }
        
        
        return l3.next;
    }
}
