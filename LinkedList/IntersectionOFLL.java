/*Write a program to find the node at which the intersection of two singly linked lists begins.*/

Solution:

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        int diff=0;
        ListNode curr1=headA;
        ListNode curr2=headB;
    while(curr1!=null)
    {
        
        curr1=curr1.next;
        lenA++;
    }
        while(curr2!=null)
        {
            curr2=curr2.next;
            lenB++;
        }
        
    if(curr1!=curr2)
    {
        return null;
    }
    if(lenA>lenB)
    {
        diff=lenA-lenB;
        while(diff>0)
        {
            headA=headA.next;
            diff--;
        }
    }
    else if(lenA<lenB)
        {
             diff=lenB-lenA;
        while(diff>0)
        {
            headB=headB.next;
            diff--;
        }
        }
    while(headA!=null || headB!=null)
    {
        if(headA==headB)
        {
            return headB;
        }
        headA=headA.next;
        headB=headB.next;
    }
        return null;
    }
}

Solution 2:
Without calculating len
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}


Clean approach for solution 1:

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}


