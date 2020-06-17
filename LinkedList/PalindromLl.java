/*Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?*/


Solution:
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        {
            return true;
        }
        Boolean ans=true;
        int midval=middlepoint(head);
        int length=findlength(head);
        if(length %2 ==0)
        {
           ans= evenpal(head,midval);
        }
        else
        {
            ans=oddpal(head,midval);
        }
        
        
        return ans;
    }
    
    public int middlepoint(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        
        int count=0;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            count++;
        }
       
        return count;
    }
    
    public int findlength(ListNode head)
    {
        ListNode nod=head;
        int count=0;
        while(nod!=null)
        { count++;
            nod=nod.next;
           
        }
        System.out.println(count);
        
        return count;
    }
    
    public Boolean evenpal(ListNode head,int count)
    {
        int c=1;
        ListNode node=head;
    while (c<count)
    {
        node=node.next;
        c++;
    }
        ListNode head2=node.next;
        node.next=null;
       
    head2=rev(head2);
    Boolean b=checkpal(head,head2);
    return b;
    }
    
     public Boolean oddpal(ListNode head,int count)
    {
         int c=1;
          ListNode node=head;
          while (c<count)
    {
        node=node.next;
        c++;
    }
        ListNode head2=node.next.next;
        node.next=null;
         
   head2=rev(head2);
    Boolean b=checkpal(head,head2);
        return b;
     }
    
    public ListNode rev(ListNode head2)
    {
       
     if(head2.next==null) 
     {
         return head2;
     }
    ListNode p=rev(head2.next);
        head2.next.next=head2;
        head2.next=null;
    return p;
    }
    
    public Boolean checkpal(ListNode head,ListNode head2)
    {
       
        if(findlength(head) != findlength(head2))
        {
            return false;
        }
        while(head!=null && head2 !=null)
        {
            if(head.val != head2.val)
            {
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
    
}


Efficient Solution:

public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

Recursive:
class Solution {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }
}
