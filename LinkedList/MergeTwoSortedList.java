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


Recursion:

public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
