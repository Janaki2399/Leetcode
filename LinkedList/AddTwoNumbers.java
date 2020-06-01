/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/

Solution:

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode curr1= l1;
        ListNode curr2=l2;
        ListNode add=new ListNode(0);
        ListNode curr3=add;
        int carry =0;
        int sum=0;
        while(curr1!=null || curr2!=null)
        {
            if(curr1!=null && curr2!=null)
            {
                sum=curr1.val+curr2.val+carry;
            curr1=curr1.next;
                curr2=curr2.next;
            }
            else if(curr1 !=null)
            {
                sum=curr1.val+carry;
                curr1=curr1.next;
            }
            else if(curr2!=null)
            {
                sum=curr2.val+carry;
                curr2=curr2.next;
            }
             if(sum>9)
            {
                  carry=1;
                    
            }
            else
            {
                  carry=0;
            }
            ListNode n=new ListNode(sum%10);
            curr3.next=n;
            curr3=curr3.next;
        }
        if(carry==1)
        {
            curr3.next=new ListNode(carry);
            curr3=curr3.next;     
        }
        return add.next;
    }
}


Follow up :
Without reversing the linked list and without using extra space:


        class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = getlength(l1);
        int l2Length = getlength(l2);
        if(l1Length > l2Length)
        {
            l2 = appendZeros(l2,l1Length-l2Length);
            
        }else if(l1Length < l2Length)
        {
            l1 = appendZeros(l1,l2Length-l1Length);
        }
        int carry = sum(l1,l2);
        if(carry==1)
        {
            ListNode l = new ListNode(carry);
            l.next=l1;
            l1=l;
        }
        return l1;
    }
    public int sum(ListNode l1,ListNode l2)
    {
        if(l1==null &&l2==null )
            return 0;
        else{
            int carry = sum(l1.next,l2.next);
            int val = l1.val+l2.val+carry;
           
         
            if(val>9){
                carry=1;
                l1.val= val%10;
            }else{
                 carry=0;
                l1.val=val;
            }
            System.out.print(l1.val);
            return carry;
        }
    }
    public ListNode appendZeros(ListNode listNode, int count)
    {
        for(int i=0;i<count;i++)
            {
                ListNode l = new ListNode(0);
                l.next= listNode;
                listNode=l;
            }
        return listNode;
    }
    public int getlength(ListNode n)
    {
        if(n==null)
            return 0;
        else
            return 1+getlength(n.next);
    }
}
    
Without modifying the input:



